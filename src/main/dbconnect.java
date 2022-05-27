package main;

import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {

        private static String url = "jdbc:mysql://127.0.0.1:3306/userinfo";
        private static String drivername = "com.mysql.jdbc.Driver";
        private static String username = "root";
        private static String password = "";
        private static java.sql.Connection con;
        private static String urlstring;

        public java.sql.Connection getconnection() throws ClassNotFoundException, SQLException {

            Class.forName(drivername);
            try {
                con = (java.sql.Connection) DriverManager.getConnection(url, username, password);
                System.out.println("connected..");
            } catch (Exception e) {
                System.out.println("something went wrong..." + e);
            }

            return con;
        }
>>>>>>> Stashed changes

  private static final String url = "jdbc:mysql://127.0.0.1:3306";
  private static final String drivername = "com.mysql.jdbc.Driver";
  private static final String username = "root";
  private static final String password = "";
  private static java.sql.Connection con;
  private static String urlstring;

  public java.sql.Connection getconnection() throws ClassNotFoundException, SQLException {

    Class.forName(drivername);
    try {
      con = DriverManager.getConnection(url, username, password);
      System.out.println("connected..");
    } catch (Exception e) {
      System.out.println("something went wrong..." + e);
    }

    return con;
  }

  public static void cloaseconnection() throws SQLException {
    try {
      con.close();
    } catch (Exception e) {
      System.out.println("something wrong" + e);
    }
  }

}
