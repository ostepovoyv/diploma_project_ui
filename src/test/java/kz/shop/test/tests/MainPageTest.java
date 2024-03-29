package kz.shop.test.tests;

import io.qameta.allure.*;
import kz.shop.test.pages.MainPage;
import kz.shop.test.testdata.TestData;
import kz.shop.test.helpers.Helpers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Epic("shop.kz")
@Feature("Main")
@Owner("ostepovoyv")
@DisplayName("Тесты на главной странице магазина shop.kz")
public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    Helpers helpers = new Helpers();

    @ParameterizedTest(name = "Проверка наличия разделов на главной странице: {0}")
    @ValueSource(strings = {"Новости и анонсы", "Отзывы покупателей", "Опросы"})
    public void checkMainPageSection(String value) {
        step("Проверяем наличие разделов на главной странице", () -> {
            helpers.closeBanner();
            mainPage.verifySectionTitleText(value);
        });
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка бокового меню {0}")
    public void verifySidebarTest(String items, List<String> categories) {
        step("Проверка бокового меню", () -> {
            helpers.closeBanner();
            mainPage.verifySidebarMenu(items, categories);
        });
    }

    @ParameterizedTest(name = "Проверка горизонтального меню {0}")
    @ValueSource(strings = {"Доставка", "Оплата", "Гарантия надёжности"})
    public void verifyHorizontalMenuTest(String items) {
        step("Проверка горизонтального меню", () -> {
            helpers.closeBanner();
            mainPage.verifyHorizontalMenu(items);
        });
    }

    @ParameterizedTest(name = "Проверка элементов: {0}")
    @CsvFileSource(resources = "/test.csv")
    public void verifyFooterMenuItems(String items) {
        step("Тестируем пункты меню в футере", () -> {
            helpers.closeBanner();
            mainPage.verifyFooter(items);
        });
    }

    @Test
    @DisplayName("Проверка наличия контактной информации")
    public void checkContactInformation() {
        step("Проверка контактной информации в шапке на главной странице", () -> {
            helpers.closeBanner();
            mainPage.checkContactInfoInHeader(TestData.CONTACT_PHONE);
        });
        step("Проверка контактной информации в футере", () -> {
            mainPage
                    .selectMenuItem(TestData.ADDRESS_AND_PHONE)
                    .checkContactInfoInAdressAndPhone(
                            TestData.ADDRESS_TEXT,
                            TestData.DEPARTMENT,
                            TestData.CONTACT_PHONE_ON_PAGE
                    );
        });
        step("Проверка контактной информации в навигационном меню", () -> {
            mainPage.checkContactInfoInNavbar(TestData.CONTACT_PHONE);
        });
    }

    static Stream<Arguments> verifySidebarTest() {
        return Stream.of(
                Arguments.of(
                        "Смартфоны и гаджеты",
                        List.of("Сотовые телефоны", "Гаджеты", "Программное обеспечение", "Аксессуары")),
                Arguments.of(
                        "Комплектующие",
                        List.of("Все для сборки компьютера", "Дополнительные комплектующие")),
                Arguments.of(
                        "Ноутбуки и компьютеры",
                        List.of("Ноутбуки", "Компьютеры", "Программное обеспечение", "Комплектующие для ноутбуков", "Аксессуары", "Мебель"))
        );
    }

}
