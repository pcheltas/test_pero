package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.demo.pageElements.communityPage.ShoppingSection;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class CommunityPage extends LoadableComponent<CommunityPage> {
    private final ShoppingSection shoppingSection;

    private final SelenideElement COMMON_GROUP_INFO = $x("//*[@class='redesigned-group-info']");
    private final SelenideElement GROUP_NAME = $x("//*[@class='page_name']");
    private final SelenideElement DETAILED_GROUP_INFO_BUTTON = $x("//*[@id='page_group_info_block']");
    private final SelenideElement DETAILED_GROUP_INFO_BLOCK = $x("//*[@id='wk_content']");
    private final SelenideElement GROUP_WALL = $x("//*[@id='group_wall']");
    private final SelenideElement GROUP_FOLLOWERS = $x("//*[@id='group_followers']");
    private final SelenideElement GROUP_REVIEWS = $x("//*[@data-testid='rating-layout-after']");
    private final SelenideElement GROUP_RATING = $x("//*[@data-testid='rating-layout-main']");

    public CommunityPage() {
        this.shoppingSection = new ShoppingSection<>(this);
    }

    @Override
    protected void load() {}

    @Override
    protected void isLoaded() throws Error {
        COMMON_GROUP_INFO.shouldBe(visible.because("Common group info should be visible on loaded community page"));
        DETAILED_GROUP_INFO_BUTTON.shouldBe(visible.because("Detailed group info should be visible on loaded community page"));
        GROUP_WALL.shouldBe(visible.because("Group wall should be visible on loaded community page"));
        GROUP_FOLLOWERS.shouldBe(visible.because("Group followers should be visible on loaded community page"));
    }

    public CommunityPage verifyGroupNameCorrect(String groupName) {
        GROUP_NAME.shouldBe(visible.because("Group name should be visible to check it"))
                .shouldHave(text(groupName));
        return this;
    }

    public CommunityPage openDetailedGroupInfo() {
        DETAILED_GROUP_INFO_BUTTON.shouldBe(visible.because("Detailed group info should be visible to click on it"))
                .scrollIntoView(true)
                .click();
        return this;
    }

    public CommunityPage verifyDetailedInformationIsShown() {
        DETAILED_GROUP_INFO_BLOCK.shouldBe(visible.because("Detailed group info block should be visible on opened info"));
        return this;
    }

    public ReviewsPage goToReviewsPage() {
        GROUP_RATING.shouldBe(visible.because("Group rating should be visible in community header"));
        GROUP_REVIEWS.shouldBe(visible.because("Reviews button should be visible to click on it"))
                .click();
        return page(ReviewsPage.class);
    }

    public CommunityPage openMarketTabAndCheckItems() {
        shoppingSection
                .clickOnMarketTab()
                .verifyMarketListIsShown();
        return this;
    }

    public ShopPage goToMarketShopPage() {
        return shoppingSection
                .clickOnMarketTab()
                .goToMarketShopPage();
    }

    public ShopPage goToServicesShopPage() {
        return shoppingSection
                .clickOnServicesTab()
                .goToServicesShopPage();
    }

    public CommunityPage openServicesTabAndCheckItems() {
        shoppingSection
                .clickOnServicesTab()
                .verifyServicesListIsShown();
        return this;
    }




}
