package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import contentGenerator.GenClassDeclaration;
import contentGenerator.GenGetersAndSeters;
import contentGenerator.ContentGenerator;
import contentGenerator.GenImport;
import contentGenerator.GenPackage;
import contentGenerator.GenPrivateProperty;

public class JFCreater implements ContentGenerator{

	private String path ;
	private Map<String,String> members;
	private String beanName ;

	public String getPath() {
		return path;
	}

	public Map<String, String> getMembers() {
		return members;
	}

	public String getBeanName() {
		return beanName;
	}

	JFCreater (XMLBean xb){
		
		this.path = xb.getPath();
		this.members = xb.getMembers();
		this.beanName = xb.getBeanName();
		
	}
	
	public void generateContent(StringBuffer fileContent, JFCreater JFC) {
		
		ContentGenerator[] sg = { 	
									new GenPackage(),
									new GenImport(),
									new GenClassDeclaration(), 
									new GenPrivateProperty(), 
									new GenGetersAndSeters() } ;
		
		for(int i = 0;i<sg.length;i++){
			
			sg[i].generateContent(fileContent, JFC);
			fileContent.append(ENTER).append(ENTER);	
			
		}
		
		fileContent.append("}");

	}
	
	public static void creatJavaFiles(List<XMLBean> beanList, String beanFilesFloder){
		
		if (null != beanList){
			for(XMLBean xb : beanList){
				
				//把单个bean的主要内容存在jfc里边
				JFCreater jfc = new JFCreater(xb);
				
				StringBuffer fileContent = new StringBuffer();

				jfc.generateContent(fileContent,jfc);
				
				//写入文件
				writeToFile(beanFilesFloder,fileContent,jfc);
				
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
	
	private static void writeToFile (String beanFilesFloder, StringBuffer fileContent, JFCreater JFC){
		
		String path = JFC.getPath();
		String beanName = JFC.getBeanName();
		
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
