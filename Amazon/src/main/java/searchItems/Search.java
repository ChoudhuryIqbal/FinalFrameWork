package searchItems;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by a on 1/14/2017.
 */
public class Search {


    @FindBy(how = How.CSS,using ="#twotabsearchtextbox" )

    public static WebElement searchInnput;

    @FindBy(how=How.CSS,using = ".nav-input")
    public WebElement serachSubmit;

    public void searchFor(String item){
        searchInnput.sendKeys(item, Keys.ENTER);
    }

    public void clearSearch(){
        searchInnput.clear();
    }

}
