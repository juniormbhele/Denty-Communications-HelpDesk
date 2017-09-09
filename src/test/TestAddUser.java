package test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sphiwe.Mbhele on 2017/09/08.
 */
public class TestAddUser
{
    public WebDriver driver;
    public UIMap uimap;
    public UIMap datafile;
    public UIMap values;
    public String workingDir;


    public static final String EXPECT_TITLE = "Deposita CashOps System: Transaction Details";

    // Declare An Excel Work Book
    HSSFWorkbook workbook;

    // Declare An Excel Work Sheet
    HSSFSheet sheet;

    // Declare A Map Object To Hold TestNG Results
    Map<String, Object[]> TestNGResults;
    public static String driverPath = null;



    @Test()
    public void AddUser() throws Exception
    {
        try
        {
            driver.get("http://localhost:8080/Denty_Communications___HelpDesk_war_exploded/AddUser.jsp");
            Thread.sleep(1000);

            driver.manage().window().maximize();

            WebElement username = driver.findElement(uimap.getLocator("username"));
            username.sendKeys(datafile.getData("username"));

            WebElement password = driver.findElement(uimap.getLocator("password"));
            password.sendKeys(datafile.getData("password"));

            WebElement email = driver.findElement(uimap.getLocator("email"));
            email.sendKeys(datafile.getData("email"));

            WebElement firstName = driver.findElement(uimap.getLocator("firstName"));
            firstName.sendKeys(datafile.getData("firstName"));


            WebElement lastName = driver.findElement(uimap.getLocator("lastName"));
            lastName.sendKeys(datafile.getData("lastName"));

            WebElement company = driver.findElement(uimap.getLocator("company"));
            company.sendKeys(datafile.getData("company"));

            WebElement role = driver.findElement(uimap.getLocator("role"));
            role.sendKeys(datafile.getData("role"));

            WebElement address = driver.findElement(uimap.getLocator("address"));
            address.sendKeys(datafile.getData("address"));

            WebElement city = driver.findElement(uimap.getLocator("city"));
            city.sendKeys(datafile.getData("city"));

            WebElement country = driver.findElement(uimap.getLocator("country"));
            country.sendKeys(datafile.getData("country"));

            WebElement postalCode = driver.findElement(uimap.getLocator("postalCode"));
            postalCode.sendKeys(datafile.getData("postalCode"));

            WebElement about = driver.findElement(uimap.getLocator("about"));
            about.sendKeys(datafile.getData("about"));

            WebElement add = driver.findElement(uimap.getLocator("add"));
            add.click();


        } catch (Exception e) {

            Assert.assertTrue(false);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void suiteSetUp()
    {

        try
        {
            // Get current working directory and load the data file
            workingDir = System.getProperty("user.dir");
            datafile = new UIMap(workingDir + "\\Resources\\datafile.properties");

            // Get the object map file
            uimap = new UIMap(workingDir + "\\Resources\\locator.properties");


            // Setting up Chrome driver path.
            System.setProperty("webdriver.chrome.driver", workingDir + "\\Resources\\chromedriver.exe");

            // Launching Chrome browser.
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new IllegalStateException("Can't start the Chrome Web Driver", e);
        }
    }


    @AfterClass
    public void suiteTearDown()
    {
        // close the browser
        //driver.close();

    }

}
