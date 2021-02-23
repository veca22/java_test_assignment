package selenium;

import model.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TeacherTests extends FunctionalTest {

    @Test
    public void newTeacher() {
        //Test method for adding a new teacher
        driver.get("http://localhost:3000/teacher");

        //Button for opening teacher form
        WebElement buttonPlus = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/button"));
        buttonPlus.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TeacherForm teacherForm = new TeacherForm(driver);
        Assertions.assertTrue(teacherForm.isInitialized());
        //I found save button with xpath
        teacherForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[4]/button[1]");
        teacherForm.newTeacher("Mirko","Vukovic", "mirko@gmail.com");

        ReceiptPage newTeacherForm = teacherForm.submitSave();
        Assertions.assertTrue(newTeacherForm.isInitialized());
    }

    @Test
    public void editTeacher() {
        //Test method for edit teacher
        driver.get("http://localhost:3000/teacher");
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TeacherForm teacherForm = new TeacherForm(driver);
        Assertions.assertTrue(teacherForm.isInitialized());
        //I found save button with xpath
        teacherForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[5]/button[1]");
        teacherForm.editTeacherData("Marko","Markovic");
        ReceiptPage editTeacherPage = teacherForm.submitSave();
        Assertions.assertTrue(editTeacherPage.isInitialized());
    }

    @Test
    public void removeTeacher() {
        //Test method for removing teacher
        driver.get("http://localhost:3000/teacher");
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TeacherForm teacherForm = new TeacherForm(driver);
        Assertions.assertTrue(teacherForm.isInitialized());
        //I found remove button with xpath
        teacherForm.setRemoveButton("/html/body/div/div/main/div[2]/div[2]/form/div[5]/button[2]");
        ReceiptPage removeTeacherPage = teacherForm.submitRemove();
        Assertions.assertTrue(removeTeacherPage.isInitialized());
    }

    @Test
    public void assignCourseTeacher() {
        //Test method for assigns teacher courses
        driver.get("http://localhost:3000/teacher");
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TeacherForm teacherForm = new TeacherForm(driver);
        teacherForm.setToggleCoursesButton("/html/body/div/div/main/div[2]/div[2]/form/div[4]/button");
        teacherForm.getToggleCoursesButton().click();

        TeacherCourseForm teacherCourseForm = new TeacherCourseForm(driver);
        teacherCourseForm.setAssignNewCourse("/html/body/div/div/main/div[2]/div[3]/div[1]/button");
        teacherCourseForm.getAssignNewCourse().click();
        //Click select form
        WebElement select = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[1]/div/div"));
        select.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click one option
        WebElement select_option = driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[10]"));
        select_option.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Set save button and click it
        teacherCourseForm.setSaveButton("/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[2]/button[1]");
        ReceiptPage assignTeacherCourses = teacherCourseForm.submitSave();
        Assertions.assertTrue(assignTeacherCourses.isInitialized());
    }

    @Test
    public void deleteTeacherCourse() {
        //Test method for unassigne teacher course
        driver.get("http://localhost:3000/teacher");
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TeacherForm teacherForm = new TeacherForm(driver);
        teacherForm.setToggleCoursesButton("/html/body/div/div/main/div[2]/div[2]/form/div[4]/button");
        teacherForm.getToggleCoursesButton().click();

        //Select element in table
        TeacherCourseForm teacherCourseForm = new TeacherCourseForm(driver);
        WebElement clickCourseInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[1]/div[1]"));
        clickCourseInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Set remove button and click it
        teacherCourseForm.setRemoveButton("/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[2]/button[1]");
        ReceiptPage removeTeacerCoursePage = teacherCourseForm.submitRemove();
        Assertions.assertTrue(removeTeacerCoursePage.isInitialized());
    }
}
