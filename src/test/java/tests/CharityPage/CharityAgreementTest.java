package tests.CharityPage;

//import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class CharityAgreementTest extends BaseTest {
    @Test
//    @Description("[pos]Переход на страницу пользовательского соглашения со страницы благотворительности")
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
