package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tsLocal = new ThreadLocal<>();

    public WebDriver init_Browser(String browser) {
        System.out.println("The browser name is " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tsLocal.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tsLocal.set(new FirefoxDriver());
        } else {
            System.out.println("Please Provide the Correct Browser value " + browser);

        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tsLocal.get();
    }
}


