package Pages.CityCards;
import Pages.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityCardHomePage  extends BasePage{

    public CityCardHomePage(WebDriver driver) {
        super(driver);
    }
    By selectMobileService = By.xpath("//a[@href='/mobile/']");
    By selectCharityService = By.xpath("//a[@href='/charity/']");
    By closeJSSelectorCity = By.xpath("//span[@class='link-close js-close']");

    public CityCardHomePage mobileService(){
        driver.findElement(selectMobileService).click();
        return this;
    }

    public CityCardHomePage charityService(){
        driver.findElement(selectCharityService).click();
        return this;
    }
    public CityCardHomePage closeCitySelector(){
        driver.findElement(closeJSSelectorCity).click();
        return this;
    }


}
