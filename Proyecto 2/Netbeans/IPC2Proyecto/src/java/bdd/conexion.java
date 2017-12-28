package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String cHOST = "localhost";
    private static final String cPORT = "3306";
    private static final String cDATABASE = "ipc2-proyecto";
    private static final String cUSER = "root";
    private static final String cPASS = "root";
    private static final String DB_CONNECTION = "jdbc:mariadb://" + cHOST + ":" + cPORT + "/" + cDATABASE;
    
    public Connection getDBConnection() {
        Connection dbConnection;
        try {
            Class.forName(DB_DRIVER);
//            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            dbConnection  =  DriverManager.getConnection(DB_CONNECTION, cUSER, cPASS);
            return dbConnection;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        conexion c = new conexion();
//        c.getDBConnection();
//        System.out.println("conecto");
//    }
}