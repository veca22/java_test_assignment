package selenium;

import model.ReceiptPage;
import model.StudentForm;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

public class StudentFormTest extends FunctionalTest {

    @Test
    public void newStudent() {
        //Test method for adding a new student
        driver.get("http://localhost:3000/student/");

        //Button for opening student form
        WebElement buttonPlus = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/button"));
        buttonPlus.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        StudentForm studentForm = new StudentForm(driver);
        Assertions.assertTrue(studentForm.isInitialized());
        //I found save button with xpath
        studentForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[6]/button[1]");
        studentForm.enterData("Veljko","Vukovic", "veca22",
                "veljko544@gmail.com", "vecaveca2", "4231");

        ReceiptPage newStudentPage = studentForm.submitSave();
        Assertions.assertTrue(newStudentPage.isInitialized());
    }

    /*
    @Test
    public void removeStudent() {
        //Test method for adding a new student
        driver.get("http://localhost:3000/student/new");
        StudentForm studentForm = new StudentForm(driver);
        Assertions.assertTrue(studentForm.isInitialized());
        //I found save button with xpath
        studentForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[6]/button[1]");
        studentForm.enterData("Veljko","Vukovic", "veca22",
                "veljko544@gmail.com", "vecaveca2", "4231");

        ReceiptPage newStudentPage = studentForm.submitRemove();
        Assertions.assertTrue(newStudentPage.isInitialized());
    }.
    */
}
