package com.example.demo.pageElements.productPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SharingPopUp extends LoadableComponent<SharingPopUp> {
    private final SelenideElement UNAUTH_ACTION_BOX = $x("//*[contains(@class, 'UnauthActionBox')]");
    private final SelenideElement CLOSE_BUTTON = $x("//*[contains(@class, 'UnauthActionBox__close')]");
    private final SelenideElement SIGN_IN_BUTTON = $x("//*[contains(@class, 'UnauthActionBox__login')]");
    private final SelenideElement SIGN_UP_BUTTON = $x("//*[contains(@class, 'UnauthActionBox__join')]");

    @Override
    protected void load() { }

    @Override
    protected void isLoaded() throws Error {
        UNAUTH_ACTION_BOX.shouldBe(visible.because("Box popup should be visible on loaded unauth box"));
        CLOSE_BUTTON.shouldBe(visible.because("Closing button should be visible on loaded unauth box"));
        SIGN_IN_BUTTON.shouldBe(visible.because("Sign in button should be visible on loaded unauth box"));
        SIGN_UP_BUTTON.shouldBe(visible.because("Sign up button should be visible on loaded unauth box"));
    }

    public void verifyPopUpIsShownAndCloseIt() {
        UNAUTH_ACTION_BOX.shouldBe(visible.because("Box popup should be visible on loaded unauth box"));
        CLOSE_BUTTON.shouldBe(visible.because("Closing button should be visible to click on it"))
                .click();
        UNAUTH_ACTION_BOX.shouldNotBe(visible.because("Box popup should not be visible after it was closed"));
    }
}
