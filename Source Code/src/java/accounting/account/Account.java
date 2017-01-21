
package accounting.account;

import accounting.customer.Customer;
import connentor.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account extends Converter{
    private Connection connect = null;
    private Customer cus = null;
    public Account(){
        //Connector.setConnection("localhost", 3306, "shoponline", "root", "");
        connect = Connector.getConnection();
        cus = new Customer();
    }
    
    public List selectAccount(){
        String sql = "SELECT * FROM account";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectAccountByAuth(String email, String pwd){
        String sql = "SELECT * FROM account WHERE account_email = '"+email+"' and account_password = '"+pwd+"'";
        Statement st = null;
        ResultSet rs = null;
        Map map = new HashMap<>();
        List lt = new ArrayList();
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
            List<Map> accMap = super.extractDataProduct(rs);
            if(accMap.size() != 1) return new ArrayList();
            List<Map> cusMap = cus.selectCustomerByAccountId((Integer)accMap.get(0).get("account_id"));
            map.putAll(accMap.get(0));
            map.putAll(cusMap.get(0));
            lt.add(map);
        }catch(Exception ex){

        }
        return lt;
    }
    
    public List selectAccountById(Integer id){
        String sql = "SELECT * FROM account WHERE account_id = "+id+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectAccountByEmail(String keyword){
        String sql = "SELECT * FROM account WHERE account_email = '"+keyword+"'";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }

    public Integer insertAccount(Map data){
        Integer key = -1;
        try{
            if(insertEmpty(data)) return key;
            String email = (String)data.get("email");
            String password = (String)data.get("password");
            
            String sql = "INSERT INTO account(account_email, account_password) VALUES ('"+email+"','"+password+"')";
            
            Statement st = null;
            ResultSet rs = null;
            st = connect.createStatement();
            Integer id = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
            //connect.commit();
        }catch(Exception ex){
            try {
                //connect.rollback();
            } catch (Exception ex1) {
               
            }
        }
        return key;
    }
    
    public void regisComfirm(){
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
