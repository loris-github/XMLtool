package tool;

import java.io.File;  
import java.io.IOException;

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
        parseElement(root);
         
    }  
   
	private static void parseXMLFile(Element applicationName,DataOfTool dot){
		
		NodeList subPackages = applicationName.getChildNodes();
		
		if(null != subPackages){

		}
		
		
		
	}
	
	private void parseNamespace(NodeList namespaceList){
		
		if(null != namespaceList){
			for(int i = 0; i < namespaceList.getLength(); i++){
				
			}
		}
		
	}
	
	private void parseBean (){
		
	}
	
    private static void parseElement(Element element)  
    {  
        String tagName = element.getNodeName();
        
        if(tagName !="namespace") return;
             
        NodeList children = element.getChildNodes();        
        NamedNodeMap map = element.getAttributes();  
          
        //如果该元素存在属性  
        if(null != map)  
        {  
            for(int i = 0; i < map.getLength(); i++)  
            {  
                //获得该元素的每一个属性  
                Attr attr = (Attr)map.item(i);  
                  
                String attrName = attr.getName();  
                String attrValue = attr.getValue();  
                    
            }  
        }  
          
        System.out.print(">");  
          
        for(int i = 0; i < children.getLength(); i++)  
        {  
            Node node = children.item(i);  
            //获得结点的类型  
            short nodeType = node.getNodeType();  
              
            if(nodeType == Node.ELEMENT_NODE)  
            {  
                //是元素，继续递归  
                parseElement((Element)node);  
            }  
            else if(nodeType == Node.TEXT_NODE)  
            {  
                //递归出口  
                System.out.print(node.getNodeValue());  
            }  
            else if(nodeType == Node.COMMENT_NODE)  
            {  
                System.out.print("<!--");  
                  
                Comment comment = (Comment)node;  
                  
                //注释内容  
                String data = comment.getData();  
                  
                System.out.print(data);  
                  
                System.out.print("-->");  
            }  
        }  
          
        System.out.print("</" + tagName + ">");  
    }  
}
