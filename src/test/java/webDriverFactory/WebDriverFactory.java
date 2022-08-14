package webDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class WebDriverFactory {
    public static WebDriver getDriver(){
        //-Dbrowser=chrome, opera, safari, mozilla
        String browser = System.getProperty("browser");
        String optons = System.getProperty("options");
        //-Dheadless=true, false

        if (browser == null){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        switch (Browser.valueOf(browser.trim().toUpperCase(Locale.ROOT))){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.operadriver().setup();
                return new FirefoxDriver();
            case SAFARY:
                WebDriverManager.firefoxdriver().setup();
                return new SafariDriver();
            default:
                System.out.println("Запустите с параметром -Dbrowser = chrome/safari/firefox");
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
