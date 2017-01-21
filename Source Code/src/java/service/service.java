package service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class service {
    public static String getPath(HttpServletRequest request,String sub){
        return request.getServletContext().getRealPath("") + File.separator + sub;
    }
    
    public static  List getImages(HttpServletRequest request){
        List<List> images = new ArrayList();     
        List<InputStream> imageStream = new ArrayList();
        List<String> imageName = new ArrayList();
        try {
            for (Part part : request.getParts()) {
                if(part.getName().equals("product-picture[]")){ 
                    String fileName = getFileName(part);
                    if(!fileName.isEmpty() && fileName != null){
                        List image = new ArrayList();
                        imageStream.add(part.getInputStream());
                        imageName.add(fileName);
                        
                    }
                }
            }
            images.add(imageStream);
            images.add(imageName);
        } catch (Exception ex) {
            
        }

        return images;
    }
    
    public static  String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
