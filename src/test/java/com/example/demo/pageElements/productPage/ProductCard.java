package com.example.demo.pageElements.productPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProductCard<T extends LoadableComponent<T>> {
    private final T page;
    private final SelenideElement CARD_SHARE_BUTTON = $x("//button[@data-testid='market_item_page_share']");
    private final SelenideElement CARD_GALLERY_CONTAINER = $x("//*[@data-testid='market_item_gallery_container']");
    private final SelenideElement CARD_ITEM_NAME = $x("//*[@data-testid='market_item_page_title']");
    private final SelenideElement CARD_ITEM_PRICE = $x("//*[@data-testid='market_item_page_price']");
    private final SelenideElement CARD_ITEM_DISCLAIMER = $x("//*[@data-testid='market_item_disclaimer']");
    private final SelenideElement CARD_ITEM_DESCRIPTION = $x("//*[@data-testid='market_item_page_description']");
    private final SelenideElement CARD_ITEM_DESCRIPTION_TITLE = $x("//*[@data-testid='market_item_description_title']");
    private final SelenideElement GO_TO_COMMUNITY_BUTTON = $x("//*[@data-testid='market_item_page_shop_text']");

    private final String DESCRIPTION_TITLE_TEXT = "Описание";

    public ProductCard(T page) {
        this.page = page;
    }

    public void isLoaded(){
        CARD_GALLERY_CONTAINER.shouldBe(visible.because("Product card should be visible on loaded product page"));
        CARD_ITEM_NAME.shouldBe(visible.because("Product name should be visible on loaded product page"));
        CARD_ITEM_DESCRIPTION.shouldBe(visible.because("Product description should be visible on loaded product page"));
    }

    public T checkItemName(String itemName){
        CARD_ITEM_NAME.shouldBe(visible.because("Item name should be visible on product card"))
                .shouldHave(text(itemName));
        return page;
    }

    public T checkItemPrice(String itemPrice){
        CARD_ITEM_PRICE.shouldBe(visible.because("Price should be visible on product card"))
                .shouldHave(text(itemPrice));
        return page;
    }

    public T checkItemDisclaimer(String itemDisclaimer){
        CARD_ITEM_DISCLAIMER.shouldBe(visible.because("Disclaimer should be visible on product card"))
                .shouldHave(text(itemDisclaimer));
        return page;
    }

    public T checkItemDescription(String itemDescription){
        CARD_ITEM_DESCRIPTION_TITLE.shouldBe(visible.because("Description title should be visible on product card"))
                        .shouldHave(text(DESCRIPTION_TITLE_TEXT));
        CARD_ITEM_DESCRIPTION.shouldBe(visible.because("Description should be visible on product card"))
                .shouldHave(text(itemDescription));
        return page;
    }

    public T clickOnShareItemButton() {
        CARD_SHARE_BUTTON.shouldBe(visible.because("Share button should be visible to click on it"))
                .click();
        return page;
    }

    public T clickOnCommunityRedirectionLink() {
        GO_TO_COMMUNITY_BUTTON.shouldBe(visible.because("Go to community page button should be visible to click on it"))
                .click();
        return page;
    }


}
