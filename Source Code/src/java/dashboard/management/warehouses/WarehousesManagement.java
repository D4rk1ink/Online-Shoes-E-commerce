package dashboard.management.warehouses;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WarehousesManagement {
    public WarehousesManagement(){
        
    }
    
    public List viewProduct(List list){
        return list;
    }
    
    public Boolean addProduct(Boolean result){
        return result;
    }
    
    public Boolean addProduct(List<InputStream> images,List<String> filename, String path,Boolean result){
        if(!result) return false;
        if(images.size() != filename.size()) return false;
        try{
            for(int i=0;i<images.size();i++){
                File file = new File(path, filename.get(i));
                try (InputStream input = images.get(i)) {
                    Files.copy(input, file.toPath());
                } 
            }
            return true;
        }catch(Exception ex){

        }
        return false;
    }
    
    public Boolean updateProduct(Boolean result){
        return result;
    }
    
    public Boolean deleteProduct(Boolean result){
        return result;
    }
    
    public Boolean cancelProduct(Boolean result){
        return result;
    }
    
    public List viewBrand(List list){
        return list;
    }
    
    public List viewPerson(List list){
        return list;
    }
    
    
}
