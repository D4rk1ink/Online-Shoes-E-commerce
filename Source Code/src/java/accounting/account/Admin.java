package accounting.account;

import connentor.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Admin extends Converter{
    private Connection connect = null;
    public Admin(){
        connect = Connector.getConnection();
    }
    
    public List selectAdminLogin(String username, String password){
        String sql = "SELECT * FROM admin WHERE admin_username = '"+username+"' AND admin_password = '"+password+"'";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
}
