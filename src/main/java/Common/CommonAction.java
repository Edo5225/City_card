package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static Common.Config.*;

public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction() {
    }

    public static WebDriver createDriver(){
        if (driver==null){
            switch (PLATFORM_AND_BROWSER){
                case "win_chrome":
                    System.setProperty("webdriver.driver.chromedriver", "src/main/java/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                default:
                    Assert.fail("Некорректная платформа/браузер" + PLATFORM_AND_BROWSER);


            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(TIME_OUTS_IMPLICIT, TimeUnit.SECONDS);


        }
        return driver;
    }
}
