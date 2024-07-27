package tests.CharityPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class CharityTest extends BaseTest {
    @Test
    @Description("[pos]Перевод на благотворительность")
    public void checkPaymentCharity(){
        basePage.open("https://citycard.ru");
        cityCardHomePage
                .closeCitySelector()
                .charityService();
        cityCardCharityPage.SelectCharity()
                .SetName()
                .SetAmount()
                .agreementInToTrueAndCheckClickablePaymentButton()
                .buttonPayment()
                .buttonToSBP()
                .switchToFrame()
                .checkElementAttribute("class", "sbp-qr", SbpQrImg);
    }

}
