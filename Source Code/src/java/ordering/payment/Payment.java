
package ordering.payment;

import connentor.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class Payment extends Converter{
    private Connection connect = null;
    public Payment(){
        //Connector.setConnection("localhost", 3306, "shoponline", "root", "");
        connect = Connector.getConnection();
    }
    
    public List selectPayment(){
        String sql = "SELECT * FROM payment, status WHERE delivery_status = status_id ORDER BY payment_id DESC";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectDeliveryStatus(){
        String sql = "SELECT * FROM status";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectPaymentByAccountId(Integer id){
        String sql = "SELECT * FROM payment, status WHERE payment_account = "+id+" and delivery_status = status_id ORDER BY payment_id DESC";
        System.out.println(sql);
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectPaymentById(Integer id){
        String sql = "SELECT * FROM payment, status WHERE payment_id = "+id+" and delivery_status = status_id";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public Integer insertPayment(Map data){
        Integer key = -1;
        try{
            if(insertEmpty(data)) return key;
            Integer account = (Integer)data.get("account");
            Integer amount = (Integer)data.get("amount");
            String date = (String)data.get("date");
            String name = (String)data.get("name");
            String address = (String)data.get("address");
            
            String sql = "INSERT INTO payment(payment_amount, payment_date, payment_account, payment_name, payment_address) VALUES ("+amount+",'"+date+"',"+account+",'"+name+"','"+address+"')";
            
            Statement st = null;
            ResultSet rs = null;
            st = connect.createStatement();
            Integer id = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return key;
    }
    
    public void updatePaymentStatus(Integer payment_id, Integer status_id){
        String sql = "UPDATE payment SET delivery_status = "+status_id+" WHERE payment_id = "+payment_id;
        System.out.println(sql);
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            st.executeUpdate(sql);
        }catch(Exception ex){

        }
    }
    
    public void payComfirm(){
        try {
            connect.commit();
        } catch (Exception ex) {
            try {
                connect.rollback();
            } catch (Exception ex1) {
                
            }
        }
    }
}
