package search;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import searchItems.ProductsToBeSearched;
import searchItems.Search;

import java.io.IOException;

/**
 * Created by a on 1/14/2017.
 */
public class Products extends CommonAPI {
    @Test
    public void searchItems() throws IOException,InterruptedException{
        Search search = PageFactory.initElements(driver,Search.class);
        ProductsToBeSearched productsToBeSearched=new ProductsToBeSearched();
        String [] products=productsToBeSearched.getProducts();
        for(String product:products){
            search.searchFor(product);
            sleepFor(2);
            search.clearSearch();
        }
    }
}
