package kz.shop.test.tests;

import io.qameta.allure.*;
import kz.shop.test.pages.PriceListPage;
import kz.shop.test.testdata.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.qameta.allure.Allure.step;
import static kz.shop.test.testdata.PriceLists.*;

@Epic("shop.kz")
@Feature("Price")
@Owner("ostepovoyv")
@DisplayName("Тесты доступности и содержимого прайс-листов")
public class PriceListTests extends BaseTest {

    PriceListPage priceListPage = new PriceListPage();

    @Test
    @DisplayName("Проверка доступности и содержимого розничного прайс-листа")
    public void checkRetailPriceList() {
        step("Тестируем розничный прайс-лист", () -> {
            priceListPage
                    .openPriceListPage(TestData.PR_TEXT)
                    .selectRetailPriceList(TestData.PR_RETAIL);
            File file = priceListPage.downloadFile(TestData.PR_RETAIL);
            priceListPage
                    .checkPriceList(prRetailCompanyName, file)
                    .checkPriceList(prRetailSite, file)
                    .checkPriceList(prRetailName, file)
                    .checkPriceList(prRetailCode, file)
                    .checkPriceList(prRetailNomination, file)
                    .checkPriceList(prRetailPrice, file)
                    .checkPriceList(prRetailGuarantee, file)
                    .checkPriceList(prRetailNote, file);
        });
    }

    @Test
    @DisplayName("Проверка доступности и содержимого прайс-листа сервисных услуг")
    public void checkServicesPriceList() {
        step("Тестируем прайс-лист сервисных услуг", () -> {
            priceListPage
                    .openPriceListPage(TestData.PR_TEXT)
                    .selectServicesPriceList(TestData.PR_SERVICES);
            File file = priceListPage.downloadFile(TestData.PR_SERVICES);
            priceListPage
                    .checkPriceList(prServicesCompanyName, file)
                    .checkPriceList(prServicesName, file)
                    .checkPriceList(prServicesCode, file)
                    .checkPriceList(prServicesNomination, file)
                    .checkPriceList(prServicesPrice, file);
        });
    }

}
