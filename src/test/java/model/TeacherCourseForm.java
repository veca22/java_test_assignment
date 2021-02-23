package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeacherCourseForm extends PageObject {

    @FindBy(name="developerCourseId")
    private WebElement developerCourseId;

    private WebElement saveButton;

    private WebElement removeButton;

    private WebElement assignNewCourse;

    public TeacherCourseForm(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return this.saveButton.isDisplayed();
    }

    public void setSaveButton(String xpath) {
        this.saveButton = driver.findElement(By.xpath(xpath));
    }

    public void setRemoveButton(String xpath) {
        this.removeButton = driver.findElement(By.xpath(xpath));
    }

    public void setAssignNewCourse(String xpath) {
        this.assignNewCourse = driver.findElement(By.xpath(xpath));
    }

    public WebElement getAssignNewCourse() {
        return assignNewCourse;
    }

    public ReceiptPage submitSave(){
        this.saveButton.click();
        return new ReceiptPage(driver);
    }

    public ReceiptPage submitRemove(){
        this.removeButton.click();
        return new ReceiptPage(driver);
    }
}
