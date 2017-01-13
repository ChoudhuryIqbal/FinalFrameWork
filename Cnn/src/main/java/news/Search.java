package news;

import base.CommonAPI;
import org.testng.annotations.Test;
import reader.ReadNewsData;

import java.io.IOException;

/**
 * Created by a on 1/10/2017.
 */
public class Search extends CommonAPI {
    ReadNewsData readNewsData=new ReadNewsData();


    @Test
    public void searchNews() throws  InterruptedException,IOException{
        clickByCss("#search-button");
        Thread.sleep(1000);
       // typeByCss("#search-input-field","Politics");
        //
        // typeByCss("#search-input-field",readNewsData.getData());
        String [] k=readNewsData.getData();
        typeByCss("#search-input-field",k[1]);

        takeEnterKeys("#search-input-field");
        Thread.sleep(3000);
    }
}
