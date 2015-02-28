package tool;

import java.io.File;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	
	private static String getWrapper(String typeName){
		
		if(typeName.equals("byte")){
			
			String Wrapper = typeName.replace("byte", "Byte");
			return Wrapper;
			
		}else if(typeName.equals("boolean")){
			
			String Wrapper = typeName.replace("boolean", "Boolean");
			return Wrapper;
			
		}else if(typeName.equals("short")){
			
			String Wrapper = typeName.replace("short", "Short");
			return Wrapper;
			
		}else if(typeName.equals("char")){
			
			String Wrapper = typeName.replace("char", "Character");
			return Wrapper;
			
		}else if(typeName.equals("int")){
			
			String Wrapper = typeName.replace("int", "Integer");
			return Wrapper;
			
		}else if(typeName.equals("long")){
			
			String Wrapper = typeName.replace("long", "Long");
			return Wrapper;
			
		}else if(typeName.equals("float")){
			
			String Wrapper = typeName.replace("float", "Float");
			return Wrapper;
			
		}else if(typeName.equals("double")){
			
			String Wrapper = typeName.replace("double", "Double");
			return Wrapper;
			
		}
		
		return typeName;
		
	}
	
	private static void parseVariable(NamedNodeMap attributes,Map<String,String> members){
		
		try{
			
			String memberName = ((Attr)attributes.getNamedItem("name")).getValue().replaceAll("\\s*", "");
						
			if(memberName == null) throw new Exception("The memberName is null");
			
			String typeName = ((Attr)attributes.getNamedItem("type")).getValue().replaceAll("\\s*", "").toLowerCase();
			
			if(typeName == null) throw new Exception("The typeName is null");
			
			StringBuffer strType;

			// String 类型
			if (typeName.equals("string")){
				
				strType = new StringBuffer("String");
				
			
			}else if (typeName.equals("string[]")){
				
				strType = new StringBuffer("String");
				
			// List 类型
			}else if(typeName.equals("list")){
				
				String strValue = ((Attr)attributes.getNamedItem("value")).getValue().replaceAll("\\s*", "");
				
				if(strValue == null) throw new Exception("The "+ typeName +" 's value is null");
				if(strValue.equals("string")) strValue = "String";
				strValue = getWrapper(strValue);
				
				strType = new StringBuffer().append("List")
						.append("<")
						.append(strValue)
						.append(">");
			
			// Map 类型	
			}else if(typeName.equals("map")){
				
				String strKey = ((Attr)attributes.getNamedItem("key")).getValue().replaceAll("\\s*", "");
				
				if(strKey == null) throw new Exception("The "+ typeName +" 's key is null");
				if(strKey.equals("string")) strKey = "String";
				strKey = getWrapper(strKey);
				
				String strValue =  ((Attr)attributes.getNamedItem("value")).getValue().replaceAll("\\s*", "");
				
				if(strValue == null) throw new Exception("The "+ typeName +" 's value is null");
				if(strValue.equals("string")) strValue = "String";
				strValue = getWrapper(strValue);
				
				strType = new StringBuffer().append("Map")
						.append("<")
						.append(strKey).append(",").append(strValue)
						.append(">");
			
			// 其他类型
			}else{
				
				String strValue = ((Attr)attributes.getNamedItem("type")).getValue().replaceAll("\\s*", "");
				
				if(strValue == null) throw new Exception("The "+ typeName +" 's type is null");
				
				strType = new StringBuffer(strValue);
				
			}

			String memberType = strType.toString();
			
			members.put(memberName,memberType);
			
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		}

	}
	
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
        		
        		
        		parseVariable(attributes,xb.getMembers());
        		
        		/*
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
				*/
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
