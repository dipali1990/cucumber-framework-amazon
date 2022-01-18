package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage {

    private WebDriver driver;
    private Logger logger = LogManager.getLogger();

    @FindBy(id="s-result-sort-select")
    private WebElement sortByDropDown;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public boolean isSearchPageDisplayed(){
        boolean flag = false;
        if(sortByDropDown.isDisplayed()){
            logger.info("User is on Search Page");
            flag = true;
        }
        return flag;
    }

}
