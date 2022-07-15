package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import testdata.models.Order;

public class OrderPageScooter {
    //declare web driver
    private final WebDriver driver;
    //current class constructor
    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }
    //set locators for first form of order
    //order button locator from page header
    private final By headerOrderButtonLocator = new By.ByClassName("Button_Button__ra12g");
    //"next" button locator
    private final By nextButtonFirstFormLocator = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    //input text locators (name, surname, address, metro station, phone)
    private final By nameFieldLocator = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameFieldLocator = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressFieldLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationFieldLocator = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneNumberFieldLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //set locators for second form of order
    //input date locator
    private final By dateFieldLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //rental period dropdown locators
    private final By rentalPeriodFieldLocator = new By.ByClassName("Dropdown-arrow");
    private final String rentalPeriodDropdownMenuLocator = "//div[@class='Dropdown-option' and text()='%s']";
    //scooter color check-box locator
    private final String chooseScooterColorLocator = "//label[text()='%s']";
    //input commentary text locator
    private final By commentFiledLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //order button locator from page bottom
    private final By bottomOrderButtonLocator = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //"confirm" button locator
    private final By confirmOrderButtonLocator = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //order information popup window locator
    private final By informationAboutOrder = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //filling first order form methods
    //find order button & click
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButtonLocator).click();
    }

    //find name filed & send text
    public void setName(String name) {
        driver.findElement(nameFieldLocator).sendKeys(name);
    }
    //find surname filed & send text
    public void setSurname(String surname) {
        driver.findElement(surnameFieldLocator).sendKeys(surname);
    }
    //find address filed & send text
    public void setAddress(String address) {
        driver.findElement(addressFieldLocator).sendKeys(address);
    }
    //find metro station filed & send text
    public void setMetroStation(String metroStation) {
        driver.findElement(metroStationFieldLocator).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
    }
    //find phone number filed & send text
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
    }
    //find next button & click
    public void clickNextButton() {
        driver.findElement(nextButtonFirstFormLocator).click();
    }

    //filling second order form methods
    //find date field & send text
    public void setDate(String date) {
        driver.findElement(dateFieldLocator).sendKeys(date);
    }
    //find rental period field & click, then find dropdown menu and choose available option
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodFieldLocator).click();
        driver.findElement(By.xpath(String.format(rentalPeriodDropdownMenuLocator, rentalPeriod))).click();
    }
    //find choose color check-boxes & click
    public void setColor(String color) {
        driver.findElement(By.xpath(String.format(chooseScooterColorLocator, color))).click();
    }
    //find commentary filed & send text
    public void setComment(String comment) {
        driver.findElement(commentFiledLocator).sendKeys(comment);
    }
    //find & click order button on second filling form
    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButtonLocator).click();
    }
    //find & click confirm order button
    public void clickConfirmButton() {
        driver.findElement(confirmOrderButtonLocator).click();
    }
    //find & get order information popup window
    public boolean isOrderInformationDisplayed() {
       return driver.findElement(informationAboutOrder).isDisplayed();
    }

    //filling order form complex method
    public void setOrderData (Order order) {
        setName(order.getName());
        setSurname(order.getSurname());
        setAddress(order.getAddress());
        setMetroStation(order.getMetroStation());
        setPhoneNumber(order.getPhoneNumber());
        clickNextButton();
        setDate(order.getDate());
        setRentalPeriod(order.getRentalPeriod());
        setColor(order.getColor());
        setComment(order.getComment());
    }
}


