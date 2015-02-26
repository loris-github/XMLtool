package tool;

import java.io.File;  
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  

import org.w3c.dom.Attr;  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.NamedNodeMap;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  


public class ParserOfXML {
	public static void main(String[] args) throws Exception  
    {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        DocumentBuilder db = dbf.newDocumentBuilder();        
        Document doc = db.parse(new File("gnet.gsd.xml"));  

        Element root = doc.getDocumentElement();
        
        List<XMLBean> beanList = new ArrayList<XMLBean>();
        
        String packageName = "";
        parseElement(root,packageName,beanList);
        
        /*
        for(XMLBean xb : beanList){
        	System.out.println(xb);
        }
        */
        
        JFCreater.doXToJ(beanList);
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
        			
        		String memberName = "";
    			String memberType = "";
    			
    			for(int j = 0; j < attributes.getLength(); j++) {       			
        			Attr attr = (Attr)attributes.item(j);
        			if(attr.getName() == "name") {
        				memberName = attr.getValue();  
        			}else if(attr.getName() == "type") {
        				memberType = attr.getValue();
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
				newName = path + File.separator + eName;
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
}

/*
private  Map<String,List<XMLBean>> parseRoot(Element rootNode,StringBuffer packageName){
	
	NodeList namespaceList = rootNode.getChildNodes();
	NamedNodeMap attributes = rootNode.getAttributes();
	List<XMLBean> beans;
		
	if (attributes == null) return null;
	for(int i = 0; i < attributes.getLength(); i++){			
		Attr attr = (Attr)attributes.item(i);
        if (attr.getName() == "name"){
        	packageName.append(attr.getValue());	        
        }	        
      }
	
	if(namespaceList == null) return null;
	
	Map<String,List<XMLBean>> subpackages = new HashMap<String,List<XMLBean>>();

	for(int i = 0; i < namespaceList.getLength(); i++){
		Node namespace = namespaceList.item(i);
		short nodeType = namespace.getNodeType();
		
		if(nodeType== Node.ELEMENT_NODE){
			
		}
		
		beans = parseNamespace(namespace);
		
		//subpackages.put(attrName, beans);
		
	}
	
		
	return 	subpackages;
}


private List<XMLBean> parseNamespace(Node namespace){	
	NodeList beanList = namespace.getChildNodes();
	NamedNodeMap attributes = namespace.getAttributes();
	
	if(beanList == null) return null;
	
	List<XMLBean> beans = new ArrayList<XMLBean>();
	

	for(int i = 0; i < beanList.getLength(); i++){
		Node bean = beanList.item(i);
		beans.add(parseBean (bean));
	}

	return beans;

}

private XMLBean parseBean (Node bean){		
	NodeList variableList = bean.getChildNodes();
	NamedNodeMap attributes = bean.getAttributes();

	if(variableList == null) return null;
	
	String beanName = ((Attr)attributes.item(0)).getValue(); 
	XMLBean xb = new XMLBean();
	xb.setBeanName(beanName);
	
	for(int i = 0; i < variableList.getLength(); i++){
		Node variable = variableList.item(i);
		parseVariable (variable,xb);
	}

	return xb;	
}
*/	