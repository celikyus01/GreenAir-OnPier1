package com.Onpier.pages;

import com.Onpier.utilities.BrowserUtils;
import com.Onpier.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickButton(String buttonName) {
        String xPath1 = String.format("(//button[.='%s'])[1]", buttonName);
        String xPath2 = String.format("(//div[.='%s'])[1]", buttonName);

        if (BrowserUtils.isPresent(By.xpath(xPath1)))
            BrowserUtils.click(By.xpath(xPath1));
        else if (BrowserUtils.isPresent(By.xpath(xPath2)))
            BrowserUtils.click(By.xpath(xPath2));
        else
            throw new NoSuchElementException("This button could not be handled by the button name.. Please create a generic locator for it.");
    }

    public void fill(String labelName, String value) {
        String xpath = String.format("//label[.='%s']/..//input", labelName);
        WebElement element = BrowserUtils.getElemet(By.xpath(xpath));
        BrowserUtils.sendKeys(element, value);
    }

    public void checkInfo(String labelName){
        String xpath = String.format("//td[.='%s:']/following-sibling::td", labelName);
        WebElement element = BrowserUtils.getElemet(By.xpath(xpath));
        System.out.println("element.getText() = " + element.getText());
    }
}
