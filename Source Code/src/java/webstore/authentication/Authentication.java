package webstore.authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Authentication {
    private Integer id = null;
    private String email = null;
    private String firstname = null;
    private String lastname = null;
    private String phone = null;
    private String address = null;
    public Boolean login(List<Map> result){
        if(result.size() == 0) return false;
        this.id = (Integer)result.get(0).get("account_id");
        this.email = result.get(0).get("account_email").toString();
        this.firstname = result.get(0).get("customer_firstname").toString();
        this.lastname = result.get(0).get("customer_lastname").toString();
        this.phone = result.get(0).get("customer_phone").toString();
        this.address = result.get(0).get("customer_address").toString();
        return true;
    }
    
    public Boolean register(Boolean result){
        return result;
    }
    
    public Map getSession(){
        Map map = new HashMap();
        map.put("id", id);
        map.put("email", email);
        map.put("firstname", firstname);
        map.put("lastname", lastname);
        map.put("phone", phone);
        map.put("address", address);
        return map;
    }
    
    public Boolean isEmail(String email){
        boolean result = true;
        try {
           InternetAddress emailAddr = new InternetAddress(email);
           emailAddr.validate();
        } catch (AddressException ex) {
           result = false;
        }
        return result;
    }
    
    public Boolean validateRegister(String email,String password, String cpassword, List account){
        if(isEmail(email) && password.equals(cpassword) && account.size() == 0) return true;
        return false;
    }
    
    
}
