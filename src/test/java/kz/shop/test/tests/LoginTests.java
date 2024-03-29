package kz.shop.test.tests;

import io.qameta.allure.*;
import kz.shop.test.config.WebDriverConfig;
import kz.shop.test.pages.AuthFormPage;
import kz.shop.test.pages.MainPage;
import kz.shop.test.testdata.PersonalAreaData;
import kz.shop.test.helpers.Helpers;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("shop.kz")
@Feature("Login")
@Owner("ostepovoyv")
@DisplayName("Тесты авторизации в интернет магазине shop.kz")
public class LoginTests extends BaseTest {

    MainPage mainPage = new MainPage();
    Helpers helpers = new Helpers();
    AuthFormPage authFormPage = new AuthFormPage();
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @Test
    @DisplayName("Успешная авторизация на сайте")
    public void successfulAuthorizationTest() {
        step("Тестируем успешную авторизацию на сайте", () -> {
            helpers.closeBanner();
            mainPage.goToAuthModalForm(PersonalAreaData.ENTER_BUTTON_TEXT);
            authFormPage
                    .checkModalFormTitle(PersonalAreaData.MODAL_FORM_TITLE_TEXT)
                    .setAuthInfo(config.getUserLogin(), config.userPassword())
                    .clickAuthButton();
            mainPage.checkAfterLogin(PersonalAreaData.PA_TEXT, PersonalAreaData.PERSONAL_SECTION_TITLE);
        });
    }

    @Test
    @DisplayName("Авторизация на сайте, пользователь не зарегистрирован")
    public void unsuccessfulAuthorizationTest() {
        step("Тестируем авторизацию с не существующим в системе пользователем", () -> {
            helpers.closeBanner();
            mainPage.goToAuthModalForm(PersonalAreaData.ENTER_BUTTON_TEXT);
            authFormPage
                    .checkModalFormTitle(PersonalAreaData.MODAL_FORM_TITLE_TEXT)
                    .setAuthInfo(config.unregisteredUserLogin(), config.unregisteredUserPassword())
                    .clickAuthButton()
                    .checkAuthStatus(PersonalAreaData.ERROR_TEXT);
        });
    }

}
