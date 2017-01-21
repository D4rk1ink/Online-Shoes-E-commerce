package accounting.customer;

import connentor.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class Customer extends Converter {
    private Connection connect = null;
    public Customer(){
        //Connector.setConnection("localhost", 3306, "shoponline", "root", "");
        connect = Connector.getConnection();
    }
    
    public List selectCustomer(){
        String sql = "SELECT * FROM customer";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectCustomerById(Integer id){
        String sql = "SELECT * FROM customer WHERE customer_id = "+id+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectCustomerByAccountId(Integer id){
        String sql = "SELECT * FROM customer WHERE customer_account = "+id+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }

    public boolean insertCustomer(Map data){
        try{
            if(insertEmpty(data)) return false;
            Integer account = (Integer)data.get("account");
            String firstname = (String)data.get("firstname");
            String lastname = (String)data.get("lastname");
            String phone = (String)data.get("phone");
            String address = (String)data.get("address");
            
            String sql = "INSERT INTO customer(customer_account, customer_firstname,customer_lastname,customer_phone,customer_address) VALUES ('"+account+"','"+firstname+"','"+lastname+"','"+phone+"','"+address+"')";
            
            Statement st = null;
            ResultSet rs = null;
            st = connect.createStatement();
            st.executeUpdate(sql);
            return true;
        }catch(Exception ex){

        }
        return false;
    }
}
