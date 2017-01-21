
package webstore.shoppingcart;

import co.omise.Client;
import co.omise.models.Charge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private String publicKey = null;
    private List<Map> orders = null;
    
    public ShoppingCart(String publicKey){
        this.publicKey = publicKey;
        orders = new ArrayList();
    }
    public void addOrder(Integer id, Integer color, Integer size){
        Map order = new HashMap();
        Boolean same = false;
        for(Map _order : orders){
            if(_order.get("id") == id && _order.get("color") == color && _order.get("size") == size){
                Integer index = orders.indexOf(_order);
                order.put("id", id);
                order.put("color", color);
                order.put("size", size);
                order.put("amount", ((Integer)_order.get("amount"))+1);
                orders.set(index, order);
                same = true;
            }
        }
        if(!same){
            order.put("id", id);
            order.put("color", color);
            order.put("size", size);
            order.put("amount", 1);
            orders.add(order);
        }
    }
    
    public List getOrders(){
        return orders;
    }
    
    public void clearOrders(){
        orders.clear();
    }
    
    public Boolean pay(String token,Integer amount){
        try {
            Client client = new Client(this.publicKey,"skey_test_56ctg4stb11s1qvejkb");
            Charge charge = client.charges().create(new Charge.Create()
                    .amount(amount*100) // THB 1,000.00
                    .currency("THB")
                    .card(token));
            if(charge.getStatus().toString().equals("Successful")) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
