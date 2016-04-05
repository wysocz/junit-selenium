package WebDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class BaseWebDriver {

    public static BaseWebDriver Browser;
    public static WebDriver Instance;
    public static long TIMEOUT = 5;



    protected BaseWebDriver() {

      //  System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");

    }
    public static BaseWebDriver getInstance() {
        if (Browser == null) {
            Browser = new BaseWebDriver();
        }

        return Browser;
    }

    public static void Initialize() throws IOException {

        //TODO desired capabilities


        if (Instance == null) {
            Instance = new ChromeDriver();
            new WebDriverWait(Instance, 5);
            System.out.println("Chrome Driver initialized");

        }
    }

    public static void navigate(String url) {
        System.out.println("goToPage " + url);
        Instance.navigate().to(url);

    }

    public static boolean isOnPage(String url) {
        return Instance.getCurrentUrl().equalsIgnoreCase(url);
    }

}
