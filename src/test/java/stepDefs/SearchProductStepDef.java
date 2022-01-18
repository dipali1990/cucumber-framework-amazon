package stepDefs;

import com.managers.DriverManager;
import com.pages.HomePage;
import com.pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchProductStepDef {
    HomePage homePage = new HomePage(DriverManager.getDriver());
    @Given("User is on Amazon home page")
    public void user_is_on_amazon_home_page() {
        System.out.println(homePage.getTitle());
    }

    @When("User enters {string} in the search field")
    public void user_enters_in_the_search_field(String product) {
        homePage.enterValueInSearchBox(product);
    }

    @When("Click on Search Button")
    public void click_on_search_button() {
        homePage.clickSearchIcon();
    }

    @Then("Search Result should be displayed")
    public void search_result_should_be_displayed() {
        SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getDriver());
        boolean isSearchDisplayed = searchResultPage.isSearchPageDisplayed();
        Assert.assertTrue(isSearchDisplayed);
    }


}
