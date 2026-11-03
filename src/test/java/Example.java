import com.microsoft.playwright.*;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            Browser browser = chromium.launch();
            Page page = browser.newPage();
            page.navigate("http://example.com");
            // other actions...
            browser.close();
        }
    }
}