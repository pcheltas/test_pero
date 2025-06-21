package com.example.demo.tests;

import com.example.demo.pages.ProductPage;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Product page functionality tests")
public class ProductPageTest extends BaseTest {
    private final String PRODUCT_PAGE_URL = "/club225299895?w=product-225299895_10044406";

    @BeforeEach
    void setUp() {
        open(PRODUCT_PAGE_URL);
    }

    @DisplayName("Verify text product data is correct")
    @ParameterizedTest
    @MethodSource("provideCardTextData")
    void productPage_verifyTextDataIsCorrect(String itemName, String itemPrice, String itemDisclaimer, String itemDescription) {
        new ProductPage()
                .get()
                .checkItemData(itemName, itemPrice, itemDisclaimer, itemDescription);
    }

    @DisplayName("Check product item sharing button works and unauth popup appears")
    @Test
    void productPage_checkItemSharingButton() {
        new ProductPage()
                .get()
                .clickOnShareItemButton()
                .verifyUnauthPopupIsShown();
    }

    @DisplayName("Verify redirecting to market page works")
    @Test
    void productPage_verifyRedirectingToMarketPage() {
        new ProductPage()
                .get()
                .goToShopPage()
                .get();
    }

    @DisplayName("Verify redirecting to community page from product card works")
    @Test
    void productPage_verifyRedirectingToCommunityPageFromProduct() {
        new ProductPage()
                .get()
                .goToCommunityPageFromProductCard()
                .get();
    }

    @DisplayName("Verify redirecting to community page from seller card works")
    @Test
    void productPage_verifyRedirectingToCommunityPageFromSeller() {
        new ProductPage()
                .get()
                .goToCommunityPageFromSellerCard()
                .get();
    }

    @DisplayName("Verify text search works")
    @ParameterizedTest
    @MethodSource("provideSearchQueries")
    void productPage_verifyTextSearchWorks(String searchQuery) {
        new ProductPage()
                .get()
                .searchByQuery(searchQuery)
                .verifyCatalogItemHasText(searchQuery);
    }

    @DisplayName("Verify search by catalog sections works")
    @ParameterizedTest
    @MethodSource("provideCatalogSectionNames")
    void productPage_verifySearchByCatalogSectionNames(String section) {
        new ProductPage()
                .get()
                .searchByCatalogSection(section)
                .verifyBreadcrumbLabelHasText(section);
    }


    static Stream<Arguments> provideSearchQueries() {
        return Stream.of(arguments("молоко"),
                arguments("платье"),
                arguments("наушники"));
    }

    static Stream<Arguments> provideCatalogSectionNames() {
        return Stream.of(
                arguments("Женщинам"),
                arguments("Хобби и развлечения"),
                arguments("Товары для геймеров"));
    }

    static Stream<Arguments> provideCardTextData() {
        return Stream.of(
                arguments("фываф",
                        "бесплатно",
                        "Перед покупкой уточняйте характеристики и комплектацию у продавца",
                        "testing product")
        );
    }
}
