package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentForm extends PageObject {

    @FindBy(name="name")
    private WebElement name;

    @FindBy(name="surname")
    private WebElement surname;

    @FindBy(name="accountName")
    private WebElement accountName;

    @FindBy(name="email")
    private WebElement email;

    @FindBy(name="bankCardNumber")
    private WebElement bankCardNumber;

    private WebElement saveButton;

    private WebElement removeButton;

    public StudentForm(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return name.isDisplayed();
    }

    public void enterData(String name, String surname, String accountName, String email, String password,
                          String bankCardNumber){
        this.name.clear();
        this.name.sendKeys(name);

        this.surname.clear();
        this.surname.sendKeys(surname);

        this.accountName.clear();
        this.accountName.sendKeys(accountName);

        this.email.clear();
        this.email.sendKeys(email);

        this.bankCardNumber.clear();
        this.bankCardNumber.sendKeys(bankCardNumber);
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
