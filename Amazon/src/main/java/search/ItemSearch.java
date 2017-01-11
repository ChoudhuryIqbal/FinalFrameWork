package search;

import base.CommonAPI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by a on 1/10/2017.
 */
    public class ItemSearch extends CommonAPI {



    @Test
    public void dropDownSearch() throws InterruptedException{
       // Thread.sleep(3000);
        //Alert alert=driver.switchTo().alert();
       // alert.dismiss();
        String mainWinHandle = driver.getWindowHandle(); // Get your main window
        //String subWinHandle = null;
        System.out.println(mainWinHandle);
        WebDriverWait wait=new WebDriverWait(driver,1000);
        Thread.sleep(5000);
        String picky=driver.getWindowHandle();
        System.out.println(picky);
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("searchDropdownBox")));


       /* Set<String> allHandle = driver.getWindowHandles(); // Fetch all handles
        //Iterator<String> iterator = allHandle.iterator();
       // while (iterator.hasNext()){
           // subWinHandle = iterator.next();
       // }
        //driver.switchTo().window(subWinHandle); // switch to popup

//Write code to close Ad or skip

       // driver.switchTo().window(mainWinHandle);
      //  String myWindowHandle=driver.getWindowHandle();
       // driver.switchTo().window(myWindowHandle);
        Thread.sleep(3000);
*/


        List <WebElement> list=new ArrayList<WebElement>();
        try{
            list=getListWebElements("searchDropdownBox option");
        }
        catch(Exception e){
            String pick=driver.getWindowHandle();
            System.out.println(pick);

        }
        WebElement element=driver.findElement(By.id("searchDropdownBox"));
        for(int i=1;i<list.size();i++){
            selectOptionByVisibleTest(element,list.get(i).getText());
            takeEnterKeys("#twotabsearchtextbox");
            Thread.sleep(2000);
            element=driver.findElement(By.id("searchDropdownBox"));
            list=getListWebElements("searchDropdownBox option");

        }

    }
}
