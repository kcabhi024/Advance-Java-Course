package DisplayAuthors;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UpdatingTable {


    static final String DATABASE_URL = "jdbc:mysql://localhost/books";

    // launch the application
    public static void main(String args[]) {
        Connection connection = null; // manages connection

        Statement statement = null; // query statement
        ResultSet resultSet = null; // manages results
// connect to database books and query database
        try {
// establish connection to database
            connection = DriverManager.getConnection(
                    DATABASE_URL, "root", "admin");
// create Statement for querying database
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
// query database
            resultSet = statement.executeQuery(
                    "SELECT author_id, first_name, last_name FROM Authors1");
// process query results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors Table of Books Database:\n");
            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();

            resultSet = statement.executeQuery("SELECT * from Authors1");
            while (resultSet.next()){
                resultSet.updateString("last_name" ,"KC");
                resultSet.updateRow();
            }

            resultSet.beforeFirst();
            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                System.out.println();
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch
        finally // ensure resultSet, statement and connection are closed
        {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } // end try
            catch (Exception exception) {
                exception.printStackTrace();
            } // end catch
        } // end finally
    }
}
