package TestingJDBCRowSet;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import  javax.sql.rowset.RowSetProvider;



public class jdbcRowSet {

    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    static  final String USERNAME ="root";
    static final  String PASSWORD ="admin";


    public jdbcRowSet(){
        try {
            RowSetFactory myFactory= RowSetProvider.newFactory();
            JdbcRowSet rowSet = myFactory.createJdbcRowSet();
            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USERNAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("SELECT* FROM authors");
            rowSet.execute();
            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors table of the database");


            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();
            while (rowSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", rowSet.getObject(i));
                System.out.println();
            }// end while
            rowSet.close();
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
        }

    public static void main(String[] args) {
        jdbcRowSet app =new jdbcRowSet();
    }
    }

