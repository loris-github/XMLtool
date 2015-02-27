package tool;

import java.io.File;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;  
import org.w3c.dom.Document;
import org.w3c.dom.Element;  
import org.w3c.dom.NamedNodeMap;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;


public class XFReader {


	private static void parseBean(NodeList children,String packageName,List<XMLBean> beanList,String beanName){
		
		XMLBean xb = new XMLBean();
		xb.setPath(packageName);
		xb.setBeanName(beanName);
		
		if (children == null) return;

		for(int i = 0; i < children.getLength(); i++){
			
            Node node = children.item(i);
            
            if(node.getNodeType() == Node.ELEMENT_NODE || node.getNodeName() == "variable") {
            	
        		NamedNodeMap attributes = node.getAttributes();
        		
        		try {
        			if(attributes == null)
        			throw new Exception("variable is empty!");
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        			
        		String memberName = "";
    			String memberType = "";
    			
    			for(int j = 0; j < attributes.getLength(); j++) {       			
        			Attr attr = (Attr)attributes.item(j);
        			if(attr.getName() == "name") {
        				memberName = attr.getValue();  
        			}else if(attr.getName() == "type") {
        				memberType = attr.getValue();
        				if(memberType.toLowerCase().equals("string")) memberType = "String";			
        			}else{
        				try {
							throw new Exception("this variable is valid data !");
						} catch (Exception e) {
							e.printStackTrace();
						}
        			}
        	    }       		
        		xb.addMember(memberName, memberType);
            }      
        }

		beanList.add(xb);
	}
	
    private static void parseElement(Element element,String path,List<XMLBean> beanList){
        String tagName = element.getNodeName();
        NodeList children = element.getChildNodes();        
        NamedNodeMap map = element.getAttributes();
        
        //检查
		try {
			if (map == null)
			throw new Exception("element's name is not found!");				
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		String eName = "";

		for(int i = 0; i < map.getLength(); i++){		
			Attr attr = (Attr)map.item(i);
	        if (attr.getName() == "name"){		        	
	        	eName = attr.getValue();   
	       }	        
	    }
		
		//System.out.println(eName);
		
		//如果不是bean 则继续递归

		if(tagName == "bean") {			
			String lastName = path;
			parseBean(children,path,beanList,eName);
			path = lastName;
			
		}else {
			//生成路径
			
			String newName;
			
			if(path.equals("")){
				newName = path+eName;
			}else{
				newName = path + "." + eName;
			}

	        for(int i = 0; i < children.getLength(); i++){  
	            Node node = children.item(i);          
	            if(node.getNodeType() != Node.ELEMENT_NODE) continue;
	            
	            String lastName = path;
	            parseElement((Element)node,newName,beanList);
	            path = lastName;
	            
	        }	        
	        	        
		}
    } 

    public static List<XMLBean> parseXMLFile(String XMLPath){
    	
    	List<XMLBean> beanList = new ArrayList<XMLBean>();
    	
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder	db = dbf.newDocumentBuilder();
			Document doc  = db.parse(new File(XMLPath));
			Element root = doc.getDocumentElement();
			parseElement(root,new String(""),beanList);
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
			
		} catch (SAXException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}  

    	return beanList;
  	
    }

}
