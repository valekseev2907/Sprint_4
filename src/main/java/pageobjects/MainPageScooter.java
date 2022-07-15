package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageScooter {
    //declare web driver
    private final WebDriver driver;
    //current class constructor
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }
    //accept cookie button locator
    private final By acceptCookieButtonLocator = By.id("rcc-confirm-button");
    //"FAQ" dropdown section questions base locator
    private final String questionButtonBaseLocator = "accordion__heading-%s";
    //"FAQ" dropdown section answers base locator
    private final String answerTextBaseLocator = "accordion__panel-%s";
    //locator includes any question number
    private By questionButtonFullLocator(String faqNumber) { return By.id(String.format(questionButtonBaseLocator, faqNumber)); }
    //locator includes any answer number
    private By answerTextFullLocator(String faqNumber) { return By.id(String.format(answerTextBaseLocator, faqNumber)); }
    //click on accept cookie button
    public void acceptCookie() {
        driver.findElement(acceptCookieButtonLocator).click();
    }
    //find & click on question button
    public void clickQuestionButton(String faqNumber) { driver.findElement(questionButtonFullLocator(faqNumber)).click(); }
    //find & get text of answer
    public String getAnswerText(String faqNumber) { return driver.findElement(answerTextFullLocator(faqNumber)).getText(); }
}
