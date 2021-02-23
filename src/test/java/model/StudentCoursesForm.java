package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class StudentCoursesForm extends PageObject {

    @FindBy(name="developerCourseId")
    private WebElement developerCourseId;

    @FindBy(name="classesBought")
    private WebElement classesBought;

    private WebElement saveButton;

    private WebElement removeButton;

    private WebElement addNewCourse;

    public StudentCoursesForm(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return this.classesBought.isDisplayed();
    }

    public void setData(String classesBought) {

        this.classesBought.clear();
        this.classesBought.sendKeys(classesBought);

    }

    public void setSaveButton(String xpath) {
        this.saveButton = driver.findElement(By.xpath(xpath));
    }

    public void setRemoveButton(String xpath) {
        this.removeButton = driver.findElement(By.xpath(xpath));
    }

    public void setAddNewCourse(String xpath) {
        this.addNewCourse = driver.findElement(By.xpath(xpath));
    }

    public WebElement getAddNewCourse() {
        return addNewCourse;
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
