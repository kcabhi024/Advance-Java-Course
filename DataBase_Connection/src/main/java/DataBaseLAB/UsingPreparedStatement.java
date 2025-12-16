package DataBaseLAB;

    // launch the application
import java.sql.*;

public class UsingPreparedStatement {
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    public static void main(String args[]) {
        Connection connection = null; // manages connection

        Statement statement = null; // query statement
        ResultSet resultSet = null; // manages results
// connect to database books and query database
        try {
// establish connection to database
            connection = DriverManager.getConnection(
                    DATABASE_URL, "root", "admin");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            connection.setAutoCommit(false);

// create Statement for querying database
//            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO authors VALUES(?,?,?)");
//
//            pstmt.setInt(1,1);
//            pstmt.setString(2,"abhi");
//            pstmt.setString(3,"dada");
//            pstmt.addBatch();


            // Update
//            PreparedStatement pstmt = connection.prepareStatement("UPDATE authors SET last_name = ? WHERE author_id = ?");
//            pstmt.setString(1, "KC");
//            pstmt.setInt(2, 1);
//            pstmt.addBatch();

            //Delete
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM authors WHERE author_id = ?");
            pstmt.setInt(1, 1);
            pstmt.addBatch();


            //
            int[] updateCounts = pstmt.executeBatch();
            connection.commit();


            resultSet = statement.executeQuery(
                    "SELECT author_id, first_name, last_name FROM authors");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors Table of Books Database:\n");
            System.out.println("Delete Data");
            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();

            resultSet.beforeFirst();
            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                System.out.println();
            }
        } // end try
        catch (BatchUpdateException sqlException) {
            sqlException.printStackTrace();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        // end catch
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
    } //



}
