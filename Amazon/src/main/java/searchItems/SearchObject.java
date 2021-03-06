package searchItems;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by a on 1/14/2017.
 */
public class SearchObject {

    public WebDriver pageObjectDriver;

    @FindBy(css="#searchDropdownBox")
    public WebElement dropDownMenu;

    @FindBy(css = "twotabsearchtextbox")
    public WebElement searchField;


    public SearchObject (WebDriver driver){
        this.pageObjectDriver=driver;
        PageFactory.initElements(driver,this);
    }
}
