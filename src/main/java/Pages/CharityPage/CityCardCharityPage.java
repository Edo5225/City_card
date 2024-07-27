package Pages.CharityPage;
import Pages.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import static Common.Config.COUNT_CHARITY;

public class CityCardCharityPage extends BasePage {
By allCharity = By.xpath("//div[@class='charity__list']/a[@href='#']");
By CharityPresentLive = By.xpath("//div[text()='Фонд \"Подари жизнь\"']");
By inputName = By.xpath("//input[@id='CUSTOMFIELD_WIREPAYER__9005_1540477842']");
By buttonNext = By.xpath("//button[@ng-click=\"submitStepPre()\"]");
By inputAmount = By.xpath("//input[@id='amount']");
By agreement = By.xpath("//label[@for='agreement']");
By buttonToThePayment = By.xpath("//span[text()='Перейти к оплате']/..");
By buttonToSPBPayment = By.xpath("//*[@id=\"payment-systems-form\"]/div[2]/div/button");
By agreementLink = By.xpath("//label[@for='agreement']/a[@href=\"https://citycard.ru/offerta.pdf\"]");
    public CityCardCharityPage(WebDriver driver) {
        super(driver);
    }
    public CityCardCharityPage SelectCharity(){
        checkAmountElementOnPage(COUNT_CHARITY, allCharity);
        driver.findElement(CharityPresentLive).click();
        return this;
    }
    public CityCardCharityPage SetName(){
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys("A D S");
        driver.findElement(buttonNext).click();
        return this;
    }
    public CityCardCharityPage SetAmount(){
        driver.findElement(inputAmount).click();
        driver.findElement(inputAmount).sendKeys("10000");
        return this;
    }
    public CityCardCharityPage agreementInToTrueAndCheckClickablePaymentButton() {
        checkElementNotToClickable(driver.findElement(buttonToThePayment));
        driver.findElement(agreement).click();
        checkElementToClickable(driver.findElement(buttonToThePayment));
        return this;
    }
    public CityCardCharityPage buttonPayment() {
        driver.findElement(buttonToThePayment).click();
        return this;
    }


    public CityCardCharityPage buttonToSBP() {
        driver.findElement(buttonToSPBPayment).click();
        return this;
    }
    public CityCardCharityPage switchToFrame(){
        driver.switchTo().frame("pawassistantiframe");
        return this;
    }

    public CityCardCharityPage checkAgreement(){
        driver.findElement(agreementLink).click();
        return this;
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void checkElementAttribute(String AttributeName, String AttributeValue, By Locator){
        WebElement ElementGetAttribute = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
        String NameAtt = ElementGetAttribute.getAttribute(AttributeName);
        Assert.assertEquals(AttributeValue,NameAtt);
    }

}
