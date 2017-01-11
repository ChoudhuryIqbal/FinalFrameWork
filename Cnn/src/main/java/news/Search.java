package news;

import base.CommonAPI;
import org.testng.annotations.Test;

/**
 * Created by a on 1/10/2017.
 */
public class Search extends CommonAPI {

    @Test
    public void searchNews() throws  InterruptedException{
        clickByCss("#search-button");
        Thread.sleep(1000);
        typeByCss("#search-input-field","Politics");
        takeEnterKeys("#search-input-field");
        Thread.sleep(3000);
    }
}
