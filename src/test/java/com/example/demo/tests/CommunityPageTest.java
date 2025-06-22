package com.example.demo.tests;

import com.example.demo.pages.CommunityPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class CommunityPageTest extends BaseTest {
    private final String COMMUNITY_PAGE_URL = "/club225299895";
    private final String COMMUNITY_NAME = "Test public for test";
    private final String MARKET_HEADER = "Товары";
    private final String SERVICES_HEADER = "Услуги";

    @BeforeEach
    void setUp() {
        open(COMMUNITY_PAGE_URL);
    }

    @DisplayName("Verify group name is correct")
    @Test
    void communityPage_verifyGroupName() {
        new CommunityPage()
                .get()
                .verifyGroupNameCorrect(COMMUNITY_NAME);
    }

    @DisplayName("Verify detailed group info displays")
    @Test
    void communityPage_verifyDetailedGroupInfo() {
        new CommunityPage()
                .get()
                .openDetailedGroupInfo()
                .verifyDetailedInformationIsShown();
    }

    @DisplayName("Verify reviews button works")
    @Test
    void communityPage_verifyReviewsButton() {
        new CommunityPage()
                .get()
                .goToReviewsPage()
                .get();
    }

    @DisplayName("Verify shopping section (market & services) works")
    @Test
    void communityPage_verifyShoppingSection() {
        new CommunityPage()
                .get()
                .openMarketTabAndCheckItems()
                .openServicesTabAndCheckItems();
    }

    @DisplayName("Verify redirecting to market shop page works")
    @Test
    void communityPage_verifyRedirectingToMarketShopPage() {
        new CommunityPage()
                .get()
                .goToMarketShopPage()
                .get()
                .verifySectionHeaderContainsText(MARKET_HEADER);
    }

    @DisplayName("Verify redirecting to market shop page works")
    @Test
    void communityPage_verifyRedirectingToServicesShopPage() {
        new CommunityPage()
                .get()
                .goToServicesShopPage()
                .get()
                .verifySectionHeaderContainsText(SERVICES_HEADER);
    }


}
