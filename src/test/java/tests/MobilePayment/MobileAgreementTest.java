package tests.MobilePayment;

import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class MobileAgreementTest extends BaseTest {
    @Test
    public void checkAggrementyInMobilePage(){
        basePage.open("https://citycard.ru/");
        cityCardHomePage
                .closeCitySelector()
                .mobileService();
        cityCardMobilePage.inputNumber()
                .nextStepMobile()
                .checkAggrement();
        switchWindow();
        cityCardMobilePage.checkURLPage("https://citycard.ru/offerta.pdf");
        switchWindowBack();
    }
}
