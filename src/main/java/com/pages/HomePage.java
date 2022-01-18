package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private  WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchIcon;

    public String getTitle(){
        String title = driver.getTitle();
        logger.info(title);
        return title;
    }

    public void enterValueInSearchBox(String value){
        searchBox.clear();
        searchBox.sendKeys(value);
        logger.info("Product name " + value + " is entered");
    }

    public void clickSearchIcon(){
        searchIcon.click();
        logger.info("Clicked on save button");
    }
}
