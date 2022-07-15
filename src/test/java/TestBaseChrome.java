import org.junit.After;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.MainPageScooter;
import testdata.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseChrome {
    protected WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //uncomment these code section down below to set timeouts if tests fail
        /*driver
                .manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);*/
        driver.get(URL.MAIN_PAGE_URL);
        MainPageScooter mainPage = new MainPageScooter(driver);
        mainPage.acceptCookie();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
