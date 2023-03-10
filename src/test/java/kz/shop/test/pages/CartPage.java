package kz.shop.test.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {

    private final SelenideElement
            cartButton = $(".hub-i-cart-link"),
            cartTitle = $("#pagetitle"),
            productNameInCart = $(".cart-bill-name"),
            cartSubmit = $("#CartSubmit"),
            deleteButton = $(".cart__rem-item");

    @Step("Переход в корзину по ссылке")
    public CartPage openCart(String value){
        open(value);
        return this;
    }

    @Step("Переход в корзину")
    public CartPage goToCart() {
        cartButton.click();
        return this;
    }

    @Step("Проверяем, переход в корзину")
    public CartPage checkCartPage(String value) {
        cartTitle.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем, добавленный товар в корзине")
    public CartPage checkProductInCart(String value) {
        productNameInCart.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем доступность кнопки оформить")
    public CartPage checkOrderButton(String value) {
        cartSubmit.shouldHave(type("button")).shouldHave(value(value));
        return this;
    }

    @Step("Удаление продукта из корзины")
    public CartPage deleteProduct() {
        deleteButton.click();
        return this;
    }

    @Step("Проверка корзины после удаления")
    public CartPage checkAfterDelete() {
        productNameInCart.shouldNot(exist);
        return this;
    }
}
