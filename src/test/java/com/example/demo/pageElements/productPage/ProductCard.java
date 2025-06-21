package com.example.demo.pageElements.productPage;

import com.codeborne.selenide.SelenideElement;
import com.example.demo.pages.ProductPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ProductCard {
    private final SelenideElement CARD_SHARE_BUTTON = $x("//button[@data-testid='market_item_page_share']");
    private final SelenideElement CARD_GALLERY_CONTAINER = $x("//*[@data-testid='market_item_gallery_container']");
    private final SelenideElement CARD_ITEM_NAME = $x("//*[@data-testid='market_item_page_title']");
    private final SelenideElement CARD_ITEM_PRICE = $x("//*[@data-testid='market_item_page_price']");
    private final SelenideElement CARD_ITEM_DISCLAIMER = $x("//*[@data-testid='market_item_disclaimer']");
    private final SelenideElement CARD_ITEM_DESCRIPTION = $x("//*[@data-testid='market_item_page_description']");
    private final SelenideElement CARD_ITEM_DESCRIPTION_TITLE = $x("//*[@data-testid='market_item_description_title']");
    private final SelenideElement GO_TO_COMMUNITY_BUTTON = $x("//*[@data-testid='market_item_page_shop_text']");

    private final String DESCRIPTION_TITLE_TEXT = "Описание";

    public void isLoaded(){
        CARD_GALLERY_CONTAINER.shouldBe(visible.because("Product card should be visible on loaded product page"));
        CARD_ITEM_NAME.shouldBe(visible.because("Product name should be visible on loaded product page"));
        CARD_ITEM_DESCRIPTION.shouldBe(visible.because("Product description should be visible on loaded product page"));
    }

    public ProductPage checkItemName(String itemName){
        CARD_ITEM_NAME.shouldBe(visible.because("Item name should be visible on product card"))
                .shouldHave(text(itemName));
        return page(ProductPage.class);
    }

    public ProductPage checkItemPrice(String itemPrice){
        CARD_ITEM_PRICE.shouldBe(visible.because("Price should be visible on product card"))
                .shouldHave(text(itemPrice));
        return page(ProductPage.class);
    }

    public ProductPage checkItemDisclaimer(String itemDisclaimer){
        CARD_ITEM_DISCLAIMER.shouldBe(visible.because("Disclaimer should be visible on product card"))
                .shouldHave(text(itemDisclaimer));
        return page(ProductPage.class);
    }

    public ProductPage checkItemDescription(String itemDescription){
        CARD_ITEM_DESCRIPTION_TITLE.shouldBe(visible.because("Description title should be visible on product card"))
                        .shouldHave(text(DESCRIPTION_TITLE_TEXT));
        CARD_ITEM_DESCRIPTION.shouldBe(visible.because("Description should be visible on product card"))
                .shouldHave(text(itemDescription));
        return page(ProductPage.class);
    }

    public ProductPage clickOnShareItemButton() {
        CARD_SHARE_BUTTON.shouldBe(visible.because("Share button should be visible to click on it"))
                .click();
        return page(ProductPage.class);
    }

    public ProductPage clickOnCommunityRedirectionLink() {
        GO_TO_COMMUNITY_BUTTON.shouldBe(visible.because("Go to community page button should be visible to click on it"))
                .click();
        return page(ProductPage.class);
    }


}
