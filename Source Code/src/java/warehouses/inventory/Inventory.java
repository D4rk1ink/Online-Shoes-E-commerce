package warehouses.inventory;
import connentor.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Inventory extends Converter{
    private Connection connect = null;
    public Inventory(){
        connect = Connector.getConnection();
    }
    
    public List selectProduct(){
        String sql = "SELECT * FROM product,brand,person WHERE product.product_brand = brand.brand_id and product.product_person = person.person_id ORDER BY product.product_id DESC";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectProductLimit(Integer limit){
        String sql = "SELECT * FROM product,brand,person WHERE product.product_brand = brand.brand_id and product.product_person = person.person_id ORDER BY product.product_id DESC LIMIT "+limit+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectProductById(Integer id){
        String sql = "SELECT * FROM product,brand,person WHERE product_id = "+id+" and product.product_brand = brand.brand_id and product.product_person = person.person_id";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectProductByName(Integer person, String keyword){
        String sql = "SELECT * FROM product,brand,person WHERE product.product_person = "+person+" AND LOWER(product_name) LIKE LOWER('%"+keyword+"%') and product.product_brand = brand.brand_id and product.product_person = person.person_id ORDER BY product.product_id DESC";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectProductByFilterPrice(String keyword){
        String sql = "SELECT * FROM product,brand,person WHERE product.product_brand = brand.brand_id and product.product_person = person.person_id ORDER BY product.product_price "+keyword+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectProductByBrand(Integer brand){
        String sql = "SELECT * FROM product,brand,person WHERE product.product_brand = "+brand+" and product.product_person = person.person_id and product.product_brand = brand.brand_id ORDER BY product.product_id DESC";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectProductByPerson(Integer person){
        String sql = "SELECT * FROM product,brand,person WHERE product.product_person = "+person+" and product.product_person = person.person_id and product.product_brand = brand.brand_id ORDER BY product.product_id DESC";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectProductByPersonBrand(Integer person,Integer brand){
        String sql = "SELECT * FROM product,brand,person WHERE product.product_brand = brand.brand_id AND product.product_person = person.person_id AND product.product_person = "+person+" AND product.product_brand = "+brand+" ORDER BY product.product_id DESC";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectBrand(){
        String sql = "SELECT * FROM brand";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectBrandById(Integer id){
        String sql = "SELECT * FROM brand WHERE brand.brand_id = "+id+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectPerson(){
        String sql = "SELECT * FROM person";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectColor(){
        String sql = "SELECT * FROM color";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectColorById(Integer id){
        String sql = "SELECT * FROM color WHERE color_id = "+id+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectSize(){
        String sql = "SELECT * FROM size";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectSizeById(Integer id){
        String sql = "SELECT * FROM size WHERE size_id = "+id+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }
    
    public List selectPersonById(Integer id){
        String sql = "SELECT * FROM person WHERE person.person_id = "+id+"";
        Statement st = null;
        ResultSet rs = null;
        try{
            st = connect.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception ex){

        }
        return super.extractDataProduct(rs);
    }

    public boolean insertProduct(Map data){
        try{
            if(insertEmpty(data)) return false;
            String name = (String)data.get("name");
            String detail = (String)data.get("detail");
            String pictures = (String)data.get("pictures");
            Integer brand = (Integer)data.get("brand");
            Integer person = (Integer)data.get("person");
            Double price = (Double)data.get("price");
            Integer quantity = (Integer)data.get("quantity");
            String sql = "INSERT INTO product(product_name, product_detail, product_img, product_brand, product_person, product_price, product_quantity) "
                       + "VALUES ('"+name+"','"+detail+"','"+pictures+"',"+brand+","+person+","+price+","+quantity+")";
            
            Statement st = null;
            ResultSet rs = null;
            st = connect.createStatement();
            st.executeUpdate(sql);
            
            return true;
        }catch(Exception ex){

        }
        return false;
    }
    
    public boolean deleteProduct(Integer id){
        try{
            String sql = "DELETE FROM product WHERE product_id = "+id;
            
            Statement st = null;
            ResultSet rs = null;
            st = connect.createStatement();
            st.executeUpdate(sql);
            connect.commit();
            return true;
        }catch(Exception ex){
            System.out.print(ex);
            try {
                connect.rollback();
            } catch (Exception ex1) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
    
    public void addComfirm(){
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
