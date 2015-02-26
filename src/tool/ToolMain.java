package tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ToolMain {
	public static void main(String[] args) throws Exception  
    {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        DocumentBuilder db = dbf.newDocumentBuilder();        
        Document doc = db.parse(new File("gnet.gsd.xml"));  

        Element root = doc.getDocumentElement();
        
        List<XMLBean> beanList = new ArrayList<XMLBean>();
        
        String packageName = "";
        XFReader.parseElement(root,packageName,beanList);
        
        /*
        for(XMLBean xb : beanList){
        	System.out.println(xb);
        }
        */
        
        JFCreater.doXToJ(beanList);
    }
}
