package tool;

import java.io.File;  

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
  
import org.w3c.dom.Attr;  
import org.w3c.dom.Comment;  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.NamedNodeMap;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
  
/** 
 * 使用递归解析给定的任意一个xml文档并且将其内容输出到命令行上 
 * @author zhanglong 
 * 
 */  
public class DomTest3  
{  
    public static void main(String[] args) throws Exception  
    {  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        DocumentBuilder db = dbf.newDocumentBuilder();  
          
        Document doc = db.parse(new File("gnet.gsd.xml"));  
        //获得根元素结点  
        Element root = doc.getDocumentElement(); 
        //System.out.print();
          
        parseElement(root);  
    }  
      
    private static void parseElement(Element element)  
    {  
        String tagName = element.getNodeName();  
          
        NodeList children = element.getChildNodes();  
          
        System.out.print("<" + tagName);  
          
        //element元素的所有属性所构成的NamedNodeMap对象，需要对其进行判断  
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
                  
                System.out.print(" " + attrName + "=\"" + attrValue + "\"");  
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
