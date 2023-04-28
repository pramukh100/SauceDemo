package stepsDef;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.DemoPage;

public class Steps {
    DemoPage demoPage = new DemoPage(DriverFactory.getDriver());

    @Given("User go to SauceDemo Website")
    public void user_go_to_sauce_demo_website() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");

    }

    @And("User select user name {string} And password {string}")
    public void user_select_user_name_and_password(String userName, String password) {
        demoPage.setUserName(userName);
        demoPage.setPassword(password);
    }

    @And("User click on login button")
    public void user_click_on_login_button() {
        demoPage.setLogIn();
    }

    @And("User go to the trolley")
    public void user_go_to_the_trolly() {
        demoPage.setGoToTrolleyTrolley();
    }

    @And("User click checkout button")
    public void user_click_checkout_button() {
        demoPage.setCheckOut();

    }

    @And("User enter {string} and {string} and {string}")
    public void userEnterAndAnd(String name, String surname, String code) {
        demoPage.setFirstName(name);
        demoPage.setLastName(surname);
        demoPage.setPostalCode(code);
    }

    @And("User press continue")
    public void user_press_continue() {
        demoPage.clickContinue();
    }

    @And("User press finish button")
    public void user_press_finish_button() {
        demoPage.clickFinish();
    }

    @Given("User add {string} product in add to cart")
    public void user_add_product_in_add_to_cart(String string) {
        demoPage.selectProductAndAddToCart(string);
    }

    @Then("User get order successful message")
    public void userGetOrderSuccessfulMessage() {
        demoPage.verifyOrderConfirmation();
    }

    @And("User verify selected {string} item")
    public void userVerifySelectedItem(String item) {
        demoPage.verifyItemNameInTrolley(item);
    }

    @And("User is logout from website")
    public void userIsLogoutFromWebsite() {
        demoPage.logout();
    }

    @Then("User get locked out error message")
    public void userGetLockedOutErrorMessage() {
        demoPage.verifyLockedOutErrorMessage();
    }

    @And("User select {string} product")
    public void userSelectProduct(String item) {
        demoPage.selectItem(item);
    }

    @Then("User find other item than {string} on inventory item description")
    public void userFindOtherItemThanOnInventoryItemDescription(String item) {
        demoPage.verifyWrongItemOnInventoryItem(item);
    }

    @And("User try to add product to cart")
    public void userTryToAddProductToCart() {
        demoPage.clickAddToCart();
    }

    @Then("User find trolley empty")
    public void userFindTrolleyEmpty() {
        demoPage.verifyTrolleyIsEmpty();
    }

    @Then("User can not proceed and see error message")
    public void userCanNotProceedAndSeeErrorMessage() {
        demoPage.verifyLastNameRequiredErrorMessage();
    }

}
