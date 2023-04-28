package page;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoPage {
    private WebDriver driver;
    long start;
    long finish;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By logIn = By.id("login-button");
    private By addToCard = By.xpath("//div[@class='inventory_details_desc_container']//button");
    private By goToTrolley = By.xpath("//div[@id='shopping_cart_container']");
    private By checkOut = By.xpath("//button[@id='checkout']");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.xpath("//input[@id='postal-code']");
    private By itemNameOnInventoryItem = By.xpath("//div[@class='inventory_details_name large_size']");
    private By itemNameOnTrolley = By.xpath("//div[@class='inventory_item_name']");
    private By continueButton = By.cssSelector("#continue");
    private By finishButton = By.cssSelector("#finish");
    private By confirmationMessage = By.xpath("//div[@class='checkout_complete_container']/h2");
    private By openMenu = By.cssSelector("button#react-burger-menu-btn");
    private By logOutButton = By.linkText("Logout");
    private By lockedOutErrorText = By.xpath("//div[@class='error-message-container error']/h3");


    public void setUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void setPassword(String Password) {
        driver.findElement(password).sendKeys(Password);
    }

    public void setLogIn() {
        start = System.currentTimeMillis();
        driver.findElement(logIn).click();
    }

    public void setGoToTrolleyTrolley() {
        driver.findElement(goToTrolley).click();
    }

    public void verifyItemNameInTrolley(String expectedItem) {
        String actualItem = driver.findElement(itemNameOnTrolley).getText().trim();
        Assert.assertEquals(expectedItem, actualItem);
    }

    public void setCheckOut() {
        driver.findElement(checkOut).click();
    }

    public void setFirstName(String Name) {
        driver.findElement(firstName).sendKeys(Name);
    }

    public void setLastName(String lastname) {
        driver.findElement(lastName).sendKeys(lastname);
    }

    public void setPostalCode(String code) {
        driver.findElement(postalCode).sendKeys(code);
    }

    public void selectItem(String product) {
        By item = By.xpath("//div[contains(text(),'" + product + "')]");
        driver.findElement(item).click();
        finish = System.currentTimeMillis();
    }

    public void selectProductAndAddToCart(String product) {
        selectItem(product);
        performanceGlitchTime();
        clickAddToCart();
    }

    public void clickAddToCart() {
        String buttonText = driver.findElement(addToCard).getText().trim();
        if (!buttonText.equals("Remove")) {
            driver.findElement(addToCard).click();
        }
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public void verifyOrderConfirmation() {
        String expected = "Thank you for your order!";
        String actual = driver.findElement(confirmationMessage).getText().trim();
        Assert.assertEquals(expected, actual);
    }

    public void logout() {
        driver.findElement(openMenu).click();
        driver.findElement(logOutButton).click();
    }

    public void verifyLockedOutErrorMessage() {
        String actual = driver.findElement(lockedOutErrorText).getText().trim();
        String expected = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(expected, actual);
    }

    public void verifyWrongItemOnInventoryItem(String expectedItem) {
        String actualItem = driver.findElement(itemNameOnInventoryItem).getText().trim();
        Assert.assertNotEquals(expectedItem, actualItem);
    }

    public void verifyTrolleyIsEmpty() {
        boolean itemAvailable = driver.findElements(itemNameOnTrolley).size() > 0;
        String actual = String.valueOf(itemAvailable);
        String expected = "false";
        Assert.assertEquals(expected, actual);
    }

    public void verifyLastNameRequiredErrorMessage() {
        String actual = driver.findElement(lockedOutErrorText).getText().trim();
        String expected = "Error: Last Name is required";
        Assert.assertEquals(expected, actual);
    }

    public void performanceGlitchTime() {
        long difference = (finish - start) / 1000;
        if (difference > 3) {
            System.out.println("Poor login performance as time in second is -> " + difference);
        } else {
            System.out.println("Good login performance");
        }
    }

}
