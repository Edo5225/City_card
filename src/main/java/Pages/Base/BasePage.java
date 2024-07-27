package Pages.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


import static Common.Config.EXPLICITY_WAIT;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class BasePage {
    protected WebDriver driver;
    public BasePage (WebDriver driver){
        this.driver = driver;
    }
    public void open(String url){
        driver.navigate().to(url);
    }
    public WebElement waitElementIsVisible (WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITY_WAIT)).until(ExpectedConditions.visibilityOf(element));

        return element;
    }
    public WebElement checkElementNotToClickable(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(not(ExpectedConditions.elementToBeClickable(element)));
        return element;
    }
    public WebElement checkElementToClickable(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    public void checkURLPage(String url){
        String actual = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(url));
        Assert.assertEquals(actual,url);
    }
    public void checkAmountElementOnPage(Integer count, By locator){
        waitElementIsVisible(driver.findElement(locator));
        int countElement = driver.findElements(locator).size();
        Assert.assertEquals(countElement,count);

    }




}
