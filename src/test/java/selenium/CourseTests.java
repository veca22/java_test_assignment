package selenium;

import model.CourseForm;
import model.ReceiptPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class CourseTests extends FunctionalTest {

    @Test
    public void newCourse() {
        //Test method for adding a new course
        driver.get("http://localhost:3000/course");

        //Button for opening course form
        WebElement buttonPlus = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/button"));
        buttonPlus.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CourseForm courseForm = new CourseForm(driver);
        Assertions.assertTrue(courseForm.isInitialized());
        //I found save button with xpath
        courseForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[4]/button[1]");
        courseForm.newCourseForm("Course1","23", "3");

        ReceiptPage newCourseForm = courseForm.submitSave();
        Assertions.assertTrue(newCourseForm.isInitialized());
    }

    @Test
    public void editCourse() {
        //Test method for edit course
        driver.get("http://localhost:3000/course");
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CourseForm courseForm = new CourseForm(driver);
        Assertions.assertTrue(courseForm.isInitialized());
        //I found save button with xpath
        courseForm.setSaveButton("/html/body/div/div/main/div[2]/div[2]/form/div[4]/button[1]");
        courseForm.editCourseForm("Course2");
        ReceiptPage editCoursePage = courseForm.submitSave();
        Assertions.assertTrue(editCoursePage.isInitialized());
    }

    @Test
    public void removeCourse() {
        //Test method for removing course
        driver.get("http://localhost:3000/course");
        //Click on element in table
        WebElement clickInTable = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div/div[1]"));
        clickInTable.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CourseForm courseForm = new CourseForm(driver);
        Assertions.assertTrue(courseForm.isInitialized());
        //I found remove button with xpath
        courseForm.setRemoveButton("/html/body/div/div/main/div[2]/div[2]/form/div[4]/button[2]");
        ReceiptPage removeCoursePage = courseForm.submitRemove();
        Assertions.assertTrue(removeCoursePage.isInitialized());
    }

}
