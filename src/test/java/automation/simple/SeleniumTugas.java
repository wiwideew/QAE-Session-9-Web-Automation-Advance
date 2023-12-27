package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTugas {
    WebDriver driver;

    @Test
    public void login() {
        //open browser
        WebDriverManager.firefoxdriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu_Hotels")));
        driver.findElement(By.xpath("//li[@class='menu_Hotels']//a[contains(.,'Hotels')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hsw_search_button")));
        driver.findElement(By.xpath("//button[@id='hsw_search_button']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("li")));
        driver.findElement(By.xpath("//li[.='Price (Highest First)']")).click();
    }
}
