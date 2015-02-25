package tool;

import java.io.File;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
  

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;  
import org.w3c.dom.Comment;  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.NamedNodeMap;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;

public class ParserOfXML {
	public static void main(String[] args) throws Exception  
    {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        DocumentBuilder db = dbf.newDocumentBuilder();        
        Document doc = db.parse(new File("gnet.gsd.xml"));  
        //获得根元素结点 
        Element root = doc.getDocumentElement(); 
        //parseElement(root);
         
    }

	private  void parseRoot(Element rootNode){
		NodeList namespaceList = rootNode.getChildNodes();		
		if(null != namespaceList){
			for(int i = 0; i < namespaceList.getLength(); i++){
				Node namespace = namespaceList.item(i);
				parseNamespace(namespace);
			}
		}
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
	
	private void parseVariable(Node variable,XMLBean xb){		
		NamedNodeMap attributes = variable.getAttributes();		
		if(null !=attributes){			
			for(int i = 0; i < attributes.getLength(); i++){  	            
	            Attr attr = (Attr)attributes.item(i);                
	            String attrName = attr.getName();  
	            String attrType = attr.getValue();	            
	            xb.addMember(attrName, attrType);
	        }	
		}
	}
	
    private static void parseElement(Element element,DataOfTool dot){
        String tagName = element.getNodeName();         
        NodeList children = element.getChildNodes();        
        NamedNodeMap map = element.getAttributes();
        
        //如果该元素存在属性  
        if(null != map){  
            for(int i = 0; i < map.getLength(); i++){  
                //获得该元素的每一个属性  
                Attr attr = (Attr)map.item(i);                  
                String attrName = attr.getName();  
                String attrValue = attr.getValue();                   
            }  
        }  
           
        for(int i = 0; i < children.getLength(); i++){  
            Node node = children.item(i); 
            //获得结点的类型  
            short nodeType = node.getNodeType();  
              
            if(nodeType == Node.ELEMENT_NODE){  
                //是元素，继续递归  
                parseElement((Element)node,dot);  
            }  
            else{
            	
            }
        }
    }  
}
