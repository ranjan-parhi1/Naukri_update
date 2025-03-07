package pages;

import com.microsoft.playwright.*;
import utils.PlaywrightManager;

public class ProfilePage {

    private Page page;

    public ProfilePage(Page page) {
        this.page = page;
    }

    public void goToProfile() {
        // Close any popup if present
        if (page.isVisible("button.close")) {
            page.click("button.close");
        }
        page.click("text=View Profile");
        page.waitForLoadState();
    }

    public void updateSalary(String salary) throws InterruptedException {
        page.click("//em[text()='editOneTheme']");
        page.fill("//input[@id='totalAbsCtc_id']", salary);
    }

    public void saveChanges() {
        page.click("//button[text()='Save']");
        page.click("//button[text()='Save']");
        page.waitForLoadState();
    }
}
