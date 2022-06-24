package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager extends Utils {

    LoadProp loadProp = new LoadProp();
    DesiredCapabilities caps = new DesiredCapabilities();

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    boolean cloud =Boolean.parseBoolean(System.getProperty("cloud"));

    String browserName = "Chrome";
    //Open Driver method
    public void openBrowser() {
        if (cloud) {
            System.out.println("running cloud");
            //appluing conditionalloop for diffrent browser options
            if (browserName.equalsIgnoreCase("Chrome")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            }else  if (browserName.equalsIgnoreCase("firefox")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.10.0");
            }else {
                System.out.println("Your browser name is wrong.");
            }
            try {
                driver = new RemoteWebDriver(new URL(URL),caps);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            }else{

                if (browserName.equalsIgnoreCase("Chrome")) {
    //                WebDriverManager.chromedriver().setup();
                    System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browserName.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                } else {
                    System.out.println("Your browser name is wrong.");
                }
        }

//        if (browserName.equalsIgnoreCase("Chrome"))
//        {
//            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
//            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("firefox"))
//        {
//            System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
//            driver = new FirefoxDriver();
//        } else {
//            System.out.println("Enter Browser name currectly"+browserName);
//        }
        //Duration to wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Maximize the screen
        driver.manage().window().maximize();

        // type URL
        driver.get(loadProp.getProperty("url"));
    }

    //Close browser method
    public void closeBrowser()
        {
            driver.quit();
        }

    }
