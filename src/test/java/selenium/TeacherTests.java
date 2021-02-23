package selenium;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TeacherTests extends FunctionalTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void newTeacher() {
        //Test method for adding a new teacher
        driver.get("http://localhost:3000/teacher");
        log.info(() -> "Successfully enter the localhost:3000/teacher for adding a new teacher. time: " + LocalDateTime.now());

        //Button for opening teacher form
        WebElement buttonPlus = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/button"));
        buttonPlus.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TeacherForm teacherForm = new TeacherForm(driver);
        Assertions.assertTrue(teacherForm.isInitialized());
        log.info(() -> "Teacher form is initialized! time: " +  LocalDateTime.now());
        //I found save button with xpath
        teacherForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[4]/button[1]");
        teacherForm.newTeacher("Mirko","Vukovic", "mirko@gmail.com");

        ReceiptPage newTeacherForm = teacherForm.submitSave();
        log.info(() -> "Submit new teacher was successfully! time: " + LocalDateTime.now());
        Assertions.assertTrue(newTeacherForm.isInitialized());
    }

    @Test
    public void editTeacher() {
        //Test method for edit teacher
        driver.get("http://localhost:3000/teacher");
        log.info(() -> "Successfully enter the localhost:3000/teacher for edit teacher. time: " +  LocalDateTime.now());
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TeacherForm teacherForm = new TeacherForm(driver);
        Assertions.assertTrue(teacherForm.isInitialized());
        log.info(() -> "Teacher form is initialized! time: " +  LocalDateTime.now());
        //I found save button with xpath
        teacherForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[5]/button[1]");
        teacherForm.editTeacherData("Marko","Markovic");
        ReceiptPage editTeacherPage = teacherForm.submitSave();
        Assertions.assertTrue(editTeacherPage.isInitialized());
        log.info(() -> "Edit teacher was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void removeTeacher() {
        //Test method for removing teacher
        driver.get("http://localhost:3000/teacher");
        log.info(() -> "Successfully enter the localhost:3000/teacher for remove teacher. time: " +  LocalDateTime.now());
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TeacherForm teacherForm = new TeacherForm(driver);
        Assertions.assertTrue(teacherForm.isInitialized());
        log.info(() -> "Teacher form is initialized! time: " +  LocalDateTime.now());
        //I found remove button with xpath
        teacherForm.setRemoveButton("/html/body/div/div/main/div[2]/div[2]/form/div[5]/button[2]");
        ReceiptPage removeTeacherPage = teacherForm.submitRemove();
        Assertions.assertTrue(removeTeacherPage.isInitialized());
        log.info(() -> "Remove teacher was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void assignCourseTeacher() {
        //Test method for assigns teacher courses
        driver.get("http://localhost:3000/teacher");
        log.info(() -> "Successfully enter the localhost:3000/teacher for assign teacher course. time: " +  LocalDateTime.now());
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
        log.info(() -> "Assign teacher course was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void deleteTeacherCourse() {
        //Test method for unassigne teacher course
        driver.get("http://localhost:3000/teacher");
        log.info(() -> "Successfully enter the localhost:3000/teacher for unassign teacher course. time: " +  LocalDateTime.now());
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
        log.info(() -> "Unassign teacher course was successfully! time: " + LocalDateTime.now());
    }
}
