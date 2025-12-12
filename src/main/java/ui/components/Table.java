package ui.components;

import core.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Table {

    private ElementActions actions;

    public Table(WebDriver driver) {
        this.actions = new ElementActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "tr")
    private List<WebElement> rows;

    public int getRowCount() {
        return rows.size();
    }

    public WebElement getRow(int index) {
        return rows.get(index);
    }
}
