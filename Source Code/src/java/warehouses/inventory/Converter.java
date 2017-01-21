package warehouses.inventory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    if(StringLable.equals("product_img")){
                        String[] imgs = rs.getObject(StringLable).toString().split("\\|");
                        List listimg = new ArrayList();
                        
                        for(String img : imgs){
                            if(!img.isEmpty()) listimg.add(img);   
                        }
                        map.put(StringLable, listimg);
                    }else{
                        map.put(StringLable, rs.getObject(StringLable));
                    }
                    
                }
                object.add(map);
            }
        } catch (Exception ex) {
            
        }
        return object;
    }
    
    public Map compressDataProduct(String id, String name,String detail,List pictures,Integer brand,Integer person,Double price,Integer quantity){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", id);
        data.put("name", name);
        data.put("detail", detail);
        String StringPicture = "";
        List<String> listpictures = new ArrayList();
        for(int i=0;i<pictures.size();i++){
            if(!pictures.get(i).toString().isEmpty()){
                listpictures.add(pictures.get(i).toString());
            }
        }
        for(int i=0;i<listpictures.size();i++){
            StringPicture += listpictures.get(i).toString();
            if(i != listpictures.size()-1){
                StringPicture += "|";
            }
        }

        data.put("pictures", StringPicture);
        data.put("brand", brand);
        data.put("person", person);
        data.put("price", price);
        data.put("quantity", quantity);
        //data.put("color", color);
        //data.put("size", size);
        return data;
    }
            
}
