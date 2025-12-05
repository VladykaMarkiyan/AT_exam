package ui.components;

import org.openqa.selenium.WebElement;

public class Button {
    private WebElement element;

    public Button(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }
}
