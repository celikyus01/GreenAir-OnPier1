package com.Onpier.stepDefinitions;

import com.Onpier.pages.FormPage2;
import com.Onpier.utilities.BrowserUtils;
import com.Onpier.utilities.ConfigurationReader;
import com.Onpier.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class StepDefinitions {


    FormPage2 formPage2 = new FormPage2();


    @Given("user is on Persönliche Daten eingeben page")
    public void userIsOnPersönlicheDatenEingebenPage() {
        Driver.getDriver().get("https://thg-greenair.dev.wgv.onpier.de/onboarding");
    }


    @Given("user is on Privatperson form")
    public void userIsOnPrivatpersonForm() {
        FormPage2.PrivatPerson.click();
        BrowserUtils.waitFor(2);

    }

    @Given("user clicks on Unternehmen button")
    public void userClicksOnUnternehmenButton() {
        FormPage2.Unternehmen.click();
        BrowserUtils.waitFor(2);

    }


    @When("user enters title {string}")
    public void userEntersTitle(String arg0) {
        FormPage2.selectAnrede.click();
        BrowserUtils.waitFor(2);
    }

    @And("user enters first name {string}")
    public void userEntersFirstName(String arg0) {
        FormPage2.inputVorname.sendKeys("John" + Keys.ENTER);
        BrowserUtils.waitFor(2);

    }

    @And("user enters surname {string}")
    public void userEntersSurname(String arg0) {
        FormPage2.inputNachname.sendKeys("Doe" + Keys.ENTER);
        BrowserUtils.waitFor(2);

    }

    @And("user enters email adress {string}")
    public void userEntersEmailAdress(String arg0) {
        FormPage2.inputEMailAdresse.sendKeys("anything@gmail.com" + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    @And("user enters account holder {string}")
    public void userEntersAccountHolder(String arg0) {
        FormPage2.inputKontoinhaber.sendKeys("John Doe" + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    @And("user enters iban no {string}")
    public void userEntersIbanNo(String arg0) {
        FormPage2.inputIBAN.sendKeys("1234123412341234" + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    @And("user clicks on Weiter button")
    public void userClicksOnWeiterButton() {
        FormPage2.weiterButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("form is created with given personal information")
    public void formIsCreatedWithGivenPersonalInformation() {

    }


    @When("user enters a letter as a name")
    public void userEntersLetterAsAName(int arg0) {
    }

    @Then("error message appears under the Vorname field")
    public void errorMessageAppearsUnderTheVornameField() {
    }

    @When("user enters a letter as a surname")
    public void userEntersALetterAsASurname() {
    }

    @Then("error message appears under the Nachname field")
    public void errorMessageAppearsUnderTheNachnameField() {
    }

    @When("user enters a different account holder name")
    public void userEntersADifferentTheAccountHolderName() {
    }


    @Then("user verifies account holder name and person name can be different")
    public void userVerifiesAccountHolderNameAndPersonNameCanBeDifferent() {
    }

    @When("user enters the Account holder name")
    public void userGetsTheAccountHolderName() {
    }

    @Then("user verifies Account holder name and person name can be same")
    public void userVerifiesAccountHolderNameAndPersonNameCanBeSame() {
    }

    @When("user enters invalid email")
    public void userEntersInvalidEmail() {
    }


    @Then("the form is created with invalid email")
    public void theFormIsCreatedWithInvalidEmail() {
    }

    @When("user enters  the same email")
    public void userEntersTheSameEmail() {
    }

    @Then("new user is created with the same email")
    public void newUserIsCreatedWithTheSameEmail() {
    }

    @When("user enters the {string} number in the IBAN box")
    public void userEntersTheNumberInTheIBANBox(String arg0) {
    }

    @Then("account is created")
    public void accountIsCreated() {
    }


    @When("user enters the invalid {string} number in the IBAN box")
    public void userEntersTheInvalidNumberInTheIBANBox(String arg0) {

    }

    @Then("warning message is on screen, under the IBAN box")
    public void warningMessageIsOnScreenUnderTheIBANBox() {
    }
}



