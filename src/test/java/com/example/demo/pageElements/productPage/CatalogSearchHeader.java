package com.example.demo.pageElements.productPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogSearchHeader<T extends LoadableComponent<T>> {
    private final T nextPage;
    private final SelenideElement CATALOG_BUTTON = $x("//*[@data-testid='market_category_menu_button']");
    private final SelenideElement CART_BUTTON = $x("//*[@data-testid='market_item_page_storefront_cart_button']");
    private final SelenideElement MARKET_SEARCH = $x("//input[@date-testid='market_item_page_header_search']");
    private final ElementsCollection CATALOG_SECTIONS = $$x("//*[@data-testid='market_category_menu_root_item']");

    public CatalogSearchHeader(T nextPage) {
        this.nextPage = nextPage;
    }

    public void isLoaded(){
        CATALOG_BUTTON.shouldBe(visible.because("Catalog button should be visible on loaded catalog search header"));
        MARKET_SEARCH.shouldBe(visible.because("Market search should be visible on loaded catalog search header"));
        CART_BUTTON.shouldBe(visible.because("Cart button should be visible on loaded catalog search header"));
    }

    public T searchByString(String searchString) {
        MARKET_SEARCH.click();
        MARKET_SEARCH.shouldBe(visible.because("Searching input should be visible to input text"))
                .setValue(searchString)
                .pressEnter();
        switchTo().window(1);
        return nextPage;
    }

    public T searchByCatalogSection(String catalogSection) {
        CATALOG_BUTTON.click();
        CATALOG_SECTIONS.findBy(text(catalogSection)).click();
        switchTo().window(1);
        return nextPage;
    }

}
