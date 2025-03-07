package utils;

import com.microsoft.playwright.*;

import java.awt.*;

public class PlaywrightManager {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    private static BrowserContext context;

    public static Page getPage() {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
            int width= (int)screenSize.getWidth();
            int height= (int)screenSize.getHeight();
            context= browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
            page = context.newPage();
            return page;
    }

}
