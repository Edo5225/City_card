package tests.MobilePayment;

//import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class MobileAgreementTest extends BaseTest {
    @Test
//    @Description("[pos]Переход на страницу пользовательского соглашения со страницы пополнения мобильного")
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
