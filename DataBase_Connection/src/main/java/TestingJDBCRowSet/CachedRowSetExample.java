package TestingJDBCRowSet;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetExample {

    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    static final String USERNAME = "root";
    static final String PASSWORD = "admin";

    public CachedRowSetExample() {

        try {
            // 1️⃣ Create CachedRowSet
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet rowSet = factory.createCachedRowSet();

            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USERNAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("SELECT * FROM authors");
            rowSet.execute(); // disconnected fetch

            // 2️⃣ Update data (offline)
            rowSet.absolute(4);
            rowSet.updateString("first_name", "kc");
            rowSet.updateRow();

            // insert
//            rowSet.moveToInsertRow();
//            rowSet.updateInt("author_id", 11);
//            rowSet.updateString("first_name", "Saugat");
//            rowSet.updateString("last_name", "Uprety");
//            rowSet.insertRow();
//            rowSet.moveToCurrentRow();

            //delete
            rowSet.absolute(5);
            rowSet.deleteRow();

            // 3️⃣ MANUAL connection with autoCommit OFF
            try (Connection con = DriverManager.getConnection(
                    DATABASE_URL, USERNAME, PASSWORD)) {

                con.setAutoCommit(false);   // 🔥 KEY FIX

                // 4️⃣ Push changes using provided connection
                rowSet.acceptChanges(con);

                con.commit();               // safe commit
            }

            // 5️⃣ Display results
            ResultSetMetaData meta = rowSet.getMetaData();
            int cols = meta.getColumnCount();

            System.out.println("Authors Table");
            for (int i = 1; i <= cols; i++)
                System.out.printf("%-15s", meta.getColumnName(i));
            System.out.println();

            rowSet.beforeFirst();
            while (rowSet.next()) {
                for (int i = 1; i <= cols; i++)
                    System.out.printf("%-15s", rowSet.getObject(i));
                System.out.println();
            }

            rowSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CachedRowSetExample();
    }
}
