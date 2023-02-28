package kz.shop.test.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.shop.test.testdata.Item;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductCardPage {

    private final SelenideElement
            pageTitle = $("#pagetitle"),
            vendorCode = $(".bx-card-mark"),
            currentPrice = $(".item_current_price"),
            productSpecifications = $("#bx-card-features"),
            buyButton = $("#product-card-buttons"),
            itemSlider = $(".bx_item_slider");

    private final ElementsCollection
            slideMenu = $$(".slide-toggle"),
            cardInfo = $$(".detail-dwp-title");

    @Step("Проверка наличия названия товара")
    public ProductCardPage checkPageTitleAvailableOnPage(String value) {
        pageTitle.shouldHave(visible).shouldHave(text(value));
        return this;
    }

    @Step("Проверка наличия Артикула товара")
    public ProductCardPage checkVendorCodeAvailableOnPage(String value) {
        vendorCode.shouldHave(text("Артикул " + value));
        return this;
    }

    @Step("Проверка наличия цены товара")
    public ProductCardPage checkCurrentPriceAvailableOnPage() {
        currentPrice.shouldBe(appear);
        return this;
    }

    @Step("Проверка наличия кнопки 'Купить' товар")
    public ProductCardPage checkBuyButtonAvailableOnPage(String value) {
        buyButton.shouldBe(visible).shouldHave(text(value));
        return this;
    }

    @Step("Проверка наличия информации о технических характеристиках товара")
    public ProductCardPage checkProductSpecificationsAvailableOnPage(String value) {
        productSpecifications.scrollTo().shouldBe(visible).shouldHave(text(value));
        return this;
    }

    @Step("Добавляем выбранный товар в корзину")
    public ProductCardPage addProductToCart(String value) {
        buyButton.click();
        buyButton.shouldHave(text(value));
        return this;
    }

    @Step("Проверка элементов в слайд меню")
    public ProductCardPage checkSlideMenuItemCount(Integer value) {
        slideMenu.shouldHave(CollectionCondition.size(value));
        return this;
    }

    @Step("Проверка названий в слайд меню")
    public ProductCardPage checkSlideMenuItemNames(Item item) {
        $("label[for='bxe-slide-item-" + item.getId() + "'] span").shouldHave(Condition.text(item.getName()));
        return this;
    }

    @Step("Проверка наличия слайдера с изображением товара")
    public ProductCardPage checkItemImageSlider() {
        itemSlider.shouldHave(Condition.appear);
        return this;
    }

    @Step("Проверка информации о доставке, оплате и гарантии")
    public ProductCardPage checkProductCardInfo(String item1, String item2, String item3) {
        cardInfo.shouldHave(texts(item1, item2, item3));
        return this;
    }

}
