package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeacherForm extends PageObject {

    @FindBy(name="teacherName")
    private WebElement teacherName;

    @FindBy(name="teacherSurname")
    private WebElement teacherSurname;

    @FindBy(name="teacherEmail")
    private WebElement teacherEmail;

    private WebElement saveButton;

    private WebElement removeButton;

    private WebElement toggleCoursesButton;

    public TeacherForm(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return this.teacherName.isDisplayed();
    }

    public void newTeacher(String teacherName, String teacherSurname, String teacherEmail){
        this.teacherName.clear();
        this.teacherName.sendKeys(teacherName);

        this.teacherSurname.clear();
        this.teacherSurname.sendKeys(teacherSurname);

        this.teacherEmail.clear();
        this.teacherEmail.sendKeys(teacherEmail);
    }

    public void editTeacherData(String teacherName, String teacherSurname) {
        this.teacherName.clear();
        this.teacherName.sendKeys(teacherName);

        this.teacherSurname.clear();
        this.teacherSurname.sendKeys(teacherSurname);
    }

    public void setSaveButton(String xpath) {
        this.saveButton = driver.findElement(By.xpath(xpath));
    }

    public void setRemoveButton(String xpath) {
        this.removeButton = driver.findElement(By.xpath(xpath));
    }

    public void setToggleCoursesButton(String xpath) {
        this.toggleCoursesButton = driver.findElement(By.xpath(xpath));
    }

    public WebElement getToggleCoursesButton() {
        return toggleCoursesButton;
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
