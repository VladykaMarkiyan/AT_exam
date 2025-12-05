package ui.components;

import org.openqa.selenium.WebElement;

public class TextField {
    private WebElement element;

    public TextField(WebElement element) {
        this.element = element;
    }

    public void setText(String text) {
        element.sendKeys(text);
    }

    public String getText() {
        return element.getAttribute("value");
    }
}
