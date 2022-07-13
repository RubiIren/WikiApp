package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Tag("android")
    @Test
    @DisplayName("Проверка выдачи")
    void searchTest() {
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Tag("android")
    @Test
    @DisplayName("Проверка наличия description")
    void descriptionTest() {
        step("Type search", () -> {
            back();
            step("Type search", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
                $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("cat");
            });

            step("Go to article", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                        .shouldHave(text("Domesticated felid species"));
            });
        });
    }

    @Tag("android")
    @Test
    @DisplayName("Проверка перехода на статью")
    void openArticalTest() {
        step("Type search", () -> {
            back();
            step("Type search", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
                $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("cat");
            });

            step("Go to article", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
                $(AppiumBy.className("android.view.View")).click();
                $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Cat"));
            });
        });

    }

}