package connentor;
import accounting.account.*;
import warehouses.inventory.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connector {
    private static String host = null;
    private static int port = -1;
    private static String db_name = null;
    private static String db_user = null;
    private static String db_password = null;
    private static Connection connect = null;

    public static void setConnection(String host,int port,String db_name,String db_user,String db_password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db_name,db_user,db_password);
            connect.setAutoCommit(false);
            if(connect != null){
                    System.out.println("Database Connected.");
            } else {
                    System.out.println("Database Connect Failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        return connect;
    }
}
