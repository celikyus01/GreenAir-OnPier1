package com.Onpier.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FahrzeugscheinHochladen extends BasePage{

    @FindBy(xpath = "//input[@id='Fahrzeugschein Vorderseite']")
    public WebElement fahrzeugscheinVorderseite ;

    @FindBy(xpath = "//input[@id='Fahrzeugschein Rückseite']")
    public WebElement fahrzeugscheinRuckseite;

}
