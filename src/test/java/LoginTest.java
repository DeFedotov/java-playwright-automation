import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Проверка успешного входа в систему")
    void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate()
                .login("standard_user", "secret_sauce");

        assertThat(page.url()).contains("/inventory.html");
    }

    @Test
    @DisplayName("Проверка ошибки при неверном пароле")
    void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();
        loginPage.login("standard_user", "wrong_password");

        assertThat(loginPage.getErrorMessageText())
                .contains("Username and password do not match");
    }
}