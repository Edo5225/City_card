package tests.MobilePayment;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
public class MobileTest extends BaseTest {
    @Test
    public void checkPaymentWithMinimalAmount(){

        basePage.open("https://citycard.ru/");

        cityCardHomePage
                .closeCitySelector()
                .mobileService();
        cityCardMobilePage.inputNumber()
                .nextStepMobile()
                .buttonOtherAmountAndSend()
                .agreementInToTrueAndCheckClickablePaymentButton()
                .buttonPayment();
    }
    @Test
    public void checkPaymentWithDefaultAmount(){
        basePage.open("https://citycard.ru/");
        cityCardHomePage
                .closeCitySelector()
                .mobileService();
        cityCardMobilePage.inputNumber()
                .nextStepMobile()
                .agreementInToTrueAndCheckClickablePaymentButton()
                .buttonPayment()
                .radioButtonCard()
                .buttonToAddNewCard()
                .switchToFrame()
                .completionCardFields();
    }

}
