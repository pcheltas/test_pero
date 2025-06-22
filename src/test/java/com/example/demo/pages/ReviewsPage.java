package com.example.demo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ReviewsPage extends LoadableComponent<ReviewsPage> {
    private final SelenideElement SORTING_DROPDOWN = $x("//*[@data-testid='sorting-dropdown']");
    private final SelenideElement REVIEWS_SECTION = SORTING_DROPDOWN.closest("section");
    private final SelenideElement RATING_SUMMARY = $x("//*[@data-testid='rating-summary']");
    private final SelenideElement RATING_SECTION = RATING_SUMMARY.closest("section");


    @Override
    protected void load() { }

    @Override
    protected void isLoaded() throws Error {
        REVIEWS_SECTION.shouldBe(visible.because("Reviews section should be visible on loaded reviews page"));
        RATING_SUMMARY.shouldBe(visible.because("Rating summary should be visible on loaded reviews page"));
    }
}
