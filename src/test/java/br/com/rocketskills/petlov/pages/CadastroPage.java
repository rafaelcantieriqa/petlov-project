package br.com.rocketskills.petlov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CadastroPage {

    @SuppressWarnings("unused")
    private WebDriver driver;
    private WebDriverWait wait;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "h1")
    private WebElement title;

    @FindBy(css = "input[placeholder='Nome do ponto de doação']")
    private WebElement nameField;

    @FindBy(css = "input[placeholder='E-mail']")
    private WebElement emailField;

    @FindBy(css = "input[name=cep]")
    private WebElement cepField;

    @FindBy(css = "input[value='Buscar CEP']")
    private WebElement cepButton;

    @FindBy(css = "input[name=addressNumber]")
    private WebElement numberField;

    @FindBy(css = "input[name=addressDetails]")
    private WebElement detailsField;

    @FindBy(xpath = "//*[@id='signup-page']/form/fieldset[3]/ul/li[1]")
    private WebElement categoryOption;

    @FindBy(css = "button[class=button-register]")
    private WebElement registerButton;

    @FindBy(css = "#success-page p")
    private WebElement successMessage;

    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    public void fillForm(String name, String email, String cep, String number, String details) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        cepField.sendKeys(cep);
        cepButton.click();
        numberField.sendKeys(number);
        detailsField.sendKeys(details);
    }

    public void selectCategory() {
        categoryOption.click();
    }

    public void submitForm() {
        registerButton.click();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }
}
