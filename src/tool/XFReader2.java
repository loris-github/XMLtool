package tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

			String strRootName = node.attributeValue("name");
			
			StringBuffer path = new StringBuffer(strRootName);
			
			parseElement(node,path,beanList);
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
		return beanList;
	}
	
	//判断null值，专门用于抛异常
	private static boolean isNull(Object o,String strException){
		
		if(o == null) {
			
			try {
				
				throw new Exception(strException) ;	
				
			} catch (Exception e) {	
				
				e.getMessage();
				e.printStackTrace();
				return true;
				
			}
		}
		
		return false;
	}
	
	//将基础类型转化成泛型时，合适的类型
	private static String convertFormat(String str){
		
		if(str.equals("string") || str.equals("string[]")) {
			
			return str.replace("s", "S");
			
		} else{
			
			return str = getWrapper(str);
		}
		
	}
	
	//将基础类型转化成包装类型
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
	
	//解析variable标签内容，生成bean的属性
	private static void parseVariable(Element eleVariable,Map<String,String> members){
		
		String memberName = eleVariable.attributeValue("name").replaceAll("\\s*", "");
		
		if(isNull(memberName,"The memberName is null")) return;
		
		String typeName = eleVariable.attributeValue("type").replaceAll("\\s*", "").toLowerCase();
		
		if(isNull(typeName,"The typeName is null")) return;
		
		StringBuffer strType;

		// String 类型
		if (typeName.equals("string") || typeName.equals("string[]")){

			strType = new StringBuffer(typeName.replace("s", "S"));
			
		// List 类型		
		}else if(typeName.equals("list") || typeName.equals("list[]")){
			
			typeName = typeName.replace("l", "L");
			
			String strValue = eleVariable.attributeValue("value").replaceAll("\\s*", "");
			
			if(isNull(strValue,"The "+ typeName +" 's value is null")) return;

			strValue = convertFormat(strValue);
			
			StringBuffer strGeneric = new StringBuffer().append("<").append(strValue).append(">");
						
			strType = new StringBuffer().append(typeName).insert(4, strGeneric);
					
		
		// Map 类型	
		}else if(typeName.equals("map") || typeName.equals("map[]")){
			
			typeName = typeName.replace("m", "M");
			
			String strKey = eleVariable.attributeValue("key").replaceAll("\\s*", "");
			
			if(isNull(strKey,"The "+ typeName +" 's key is null")) return;
						
			strKey = convertFormat(strKey);	
			
			String strValue = eleVariable.attributeValue("value").replaceAll("\\s*", "");
			
			if(isNull(strValue,"The "+ typeName +" 's value is null")) return;
						
			strValue = convertFormat(strValue);
			
			StringBuffer strGeneric = new StringBuffer().append("<").append(strKey).append(",").append(strValue).append(">");
			
			strType = new StringBuffer().append(typeName).insert(3, strGeneric);
					
		
		// 其他类型
		}else{
			
			String str = eleVariable.attributeValue("type").replaceAll("\\s*", "");
			
			if(isNull(str,"The "+ typeName +" 's value is null")) return;
						
			strType = new StringBuffer(str);
			
		}

		String memberType = strType.toString();
		
		members.put(memberName,memberType);
		
	}
	
	//解析bean标签内容
	private static void parseBean(Element eleBean,StringBuffer path,List<XMLBean> beanList){	
		
		String strBeanName = eleBean.attributeValue("name").replaceAll("\\s*", "");
		
		if(isNull(strBeanName,"Can't find bean's name")) return;

		XMLBean xb = new XMLBean();
		xb.setBeanName(strBeanName);
		xb.setPath(path.toString());		

		List<Element> variableList = eleBean.elements("variable");
		
		if(isNull(variableList,"Can't find variables")) return;
		
		Map<String,String> members = xb.getMembers();
			
		for(Element eleVariable : variableList){
			
			parseVariable(eleVariable,members);
		}
		
		beanList.add(xb);

	}
	
	//解析标签
	private static void parseElement(Element element,StringBuffer path,List<XMLBean> beanList){
		
		List<Element> subElements = element.elements();
		if(isNull(subElements,"Can't find subElements")) return;

		for(Element e : subElements){
			
			StringBuffer newPath = new StringBuffer(path);

			if(e.getName().equals("bean")){
				
				parseBean(e,newPath,beanList);
				
			} else {
				
				String strElementName = e.attributeValue("name");
				
				newPath.append(".").append(strElementName);
				
				parseElement(e,newPath,beanList);
				
			}

		}

	}
	
}
