package news;

import base.CommonAPI;
import org.testng.annotations.Test;
import reader.ReadNewsData;

import java.io.IOException;

/**
 * Created by a on 1/10/2017.
 */
public class SearchNewsFormExcelFile extends CommonAPI {
    ReadNewsData readNewsData=new ReadNewsData();


    @Test
    public void searchNews() throws  InterruptedException,IOException{
       /* clickByCss("#search-button");
        Thread.sleep(1000);
       // typeByCss("#search-input-field","Politics");
        //
        // typeByCss("#search-input-field",readNewsData.getData());
        String [] k=readNewsData.getData();
        typeByCss("#search-input-field",k[1]);

        takeEnterKeys("#search-input-field");
        Thread.sleep(3000);*/

        String [] data=readNewsData.getNewsFromExcelFile();
        clickByCss("#search-button");
        Thread.sleep(1000);
        int counter=0;
        for(String st:data){
            if(counter==0){
                typeByCss("#search-input-field",st);

                takeEnterKeys("#search-input-field");
                clearInputField("searchInputTop");
                Thread.sleep(1000);
                counter++;

            }
            else {
                typeByCss("#searchInputTop",st);
                takeEnterKeys("#searchInputTop");
                Thread.sleep(1000);
                clearInputField("searchInputTop");
            }
        }
    }
}
