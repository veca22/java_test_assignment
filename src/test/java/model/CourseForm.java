package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseForm extends PageObject {

    @FindBy(name="developerCourseName")
    private WebElement developerCourseName;

    @FindBy(name="costPerClass")
    private WebElement costPerClass;

    @FindBy(name="classesPerWeek")
    private WebElement classesPerWeek;

    private WebElement saveButton;

    private WebElement removeButton;

    public boolean isInitialized() {
        return this.developerCourseName.isDisplayed();
    }

    public CourseForm(WebDriver driver) {
        super(driver);
    }

    public void newCourseForm(String developerCourseName, String costPerClass, String classesPerWeek) {
        this.developerCourseName.clear();
        this.developerCourseName.sendKeys(developerCourseName);

        this.costPerClass.clear();
        this.costPerClass.sendKeys(costPerClass);

        this.classesPerWeek.clear();
        this.classesPerWeek.sendKeys(classesPerWeek);
    }

    public void editCourseForm(String developerCourseName) {
        this.developerCourseName.clear();
        this.developerCourseName.sendKeys(developerCourseName);
    }
    public void setSaveButton(String xpath) {
        this.saveButton = driver.findElement(By.xpath(xpath));
    }

    public void setRemoveButton(String xpath) {
        this.removeButton = driver.findElement(By.xpath(xpath));
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
