package selenium.pageObjectExample.pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.SeleniumBase;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstScriptTest {

  @Test
  public void eightComponents() {
    SeleniumBase base = new SeleniumBase();
    ChromeDriver driver = base.seleniumInit("https://www.selenium.dev/selenium/web/web-form.html");
    String title = driver.getTitle();
    assertEquals("Web form", title);

    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    WebElement textBox = driver.findElement(By.name("my-text"));
    WebElement submitButton = driver.findElement(By.cssSelector("button"));

    textBox.sendKeys("Selenium");
    submitButton.click();

    WebElement message = driver.findElement(By.id("message"));
    String value = message.getText();
    assertEquals("Received!", value);
    System.out.println(value);

    driver.quit();
  }

}