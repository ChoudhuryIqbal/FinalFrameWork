package util;

import java.util.List;
import java.util.Stack;

/**
 * Created by a on 1/16/2017.
 */
public class TestDBConnection {


    public static void main(String[] args    ) throws Exception{
        DBConnect dbConnect=new DBConnect();
        List<String> newsList=dbConnect.readDataBase();
    }
}
