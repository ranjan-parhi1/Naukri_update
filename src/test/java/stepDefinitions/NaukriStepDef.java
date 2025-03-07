package stepDefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProfilePage;
import utils.PlaywrightManager;

public class NaukriStepDef {
    private Page page = PlaywrightManager.getPage();
    private LoginPage loginPage = new LoginPage(page);
    private ProfilePage profilePage = new ProfilePage(page);



    @Given("User is on Naukri homepage")
    public void userIsOnNaukriHomepage() {
        page.navigate("https://www.naukri.com");
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @When("User navigates to profile page")
    public void userNavigatesToProfilePage() {
        profilePage.goToProfile();
    }

    @When("User updates salary to {string}")
    public void userUpdatesSalary(String salary) throws InterruptedException {
        profilePage.updateSalary(salary);
    }

    @Then("User saves the changes successfully")
    public void userSavesTheChangesSuccessfully() {
        profilePage.saveChanges();
    }


}
