package tests.CharityPage;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class CharityAgreementTest extends BaseTest {
    @Test
    public void checkAggreementInCharityPage(){
        basePage.open("https://citycard.ru/");
        cityCardHomePage
                .closeCitySelector()
                .charityService();
        cityCardCharityPage
                .SelectCharity()
                .SetName()
                .SetAmount()
                .agreementInToTrueAndCheckClickablePaymentButton()
                .checkAgreement();
        switchWindow();
        cityCardCharityPage.checkURLPage("https://citycard.ru/offerta.pdf");
        switchWindowBack();


    }
}
