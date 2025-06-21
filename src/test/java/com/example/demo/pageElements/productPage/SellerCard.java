package com.example.demo.pageElements.productPage;

import com.codeborne.selenide.SelenideElement;
import com.example.demo.pages.ProductPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SellerCard {
    private final SelenideElement SELLER_CARD = $x("//section[.//*[@data-testid='market_item_page_group_avatar']]");
    private final SelenideElement GO_TO_SHOP_BUTTON = $x("//*[@data-testid='market_item_page_shop_link']");
    private final SelenideElement GO_TO_COMMUNITY_BUTTON = $$x(".//*[@data-testid='market_item_page_shop_text']").last();

    public void isLoaded() {
        SELLER_CARD.shouldBe(visible.because("Market card should be visible on loaded product page"));
    }

    public ProductPage clickGoToShopButton() {
        GO_TO_SHOP_BUTTON.shouldBe(visible.because("Go to shop page button should be visible to click on it"))
                .scrollIntoView(true)
                .click();
        return page(ProductPage.class);
    }

    public ProductPage clickOnCommunityRedirectionLink() {
        GO_TO_COMMUNITY_BUTTON.shouldBe(visible.because("Community redirection link should be visible to click on it"))
                .scrollIntoView(true)
                .click();
        return page(ProductPage.class);
    }
}
