package com.Onpier.pages;


import com.Onpier.utilities.BrowserUtils;
import com.Onpier.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FormPage2 {


    public FormPage2() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    public void PrivatPerson(){
        this.PrivatPerson.click();
        BrowserUtils.waitFor(2);
    }

    public void Unternehmen(){
        this.Unternehmen.click();
        BrowserUtils.waitFor(2);
    }

    @FindBy(xpath = "//label[@class='h-auto md:w-full']")
    public static WebElement Fahrzeugklassen;

    @FindBy(linkText = " Prämie beantragen ")
    public static WebElement Pramienmodelle;

    @FindBy(xpath="//span[@class='distributor-color']")
    public static WebElement uploadPic1;

    @FindBy(xpath="(//span[@class='distributor-color'])[2]")
    public static WebElement uploadPic2;


    @FindBy(xpath="//button[@color='primary']")
        public static WebElement weiter1;

    @FindBy(xpath = "//input[@id='mat-radio-2-input']")
    public static WebElement PrivatPerson;

    @FindBy( xpath= "//input[@id='mat-radio-3-input']")
    public static WebElement Unternehmen;
    @FindBy(className = "mdc-list-item__primary-text")
    public static WebElement selectAnrede;

    @FindBy(xpath = "//input[@class='rounded w-full pl-4 ng-valid ng-star-inserted ng-dirty ng-touched']")
    public static WebElement inputVorname;

    @FindBy(xpath = "//input[@placeholder='Mustermann']")
    public static WebElement inputNachname;

    @FindBy(xpath = "(//input[@class='rounded w-full pl-4 ng-valid ng-star-inserted ng-dirty ng-touched'])[3]")
    public static WebElement inputEMailAdresse;

    @FindBy(xpath = "(//input[@class='rounded w-full pl-4 ng-valid ng-star-inserted ng-dirty ng-touched'])[4]")
    public static WebElement inputKontoinhaber;

    @FindBy(xpath = "//input[@class='rounded w-full pl-4 ng-star-inserted ng-dirty ng-touched ng-valid']")
    public static WebElement inputIBAN;

    @FindBy(linkText = "Weiter")
    public static WebElement weiterButton;

    public void login(String vorname, String nachname, String email, String kontainhaber, String iban) {
        selectAnrede.click();
        inputVorname.sendKeys(vorname);
        inputNachname.sendKeys(nachname);
        inputEMailAdresse.sendKeys(email);
        inputKontoinhaber.sendKeys(kontainhaber);
        inputIBAN.sendKeys(iban);
    }
}