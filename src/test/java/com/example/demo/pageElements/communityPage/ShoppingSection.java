package com.example.demo.pageElements.communityPage;

import com.codeborne.selenide.SelenideElement;
import com.example.demo.pages.ShopPage;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ShoppingSection<T extends LoadableComponent<T>> {
    private final T page;
    private final SelenideElement TAB_MARKET = $x("//*[@data-testid='group_tab_market']");
    private final SelenideElement MARKET_LIST = $x("//div[@class='group-tab-content' and @data-tab='market']");
    private final SelenideElement MARKET_SHOW_ALL = MARKET_LIST.$x(".//*[@data-role='show-all']");
    private final SelenideElement TAB_SERVICES = $x("//*[@data-testid='group_tab_services']");
    private final SelenideElement SERVICES_LIST = $x("//div[@class='group-tab-content' and @data-tab='services']");
    private final SelenideElement SERVICES_SHOW_ALL = SERVICES_LIST.$x(".//*[@data-role='show-all']");

    public ShoppingSection(T page) {
        this.page = page(page);
    }

    public ShoppingSection<T> clickOnMarketTab() {
        TAB_MARKET.shouldBe(visible.because("Market tab should be visible to click on it"))
                .scrollIntoView("{block: 'center'}")
                .click();
        return this;
    }

    public ShoppingSection<T> clickOnServicesTab() {
        TAB_SERVICES.shouldBe(visible.because("Market tab should be visible to click on it"))
                .scrollIntoView("{block: 'center'}")
                .click();
        return this;
    }

    public T verifyMarketListIsShown() {
        MARKET_LIST.shouldBe(visible.because("Market list should be visible on opened market tab"));
        return page;
    }

    public T verifyServicesListIsShown() {
        SERVICES_LIST.shouldBe(visible.because("Services list should be visible on opened services tab"));
        return page;
    }

    public ShopPage goToMarketShopPage() {
        MARKET_SHOW_ALL.shouldBe(visible.because("Show all market button should be visible to click on it"))
                .scrollIntoView("{block: 'center'}")
                .click();
        return page(ShopPage.class);
    }

    public ShopPage goToServicesShopPage() {
        SERVICES_SHOW_ALL
                .shouldBe(visible.because("Show all services button should be visible to click on it"))
                .scrollIntoView("{block: 'center'}")
                .click();
        return page(ShopPage.class);
    }

}
