package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JFCreater {
	
	private static final String PRIVATE = "private";
	private static final String PUBLIC = "public";
	private static final String SPACE = " ";
	private static final String ENTER = "\n";
	private static final String TAB = "\t";
	private static final String SEMICOLON = ";";

	public static void doXToJ(List<XMLBean> beanList, String beanFilesFloder){
		
		if (null != beanList){
			
			for(XMLBean xb : beanList){
				createBean(xb,beanFilesFloder);
			}		
			
			System.out.println("创建完毕");
			
		} else{
			
			try {
				
				throw new Exception("null beanList !");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

	}
	
	public static void createBean(XMLBean xb, String beanFilesFloder){
		
		StringBuffer fileContent = new StringBuffer();
	
		String path = xb.getPath();
		
		addPackage(fileContent,path);
		
		String beanName = xb.getBeanName();
		
		addClassDeclaration(fileContent,beanName);
	
		Map<String,String> members = xb.getMembers();		
		Set<String> keys = members.keySet();
		
		for(String memberName: keys) {			
			String memberType = members.get(memberName);			
			addPrivateProperty(fileContent,memberName,memberType);			
		}
		
		for(String memberName: keys) {			
			String memberType = members.get(memberName);			
			addSetsAndGets(fileContent,memberName,memberType);			
		}
		
		fileContent.append("}");
		
		writeToFile (path,beanName,fileContent,beanFilesFloder);
		
	}
	
	private static void addPackage(StringBuffer fileContent,String pack){
		fileContent.append("package ").append(pack)
	       .append(SEMICOLON).append(ENTER).append(ENTER);
	}
	
	private static void addClassDeclaration(StringBuffer fileContent,String beanName){
		
		String className = Character.toUpperCase(beanName.charAt(0))
			      + beanName.substring(1);
		
		fileContent.append("public class ")
	      .append(className)
	      .append(" implements java.io.Serializable ")// 实现序列化接口
	      .append("{")
	      .append(ENTER)
	      .append(ENTER)
	      .append(TAB)
	      .append("private static final long serialVersionUID = 1L;")
	      .append(ENTER)
	      .append(ENTER);// 生成序列号
		
	}
	
	private static void addPrivateProperty(StringBuffer fileContent,String memberName,String memberType){
		fileContent.append(TAB).append(PRIVATE)
	       .append(SPACE)
	       .append(memberType)
	       .append(SPACE)
	       .append(memberName)
	       .append(SEMICOLON).append(ENTER).append(ENTER);
	}
	
	private static void addSetsAndGets(StringBuffer fileContent,String memberName,String memberType){
		// create method get;
		fileContent.append(TAB)
	       .append(PUBLIC)
	       .append(SPACE)
	       .append(memberType)
	       .append(SPACE)
	       .append("get")
	       .append(Character.toUpperCase(memberName.charAt(0)))
	       .append(memberName.substring(1))
	       .append("()").append("{").append(ENTER)
	       .append(TAB).append(TAB)
	       .append("return this.")
	       .append(memberName)
	       .append(SEMICOLON).append(ENTER);
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);
		
	     // create method set;
		fileContent.append(TAB)
	       .append(PUBLIC)
	       .append(SPACE)
	       .append("void")
	       .append(SPACE)
	       .append("set")
	       .append(Character.toUpperCase(memberName.charAt(0)))
	       .append(memberName.substring(1))
	       .append("(").append(memberType)
	       .append(SPACE)
	       .append(memberName).append(")")
	       .append("{").append(ENTER)
	       .append(TAB).append(TAB)
	       .append("this.").append(memberName)
	       .append("=").append(memberName)
	       .append(SEMICOLON).append(ENTER);
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);

	}

	private static void writeToFile (String path, String beanName, StringBuffer fileContent, String beanFilesFloder){
		
		String dir = path.replace(".", File.separator);

		String javaFile = beanFilesFloder + File.separator + dir + File.separator + beanName +".java";

		System.out.println(javaFile);
		
		File file = new File (javaFile);
		
		file.getParentFile().mkdirs();
		
		try {
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter (fw);
			
			bw.write(fileContent.toString());
			bw.flush();
			bw.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
