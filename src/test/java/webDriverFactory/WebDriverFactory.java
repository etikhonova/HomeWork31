package webDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Locale;

public class WebDriverFactory {
    public static WebDriver getDriver(){
        //-Dbrowser=chrome, opera, safari, mozilla
        String browser = System.getProperty("browser");
        String options = System.getProperty("options");
        //-Dheadless=true, false

        if (browser == null){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        switch (Browser.valueOf(browser.trim().toUpperCase(Locale.ROOT))){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments(options);
                return new ChromeDriver(optionsChrome);
            case FIREFOX:
                WebDriverManager.operadriver().setup();
                FirefoxOptions  optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments(options);
                return new FirefoxDriver(optionsFirefox);
            case SAFARY:
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            default:
                System.out.println("Запустите с параметром -Dbrowser = chrome/safari/firefox");
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
