package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.get("https://www.portfolioanalyst.com/en/pa/home.php ");
        driver.manage().window().maximize();
    }
    //@AfterMethod
    //public void closing(){
    // driver.close();
}
