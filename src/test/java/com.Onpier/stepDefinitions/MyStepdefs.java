package com.Onpier.stepDefinitions;

import com.Onpier.pages.FahrzeugscheinHochladen;
import com.Onpier.pages.FormPage;
import com.Onpier.pages.LandingPage;
import com.Onpier.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;
import java.util.List;

import static com.Onpier.utilities.BrowserUtils.*;
import static org.junit.Assert.*;

    public class MyStepdefs {

        FormPage formPage = new FormPage();
        LandingPage landingPage = new LandingPage();
        FahrzeugscheinHochladen fahrzeugscheinVorderseite = new FahrzeugscheinHochladen();

        @Given("user is on Persönliche Daten eingeben page")
        public void userIsOnPersonlicheDatenEingebenPage() {
            assertEquals("THG Prämie", getTitle());
        }

        @When("user selects vehicle class")
        public void userSelectsVehicleClass() {
            click(landingPage.klasseM1);
        }

        @And("user selects flexPramieBentragen package")
        public void userSelectsFlexPramieBentragenPackage() {
            click(landingPage.flexPramieBentragen);
        }

        @And("user uploads images of vehicle registration")
        public void userUploadsImagesOfVehicleRegistration() {
            //to get the dynamic path of the image
            String path = System.getProperty("user.dir") + ConfigurationReader.get("imagePath");
            sendKeys(fahrzeugscheinVorderseite.fahrzeugscheinVorderseite, path);
            sendKeys(fahrzeugscheinVorderseite.fahrzeugscheinRuckseite, path);
        }

        @And("user clicks on {string} button")
        public void userClicksOnButton(String buttonName) {
            landingPage.clickButton(buttonName);
        }

        @Then("user verifies title as {string}")
        public void userVerifiesTitleAs(String expectedTitle) {
            assertEquals(getTitle(), expectedTitle);
        }

        @When("user selects title {string}")
        public void userEntersTitle(String title) {
            formPage.selectTitle(title);
        }

        @And("user fills {string} as {string}")
        public void userFillsAs(String label, String value) {
            if (value.contains("%s"))
                value = String.format(value, new Date().getTime());
            formPage.fill(label, value);
        }

        @And("user clicks on Weiter button")
        public void userClicksOnWeiterButton() {
            click(formPage.weiterButton);
        }

        @Then("form is created with given personal information")
        public void formIsCreatedWithGivenPersonalInformation(List<String> list) {
            for (String each : list) {
                formPage.checkInfo(each);
            }
            System.out.println("the validation of form data is done");
        }

        @When("user enters a letter as a vorname {string}")
        public void userEntersALetterAsAVorname(String vornameLetter) {
            formPage.inputVorname.sendKeys(vornameLetter);
        }

        @And("user clicks another field to fill and proceed")
        public void userClicksAnotherFieldToFillAndProceed() {click(formPage.inputNachname);}

        @Then("error message appears under the Vorname field")
        public void errorMessageAppearsUnderTheVornameField() {
            assertTrue(formPage.VornameErrorMessage.isDisplayed());
        }

        @When("user enters a letter as nachname {string}")
        public void userEntersALetterAsNachname(String nachnameLetter) {
            formPage.inputNachname.sendKeys(nachnameLetter);
        }

        @And("user clicks another placeholder to fill and proceed")
        public void userClicksAnotherPlaceholderToFillAndProceed() {click(formPage.inputEMailAdresse);}

        @Then("error message appears under the Nachname field")
        public void errorMessageAppearsUnderTheNachnameField() {
            assertTrue(formPage.NachnameErrorMessage.isDisplayed());
        }


        @Then("user verifies account holder name and person name can be different")
        public void userVerifiesAccountHolderNameAndPersonNameCanBeDifferent() {
            assertNotEquals(formPage.name, formPage.kontoinHaber);
        }

        @Then("the form is created with invalid email")
        public void formIsCreatedWithInvalidEmail(List<String> list) {
            for (String each : list) {
                formPage.checkInfo(each);
            }
            System.out.println("Form created with invalid e mail");
        }

        @When("user clicks on Zurück button")
        public void userClicksOnZurückButton() {formPage.zurückButton.click();}

        @Then("user lands on previous page")
        public void userLandsOnPreviousPage() {assertEquals("THG Prämie", getTitle());
        }


    }
