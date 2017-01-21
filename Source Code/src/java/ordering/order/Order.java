
package ordering.order;

import connentor.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class Order extends Converter{
    private Connection connect = null;
    public Order(){
        //Connector.setConnection("localhost", 3306, "shoponline", "root", "");
        connect = Connector.getConnection();
    }
    
    public List selectOrder(){
        String sql = "SELECT * FROM `order`";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectOrderByPaymentId(Integer id) {
        String sql = "SELECT * FROM `order`, payment, product, brand, person, color, size WHERE order_payment = "+id+" AND "
                + "order_payment = payment_id AND "
                + "order_product = product_id AND "
                + "product_brand = brand_id AND "
                + "product_person = person_id AND "
                + "order_color = color_id AND "
                + "order_size = size_id";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public Boolean insertOrder(Map data){
        try{
            Integer payment = (Integer)data.get("payment");
            Integer product = (Integer)data.get("product");
            Integer color = (Integer)data.get("color");
            Integer amount = (Integer)data.get("amount");
            Integer size = (Integer)data.get("size");
            
            String sql = "INSERT INTO `order`(order_payment, order_product, order_amount, order_color, order_size) VALUES ("+payment+","+product+","+amount+","+color+","+size+")";
            System.out.println(sql);
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
