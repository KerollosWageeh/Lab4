import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    static WebDriver webDriver;
    static final String Website = "https://formy-project.herokuapp.com/form";

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        webDriver.get(Website);
    }

    @Test
    public void firstNameTest(){
        WebElement firstName = webDriver.findElement(By.id("first-name"));
        firstName.sendKeys("Kerollos");
        assertEquals("Kerollos", firstName.getAttribute("value"));
    }
    @Test
    public void lastNameTest(){
        WebElement lastName = webDriver.findElement(By.id("last-name"));
        lastName.sendKeys("Wageeh");
        assertEquals("Wageeh", lastName.getAttribute("value"));
    }

    @Test
    public void jobTitleTest(){
        WebElement jobTitle = webDriver.findElement(By.id("job-title"));
        jobTitle.sendKeys("Student");
        assertEquals("Student",jobTitle.getAttribute("value"));
    }

    @Test
    public void educationTest(){
        WebElement highSchool = webDriver.findElement(By.id("radio-button-2"));
        highSchool.click();
        assertEquals(true,highSchool.isSelected());
    }

    @AfterAll
    public static void afterAll(){
        WebElement btn = webDriver.findElement(By.className("btn"));
        btn.click();
        //webDriver.quit();
    }
}

