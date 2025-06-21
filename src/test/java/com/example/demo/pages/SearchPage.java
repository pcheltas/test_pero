package com.example.demo.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage extends LoadableComponent<SearchPage> {

    private final SelenideElement MARKET_CATALOG_BLOCK = $x("//*[@data-testid='market-catalog-block']");
    private final SelenideElement BREADCRUMB_LABEL = $x("//*[@data-testid='breadcrumb-current']");
    private final ElementsCollection CATALOG_LIST_ITEMS = $$x("//*[@data-testid='catalog-list-item']");

    @Override
    protected void load() { }

    @Override
    protected void isLoaded() throws Error {
        MARKET_CATALOG_BLOCK.shouldBe(visible.because("Market catalog block should be visible on loaded search page"));
    }

    public SearchPage verifyCatalogItemHasText(String text) {
        CATALOG_LIST_ITEMS.shouldBe(CollectionCondition.sizeGreaterThan(0)
                .because("Catalog items list should contain items to check them"))
                .first()
                .shouldHave(text(text));
        return this;
    }

    public SearchPage verifyBreadcrumbLabelHasText(String text) {
        BREADCRUMB_LABEL.shouldBe(visible.because("Breadcrumb label should be visible to check it"))
                .shouldHave(text(text));
        return this;
    }
}
