package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "[data-test='error']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public LoginPage navigate() {
        page.navigate("https://www.saucedemo.com/");
        return this;
    }

    public void login(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
    }

    public String getErrorMessageText() {
        return page.locator(errorMessage).textContent();
    }
}