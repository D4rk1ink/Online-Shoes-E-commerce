package ordering.order;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
    
    public Boolean insertEmpty(Map data){
        Map<String, Object> map = data;
        for (Map.Entry<String, Object> entry : map.entrySet()){
            if(!entry.getKey().toString().equals("id")){
                if( entry.getValue().toString().isEmpty()) return true;
            }
        }
        return false;
    }
    
    public List getColumnLabel(ResultSet rs){
        ResultSetMetaData metaData = null;
        List lable = new ArrayList();
        try {
            metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            for (int i = 1; i <= count; i++)
            {
               lable.add(metaData.getColumnLabel(i));
            }
        } catch (Exception ex) {
            
        }
        return lable;
    }
    
    public List convertResultSetToList(ResultSet rs){
        List<Map> object = new ArrayList<Map>();
        List lable = getColumnLabel(rs);
        try {
            while(rs.next()){
                Map<String, Object> map = new HashMap<String, Object>();
                for(int i=0;i<lable.size();i++){
                    String StringLable = lable.get(i).toString();
                    map.put(StringLable, rs.getObject(StringLable));
                }
                object.add(map);
            }
        } catch (Exception ex) {
            
        }
        return object;
    }
    
    public List extractDataProduct(ResultSet rs){
        List<Map> object = new ArrayList<Map>();
        List lable = getColumnLabel(rs);
        try {
            while(rs.next()){
                Map<String, Object> map = new HashMap<String, Object>();
                for(int i=0;i<lable.size();i++){
                    String StringLable = lable.get(i).toString();
                    map.put(StringLable, rs.getObject(StringLable));
                }
                object.add(map);
            }
        } catch (Exception ex) {
            
        }
        return object;
    }
    
    public Map compressDataProduct(Integer id, Integer payment, Integer product, Integer amount, Integer color, Integer size){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", id);
        data.put("payment", payment);
        data.put("product", product);
        data.put("color", color);
        data.put("size", size);
        data.put("amount", amount);
        return data;
    }
            
}
