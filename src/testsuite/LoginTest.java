package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser();

    }
@Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Welcome Back! not found", expectedText, actualText);
    }
@Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        //Enter invalid username
        WebElement emailField = driver.findElement(By.xpath("//input[@id='user[email]']"));
        emailField.sendKeys("reol123@gmail.com");

        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("roar123");

        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify the error message :Invalid email or password


        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Error message not display", expectedMessage, actualMessage);

    }

    @After
    public void closeDown() {
        closeBrowser();
    }


}
