package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddressCreationTest {
  private WebDriver driver;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost:8090/addressbook/");
    login("admin", "secret");

  }

  private void login(String username, String password) {
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testAddressCreation() throws Exception {
    gotoAddressCreationPage();
    fillAddressForm(new AddressData("FirstName", "LastName", "Address", "Mobile", "email@mail.com"));
    submitAddressCreation();
    returnToHomePage();
    logout();
  }

  private void logout() {
    driver.findElement(By.linkText("Logout")).click();
  }

  private void returnToHomePage() {
    driver.findElement(By.linkText("home page")).click();
  }

  private void submitAddressCreation() {
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void fillAddressForm(AddressData addressData) {
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(addressData.getFirstname());
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(addressData.getLastname());
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(addressData.getAddress());
    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(addressData.getMobile());
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(addressData.getEmail());
  }

  private void gotoAddressCreationPage() {
    driver.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
