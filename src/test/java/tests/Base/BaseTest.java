package tests.Base;
import Common.CommonAction;
import Pages.Base.BasePage;
import Pages.CharityPage.CityCardCharityPage;
import Pages.CityCards.CityCardHomePage;
import Pages.Mobile.CityCardMobilePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import java.time.Duration;
import java.util.Set;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CityCardHomePage cityCardHomePage = new CityCardHomePage(driver);
    protected CityCardMobilePage cityCardMobilePage = new CityCardMobilePage(driver);
    protected CityCardCharityPage cityCardCharityPage = new CityCardCharityPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected By SbpQrImg = By.xpath("//img[@class='sbp-qr']");

    public void switchToAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();
    }
    protected void switchToNewWindow(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String window1 = driver.getWindowHandle();
        js.executeScript("window.open()");
        Set<String> currentWindows = driver.getWindowHandles();

        String window2 = null;
        for (String window : currentWindows){
         if (!window.equals(window1)){
                window2 = window;
                break;
        }
    }
        driver.switchTo().window(window2);
    }
    protected void switchWindow(){
        String window1 = driver.getWindowHandle();
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;
        for (String window : currentWindows){
            if (!window.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
    }
    protected void switchWindowBack(){
        String window1 = driver.getWindowHandle();
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;
        for (String window : currentWindows){
            if (!window.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
    }


@AfterSuite(alwaysRun = true)
    public void quite(){
        driver.quit();
}
}



