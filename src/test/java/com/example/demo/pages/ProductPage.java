package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.demo.pageElements.productPage.CatalogSearchHeader;
import com.example.demo.pageElements.productPage.ProductCard;
import com.example.demo.pageElements.productPage.SellerCard;
import com.example.demo.pageElements.productPage.SharingPopUp;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://vk.com/club225299895?w=product-225299895_10044406
public class ProductPage extends LoadableComponent<ProductPage> {
    private final CatalogSearchHeader catalogSearchHeader;
    private final ProductCard productCard;
    private final SellerCard sellerCard;

    private final SelenideElement COMMENTS = $x("//*[@data-testid='tabs-item-comments']");

    public ProductPage() {
        this.catalogSearchHeader = new CatalogSearchHeader();
        this.productCard = new ProductCard();
        this.sellerCard = new SellerCard();
    }

    @Override
    protected void load() {}

    @Override
    protected void isLoaded() throws Error {
        productCard.isLoaded();
        sellerCard.isLoaded();
        COMMENTS.shouldBe(visible.because("Comments in product card should be visible on loaded product page"));
    }

    public ProductPage checkItemData(String itemName, String itemPrice, String itemDisclaimer, String itemDescription) {
        productCard.checkItemName(itemName);
        productCard.checkItemPrice(itemPrice);
        productCard.checkItemDisclaimer(itemDisclaimer);
        productCard.checkItemDescription(itemDescription);
        return this;
    }

    public ProductPage clickOnShareItemButton() {
        productCard.clickOnShareItemButton();
        return this;
    }

    public ProductPage verifyUnauthPopupIsShown() {
        new SharingPopUp()
                .get()
                .verifyPopUpIsShownAndCloseIt();
        return this;
    }

    public ShopPage goToShopPage() {
        sellerCard.clickGoToShopButton();
        switchTo().window(1);
        return page(ShopPage.class);
    }

    public CommunityPage goToCommunityPageFromProductCard() {
        productCard.clickOnCommunityRedirectionLink();
        switchTo().window(1);
        return page(CommunityPage.class);
    }

    public CommunityPage goToCommunityPageFromSellerCard() {
        sellerCard.clickOnCommunityRedirectionLink();
        switchTo().window(1);
        return page(CommunityPage.class);
    }

    public SearchPage searchByQuery(String query) {
        catalogSearchHeader.searchByString(query);
        return page(SearchPage.class).get();
    }

    public SearchPage searchByCatalogSection(String section) {
        catalogSearchHeader.searchByCatalogSection(section);
        return page(SearchPage.class).get();
    }


}
