package news;

import base.CommonAPI;
import org.testng.annotations.Test;
import reader.ReadNewsData;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.IOException;
import java.util.List;

/**
 * Created by a on 1/16/2017.
 */
public class SearchNewsFromDB extends CommonAPI {
    ReadNewsData readNewsData=new ReadNewsData();

    @Test
    public void searchNews() throws InterruptedException,IOException,Exception{
        //List <String> data=readNewsData.getDataFromDB();
        logger.info("Running News SearchNewsFormExcelFile on Cnn");
        List<String> data=readNewsData.getNewsDataFromDB("cnnnewsvertical","NewsTitle");

        clickByCss("#search-button");
        Thread.sleep(2000);
        int counter=0;
        for (String st:data){
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
