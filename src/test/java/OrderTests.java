import org.junit.Assert;
import org.junit.Test;
import pageobjects.OrderPageScooter;
import testdata.models.Order;

public class OrderTests extends TestBaseChrome {

    @Test
    public void clickHeaderOrderButtonAndFillOrderFormWithFirstOrder() {
        Order firstOrder = new Order("Василий", "Пупкин", "г. Москва, ул. Строителей, д.1, кор.2, кв.3", "Университет", "89851111111", "23.07.2022", "сутки", "серая безысходность", "Домофон: 44к5566");

        OrderPageScooter orderPage = new OrderPageScooter(driver);
        orderPage.clickHeaderOrderButton();
        orderPage.setOrderData(firstOrder);
        orderPage.clickBottomOrderButton();
        orderPage.clickConfirmButton();
        orderPage.isOrderInformationDisplayed();

        boolean isOrderInformationDisplayed = orderPage.isOrderInformationDisplayed();
        Assert.assertTrue("Order information popup window is not displayed", isOrderInformationDisplayed);
    }

    @Test
    public void clickHeaderOrderButtonAndFillOrderFormWithSecondOrder() {
        Order secondOrder = new Order("Александр", "Ерохин", "Измайловское ш, корп 5 стр 1 кв 14", "Партизанская", "+01234567890", "12.11.2014", "шестеро суток", "чёрный жемчуг", "<3");

        OrderPageScooter orderPage = new OrderPageScooter(driver);
        orderPage.clickHeaderOrderButton();
        orderPage.setOrderData(secondOrder);
        orderPage.clickBottomOrderButton();
        orderPage.clickConfirmButton();
        orderPage.isOrderInformationDisplayed();

        boolean isOrderInformationDisplayed = orderPage.isOrderInformationDisplayed();
        Assert.assertTrue("Order information popup window is not displayed", isOrderInformationDisplayed);
    }

    @Test
    public void clickBottomOrderButtonAndFillOrderFormWithFirstOrder() {
        Order firstOrder = new Order("ВАСЯ", "ВАСИН", "Ивантеевская ул., 23, Москва, 101000", "Бульвар Рокоссовского", "0000000000000", "01.01.1999", "четверо суток", "серая безысходность", "    ");

        OrderPageScooter orderPage = new OrderPageScooter(driver);
        orderPage.clickBottomOrderButton();
        orderPage.setOrderData(firstOrder);
        orderPage.clickBottomOrderButton();
        orderPage.clickConfirmButton();
        orderPage.isOrderInformationDisplayed();

        boolean isOrderInformationDisplayed = orderPage.isOrderInformationDisplayed();
        Assert.assertTrue("Order information popup window is not displayed", isOrderInformationDisplayed);
    }

    @Test
    public void clickBottomOrderButtonAndFillOrderFormWithSecondOrderWrongAddressLength() {
        Order secondOrder = new Order("Сергей", "Иванов", "Большая Дорогомиловская улица, дом 10, Москва, 121059", "Лихоборы", "+1235113111", "31.12.2099", "двое суток", "чёрный жемчуг", "");

        OrderPageScooter orderPage = new OrderPageScooter(driver);
        orderPage.clickBottomOrderButton();
        orderPage.setOrderData(secondOrder);
        orderPage.clickBottomOrderButton();
        orderPage.clickConfirmButton();
        orderPage.isOrderInformationDisplayed();

        boolean isOrderInformationDisplayed = orderPage.isOrderInformationDisplayed();
        Assert.assertTrue("Order information popup window is not displayed", isOrderInformationDisplayed);
    }
}
