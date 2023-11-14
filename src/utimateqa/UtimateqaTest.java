package utimateqa;
/*Project-5 - ProjectName : com-utimateqa
BaseUrl = https://courses.ultimateqa.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Sign In’ link
7. Print the current url
8. Enter the email to email field.
9. Enter the password to password field.
10. Click on Login Button.
11. Navigate to baseUrl.
12. Navigate forward to Homepage.
13. Navigate back to baseUrl.
14. Refresh the page.
15. Close the browser.
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class UtimateqaTest {
    static String baseUrl = "https://courses.ultimateqa.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        // get base Url into browser
        driver.get(baseUrl);
        //Maximise the Window
        driver.manage().window().maximize();
        //We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);

        // Get the Current Url
        System.out.println(driver.getCurrentUrl());

        //Get the Page source
        System.out.println(driver.getPageSource());

        //Click on Sign in link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        Thread.sleep(5000);

        //Get the current Url
        System.out.println(driver.getCurrentUrl());

        //Enter the Email in the email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("Shopping@gmail.com");
        Thread.sleep(5000);

        //Enter the Password to the password field
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("shoP12547");
        Thread.sleep(5000);

        //Click the Login Button
        WebElement loginButton = driver.findElement(By.xpath("(//button[@type='submit'])"));
        loginButton.click();
        Thread.sleep(5000);

        //Navigate to baseUrl
        driver.navigate().to("https://courses.ultimateqa.com/");
        Thread.sleep(5000);

        //Navigate forward to Homepage
        driver.navigate().forward();
        Thread.sleep(5000);

        //Navigate back to baseUrl
        driver.navigate().back();

        //Refresh the Page
        driver.navigate().refresh();
        Thread.sleep(5000);

        //Close the browser
        driver.quit();
    }

}
