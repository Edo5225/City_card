package Pages.Mobile;
import AdditionalTools.PhoneNumber;
import Pages.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityCardMobilePage extends BasePage implements PhoneNumber {
    By inputMoBileNumber = By.xpath("//input[@name='CUSTOMFIELD_phone__cellular_mask']");
    By nextStep = By.xpath("//button[@class='next_btn btn btn_approve']");
    By otherAmount = By.xpath("//label[text()='Другая']");
    By inputAmount = By.xpath("//input[@id='amount']");
    By agreement = By.xpath("//label[@for='agreement']");
    By buttonToThePayment = By.xpath("//*[@id=\"provider-step-pay\"]/div[3]/button");
    By newCardRadioButton = By.xpath("//label[@for='unitId_65115b38183165d4cf0b5fd3']");
    By buttonToAddNewCardAndPayment = By.xpath("//*[@id=\"payment-systems-form\"]/div[2]/div/button");
    By inputCardNumber = By.xpath("//input[@name='additionalParameters.cardNumber']");
    By inputCardMonth = By.xpath("//input[@id='cardExpirationMonth']");
    By inputCardYear = By.xpath("//input[@id='cardExpirationYear']");
    By inputCardCVV = By.xpath("//input[@id='additionalParameters_cardCVV2']");
    By frameLocator = By.xpath("//*[@id=\"pawassistantiframe\"]");
    By agreementLink = By.xpath("//label[@for='agreement']/a[@href=\"https://citycard.ru/offerta.pdf\"]");


    public CityCardMobilePage(WebDriver driver) {
        super(driver);
    }

    public CityCardMobilePage inputNumber() {
        driver.findElement(inputMoBileNumber).click();
        driver.findElement(inputMoBileNumber).sendKeys("9191356358");
        return this;
    }

    public CityCardMobilePage nextStepMobile() {
        driver.findElement(nextStep).click();
        return this;
    }

    public CityCardMobilePage buttonOtherAmountAndSend() {
        driver.findElement(otherAmount).click();
        driver.findElement(inputAmount).click();
        driver.findElement(inputAmount).clear();
        driver.findElement(inputAmount).sendKeys("0.01");
        return this;
    }
    public CityCardMobilePage checkAggrement(){
        driver.findElement(agreementLink).click();
        return this;
    }

    public CityCardMobilePage agreementInToTrueAndCheckClickablePaymentButton() {
        checkElementNotToClickable(driver.findElement(buttonToThePayment));
        driver.findElement(agreement).click();
        checkElementToClickable(driver.findElement(buttonToThePayment));
        return this;
    }

    public CityCardMobilePage buttonPayment() {
        driver.findElement(buttonToThePayment).click();
        return this;
    }

    public CityCardMobilePage radioButtonCard() {
        driver.findElement(newCardRadioButton).click();
        return this;
    }

    public CityCardMobilePage buttonToAddNewCard() {
        driver.findElement(buttonToAddNewCardAndPayment).click();
        return this;
    }

    public CityCardMobilePage completionCardFields() {
        driver.findElement(inputCardNumber).click();
        driver.findElement(inputCardNumber).sendKeys("4506909324274797");
        driver.findElement(inputCardCVV).click();
        driver.findElement(inputCardCVV).sendKeys("327");
        driver.findElement(inputCardYear).click();
        driver.findElement(inputCardYear).sendKeys("22");
        driver.findElement(inputCardMonth).click();
        driver.findElement(inputCardMonth).sendKeys("06");
        return this;
    }
    public CityCardMobilePage switchToFrame(){
        driver.switchTo().frame("pawassistantiframe");
        return this;
    }
}



