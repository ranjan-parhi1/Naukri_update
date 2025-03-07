package pages;

import com.microsoft.playwright.Page;
import config.DBConnection;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {

        this.page = page;
    }

    public void login(String username, String password) {
        String[] credentials = DBConnection.getUserCredentials();
        username = credentials[0];
        password = credentials[1];
        page.click("text=Login");  // Click login button
        page.fill("//input[@placeholder='Enter your active Email ID / Username']", username);
        page.fill("//input[@placeholder='Enter your password']", password);
        page.click("button[type='submit']");
        page.waitForLoadState(); // Ensure page loads
    }
}
