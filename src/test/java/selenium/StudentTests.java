package selenium;

import model.ReceiptPage;
import model.StudentCoursesForm;
import model.StudentForm;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class StudentTests extends FunctionalTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void newStudent() {
        //Test method for adding a new student
        driver.get("http://localhost:3000/student/");
        log.info(() -> "Successfully enter the localhost:3000/student for adding a new student. time: " + LocalDateTime.now());

        //Button for opening student form
        WebElement buttonPlus = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/button"));
        buttonPlus.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        StudentForm studentForm = new StudentForm(driver);
        Assertions.assertTrue(studentForm.isInitialized());
        log.info(() -> "Student form is initialized! time: " +  LocalDateTime.now());
        //I found save button with xpath
        studentForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[6]/button[1]");
        studentForm.newStudentData("Veljko","Vukovic", "veca22",
                "veljko544@gmail.com", "vecaveca2", "4231");

        ReceiptPage newStudentPage = studentForm.submitSave();
        Assertions.assertTrue(newStudentPage.isInitialized());
        log.info(() -> "Submit new student was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void editStudent() {
        //Test method for edit student
        driver.get("http://localhost:3000/student");
        log.info(() -> "Successfully enter the localhost:3000/student for edit student. time: " + LocalDateTime.now());
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        StudentForm studentForm = new StudentForm(driver);
        Assertions.assertTrue(studentForm.isInitialized());
        log.info(() -> "Student form is initialized! time: " +  LocalDateTime.now());
        //I found save button with xpath
        studentForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[7]/button[1]");
        studentForm.editStudentData("Nikola","Nikolic");
        ReceiptPage editStudentPage = studentForm.submitSave();
        Assertions.assertTrue(editStudentPage.isInitialized());
        log.info(() -> "Editing student was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void removeStudent() {
        //Test method for removing student
        driver.get("http://localhost:3000/student");
        log.info(() -> "Successfully enter the localhost:3000/student for remove student. time: " + LocalDateTime.now());
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        StudentForm studentForm = new StudentForm(driver);
        Assertions.assertTrue(studentForm.isInitialized());
        log.info(() -> "Student form is initialized! time: " +  LocalDateTime.now());
        //I found remove button with xpath
        studentForm.setRemoveButton("/html/body/div/div/main/div[2]/div[2]/form/div[7]/button[2]");
        ReceiptPage removeStudentPage = studentForm.submitRemove();
        Assertions.assertTrue(removeStudentPage.isInitialized());
        log.info(() -> "Deleting student was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void addCoursesToStudentTest() {
        //Test method for adding courses to student
        driver.get("http://localhost:3000/student");
        log.info(() -> "Successfully enter the localhost:3000/student for adding new course to student. time: " + LocalDateTime.now());
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        StudentForm studentForm = new StudentForm(driver);
        studentForm.setToggleCoursesButton("/html/body/div/div/main/div[2]/div[2]/form/div[6]/button");
        studentForm.getToggleCoursesButton().click();

        StudentCoursesForm studentCoursesForm = new StudentCoursesForm(driver);
        studentCoursesForm.setAddNewCourse("/html/body/div/div/main/div[2]/div[3]/div[1]/button");
        studentCoursesForm.getAddNewCourse().click();
        Assertions.assertTrue(studentCoursesForm.isInitialized());
        log.info(() -> "Student form is initialized! time: " +  LocalDateTime.now());
        //Click select form
        WebElement select = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[1]/div/div"));
        select.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click one option
        WebElement select_option = driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[7]"));
        select_option.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        studentCoursesForm.setData("4");

        //Set save button and click it
        studentCoursesForm.setSaveButton("/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[3]/button[1]");
        ReceiptPage addCoursesToStudentPage = studentCoursesForm.submitSave();
        Assertions.assertTrue(addCoursesToStudentPage.isInitialized());
        log.info(() -> "Adding courses was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void editStudentCoursesBought() {
        //Test method for editing course
        driver.get("http://localhost:3000/student");
        log.info(() -> "Successfully enter the localhost:3000/student for editing student course bought. time: " + LocalDateTime.now());
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        StudentForm studentForm = new StudentForm(driver);
        studentForm.setToggleCoursesButton("/html/body/div/div/main/div[2]/div[2]/form/div[6]/button");
        studentForm.getToggleCoursesButton().click();

        StudentCoursesForm studentCoursesForm = new StudentCoursesForm(driver);
        WebElement clickCourseInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickCourseInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(studentCoursesForm.isInitialized());
        log.info(() -> "Student form is initialized! time: " +  LocalDateTime.now());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        studentCoursesForm.setData("2");

        //Set save button and click it
        studentCoursesForm.setSaveButton("/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[3]/button[1]");
        ReceiptPage editCoursePage = studentCoursesForm.submitSave();
        Assertions.assertTrue(editCoursePage.isInitialized());
        log.info(() -> "Editing course bought for student was successfully! time: " + LocalDateTime.now());
    }

    @Test
    public void deleteStudentCourse() {
        //Test method for deleting courses to student
        driver.get("http://localhost:3000/student");
        log.info(() -> "Successfully enter the localhost:3000/student for deleting student course. time: " + LocalDateTime.now());
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div/div"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        StudentForm studentForm = new StudentForm(driver);
        studentForm.setToggleCoursesButton("/html/body/div/div/main/div[2]/div[2]/form/div[6]/button");
        studentForm.getToggleCoursesButton().click();

        StudentCoursesForm studentCoursesForm = new StudentCoursesForm(driver);
        WebElement clickCourseInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickCourseInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertTrue(studentCoursesForm.isInitialized());
        log.info(() -> "Student form is initialized! time: " +  LocalDateTime.now());

        //Set remove button and click it
        studentCoursesForm.setRemoveButton("/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[3]/button[3]");
        ReceiptPage removeStudentCoursePage = studentCoursesForm.submitRemove();
        Assertions.assertTrue(removeStudentCoursePage.isInitialized());
        log.info(() -> "Removing course for student was successfully! time: " + LocalDateTime.now());
    }
}
