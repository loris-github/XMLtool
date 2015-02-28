package tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XFReader2 {
	
	public static List<XMLBean> parseXMLFile(String XMLPath){
		
		List<XMLBean> beanList = new ArrayList<XMLBean>(); 
		
		
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(XMLPath));
			Element node = document.getRootElement();
			
			parseElement(node,new String(""),beanList);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return beanList;
	}
	
	private static void parseElement(Element element,String path,List<XMLBean> beanList){
		
	}
	
}
