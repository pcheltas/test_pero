package com.example.demo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CommunityPage extends LoadableComponent<CommunityPage> {
    private final SelenideElement COMMON_GROUP_INFO = $x("//*[@class='redesigned-group-info']");
    private final SelenideElement DETAILED_GROUP_INFO = $x("//*[@id='page_group_info_block']");
    private final SelenideElement GROUP_WALL = $x("//*[@id='group_wall']");
    private final SelenideElement GROUP_FOLLOWERS = $x("//*[@id='group_followers']");

    @Override
    protected void load() {}

    @Override
    protected void isLoaded() throws Error {
        COMMON_GROUP_INFO.shouldBe(visible.because("Common group info should be visible on loaded community page"));
        DETAILED_GROUP_INFO.shouldBe(visible.because("Detailed group info should be visible on loaded community page"));
        GROUP_WALL.shouldBe(visible.because("Group wall should be visible on loaded community page"));
        GROUP_FOLLOWERS.shouldBe(visible.because("Group followers should be visible on loaded community page"));
    }
}
