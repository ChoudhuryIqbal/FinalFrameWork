package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by a on 1/16/2017.
 */
public class DBConnect {

    private Connection connect=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    List <String> list=new ArrayList<String>();



    public static Properties loadPropertiesFile() throws  Exception{
        Properties prop=new Properties();
        InputStream ism=new FileInputStream("C:\\Users\\a\\udemyAutomation\\FinalFrameWork\\Generic\\lib\\MySQL.properties");
        prop.load(ism);
        ism.close();
        return prop;

    }
    //connect to database
    public void connectToDatBase() throws Exception{
        Properties prop=loadPropertiesFile();
        String driverClass=prop.getProperty("MYSQLJDBC.driver");
        String url=prop.getProperty("MYSQLJDBC.url");
        String password=prop.getProperty("MYSQLJDBC.password");
        String userName=prop.getProperty("MYSQLJDBC.userName");
        //this will load the mysql driver
        Class.forName(driverClass);

        //set Up the connection with the db
        connect= DriverManager.getConnection(url,userName,password);
        System.out.println("Database connected");

    }



    public List<String> readDataBase() throws IOException,SQLException{
        try{
            connectToDatBase();
            //statement allow to issue SQL qureies to the database
            statement=connect.createStatement();
            //result set get the result of the sql query
            resultSet=statement.executeQuery("select * from CNNNewsVertical");
            getResultSetData(resultSet);

        }
        catch (Exception e){


        }
        finally {
           close();
        }
        return list;
    }
    public void queryDatabase(){

    }

    public List<String >getResultSetData(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            String itemName=resultSet.getString(0);
            list.add(itemName);

        }
        return list;
    }

    private void writeResultSetToConsole(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            String itemName=resultSet.getString("table1");
            System.out.println("News Title"+itemName);
        }
    }
    private  void close() throws  SQLException{
        try{
            if(resultSet !=null){
                resultSet.close();

            }
            if(statement!=null){
                statement.close();
            }
            if(connect!=null){
                connect.close();
            }
        }
        catch (Exception e){

        }

    }













}
