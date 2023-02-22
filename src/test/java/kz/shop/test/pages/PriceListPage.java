package kz.shop.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.xlstest.XLS;
import io.qameta.allure.Step;
import kz.shop.test.testdata.PriceList;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static kz.shop.test.testdata.Endpoints.PRICE_LIST_PAGE;
import static org.apache.commons.io.FileUtils.getFile;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceListPage {

    private String
            retailPriceLocator = "#li_76476",
            retailPriceFileCategory = "Розничный общий",
            servicesPriceLocator = "#li_83700",
            servicesPriceFileCategory = "Сервисные услуги";

    private final SelenideElement
            pagetitle = $("#pagetitle"),
            retailPriceList = $(retailPriceLocator),
            servicesPriceList = $(servicesPriceLocator);


    @Step("Переходим на страницу прайс листов")
    public PriceListPage openPriceListPage(String value) {
        open(PRICE_LIST_PAGE);
        pagetitle.shouldHave(Condition.text(value));
        return this;
    }

    @Step("Выбираем прайс лист {value}")
    public PriceListPage selectRetailPriceList(String value) {
        retailPriceList.shouldHave(Condition.text(value));
        return this;
    }

    @Step("Выбираем прайс лист {value}")
    public PriceListPage selectServicesPriceList(String value) {
        servicesPriceList.shouldHave(Condition.text(value));
        return this;
    }

    @Step("Проверяем файл {fileName} и его содержимое")
    public PriceListPage checkPriceList(PriceList priceList, File file) {
        checkFile(priceList, file);
        return this;
    }

    @Step("Загружаем файл, для дальнейшего использования в проверках")
    public File downloadFile(String fileName) throws FileNotFoundException {
        if (fileName.equals(retailPriceFileCategory)) {
            return $(retailPriceLocator).download();
        }
        if (fileName.equals(servicesPriceFileCategory)) {
            return $(servicesPriceLocator).download();
        }
        return null;
    }

    private void checkFile(PriceList priceList, File file) {
        assertThat(file.getName()).matches(priceList.getFileName());
        XLS xlsx = new XLS(getFile(file));
        assertThat(xlsx.excel.getSheetAt(priceList.getSheet()).getRow(priceList.getRow()).getCell(priceList.getCell()).getStringCellValue()).isEqualTo(priceList.getValue());
    }

}
