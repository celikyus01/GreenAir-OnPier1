package com.Onpier.pages;

import com.Onpier.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage {

    @FindBy(xpath = "//input[@id='mat-radio-2-input']")
    public WebElement privatPerson;

    @FindBy(id = "mat-select-value-1")
    public WebElement selectAnrede;

    @FindBy(xpath = "//input[@placeholder='Max']")
    public WebElement inputVorname;

    @FindBy(xpath = "//input[@placeholder='Mustermann']")
    public WebElement inputNachname;

    @FindBy(xpath = "//input[@placeholder='max.mustermann@muster.de']")
    public WebElement inputEMailAdresse;

    @FindBy(xpath = "//input[@placeholder='Max Mustermann']")
    public WebElement inputKontoinhaber;

    @FindBy(xpath = "//input[@placeholder='z.B. DE45 7890 8965 5643 3454 00']")
    public WebElement inputIBAN;

    @FindBy(xpath = "(//div[.='Weiter '])[2]")
    public WebElement weiterButton;

    @FindBy(xpath = "(//div/button[.=' Zurück '])[2]")
    public WebElement zurückButton;

    @FindBy(linkText=" Der Vorname muss mindestens zwei Zeichen lang sein.")
    public WebElement VornameErrorMessage;

    @FindBy(linkText=" Bitte geben Sie Ihren Nachnamen ein.")
    public WebElement NachnameErrorMessage;


    public static String name= "John";
    public static String kontoinHaber="Elif Basbug";


    public void login(String vorname, String nachname, String email, String kontainhaber, String iban) {
        selectAnrede.click();
        inputVorname.sendKeys(vorname);
        inputNachname.sendKeys(nachname);
        inputEMailAdresse.sendKeys(email);
        inputKontoinhaber.sendKeys(kontainhaber);
        inputIBAN.sendKeys(iban);
    }

    public void selectTitle(String title){
        BrowserUtils.click(selectAnrede);
        String xpath= String.format("//*[.='%s']", title);
        BrowserUtils.click(By.xpath(xpath));
    }

}
