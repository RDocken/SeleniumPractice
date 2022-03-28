package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MainClass {
    public static ChromeDriver driver;
    public static FirefoxDriver firefoxDriver;
    public static String Dress = "http://automationpractice.com/index.php";

    @BeforeTest(groups = "current")
    public void fireFoxSetup(){
        System.out.println("Start of firefox setup");


        System.setProperty("webdriver.gecko.driver", "/home/jenkins/drivers/geckodriver");
        System.setProperty("webdriver.chrome.whitelistedIps", "");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");

        firefoxDriver = new FirefoxDriver(options);

    }


//    @BeforeTest(groups = "current")
//    public void ubuntuSetup() {
//        System.out.println("Start of ubuntu setup");
//
//        //this works on vm
////        System.setProperty("webdriver.chrome.driver", "/home/single/chromedriver");
//
//        System.setProperty("webdriver.chrome.driver", "/home/jenkins/drivers/chromedriver");
//        System.setProperty("webdriver.chrome.whitelistedIps", "");
//
//        //create ChromeOptions
//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("--no-sandbox");
//        options.setHeadless(true);
//        options.addArguments("--verbose");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--window-size=1920x1080");
//
//        //create a chrome webdriver with headless options added
//        driver = new ChromeDriver(options);
////        Capabilities version = driver.getCapabilities();
////        System.out.println("Chrome version: " + version.getBrowserVersion());
//
//        System.out.println("End of ubuntu setup");
//    }

//    @BeforeTest(groups = "current")
//    public void chromeSetup(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Docke\\Desktop\\WebDrivers\\chromedriver.exe");
//
//        //create ChromeOptions
//        ChromeOptions options = new ChromeOptions();
//
//        //add --headless option to ChromeOptions
////        options.setHeadless(true);
//
//        //create a chrome webdriver with headless options added
//        driver = new ChromeDriver(options);
//
//    }

//        @BeforeTest
//    public void edgeSetup(){
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\Docke\\Desktop\\WebDrivers\\msedgedriver.exe");
//        driver = new EdgeDriver();
//    }

    @Test(groups = "current")
    /*
     *
     *
     *
     * */
    public void loginUsingXPath() {
        System.out.println("Start of login using xpath");

        System.out.println("Attempting to send to url: " + Dress);
        System.out.println("current url: " + driver.getCurrentUrl());
        //navigate to test website
        driver.get(Dress);
        System.out.println("current url: " + driver.getCurrentUrl());
        System.out.println("sent to url");

        //click on sign in button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        System.out.println("found sign in button");

        //enter email
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Docken.Ryan@gmail.com");

        //enter password
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("12345");

        //click login
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();

        //check to see if account name is equal to Ryan Docken
        assert (driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText().equals("Ryan Docken"));
        System.out.println("end of login using xpath");
    }


    @Test()
    /* This method uses chromedriver to find a dress on
     *  the website using find by name and find by id
     *
     *
     * */
    public void dressSearchUsingName() throws InterruptedException {


        //sends the driver to the webpage
        driver.navigate().to(Dress);

        //makes webpage fullscreen
        driver.manage().window().maximize();

        //find the search box and enters the keys into it
        driver.findElement(By.id("search_query_top")).sendKeys("dress");

        //clicks on the search button
        driver.findElement(By.name("submit_search")).click();
    }


    @Test
    /*
     *
     *
     *
     * */
    public void addItemsToCart() {
        //make fullscreen
        driver.manage().window().maximize();

        //navigate to test website
        driver.navigate().to(Dress);

        //click on dresses
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();

        //click on summer dresses
        driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")).click();

        //click on dress
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")).click();

        //add dress to cart
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();

        //continue shopping
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();

    }
}
