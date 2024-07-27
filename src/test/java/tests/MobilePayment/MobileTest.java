package tests.MobilePayment;
//import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
public class MobileTest extends BaseTest {
    @Test
//    @Description("[neg]Пополнение на минимальную сумму")
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
//    @Description("[pos]Пополнение на предустановленное значение (400)")
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
