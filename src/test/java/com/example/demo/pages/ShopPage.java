package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ShopPage extends LoadableComponent<ShopPage> {
    private final SelenideElement MARKET_SEARCH_WRAP = $x("//*[@id='market_search_wrap']");
    private final SelenideElement MARKET_LIST = $x("//*[@id='market_list']");

    @Override
    protected void load() { }

    @Override
    protected void isLoaded() throws Error {
        MARKET_LIST.shouldBe(visible.because("Market list should be visible on loaded shop page"));
        MARKET_SEARCH_WRAP.shouldBe(visible.because("Market search wrap should be visible on loaded shop page"));
    }
}
