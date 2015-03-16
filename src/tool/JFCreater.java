package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import sectionGenerator.*;
import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.Sentence;
import contentGenerator.*;

public class JFCreater implements ContentGenerator{
	
	public static ContentGenerator[] sg = {
		new GenPackage(),
		new GenImport(),
		new GenClassDeclaration(), 
		new GenPrivateProperty(), 
		new GenGetersAndSeters(),
		new GenConstructor(),
		new GenConstructorWithParameters(),
		new GenClone(),
		new GenReset(),
		new GenHashCode(),
		new GenAssign(),
		new GenEquals(),
		new GenCompareTo(),
		new GenToString()
	};
	
	public static Sentence[] s = {
		new GPackage(),
		new GImport(),
		new GClassDeclaration(), 
		new GMembers(), 
		new GGetSet(),
		new GConstructor(),
		new GConstructorWithArgs(),
		new GClone(),
		new GReset(),
		new GHashCode(),
		new GAssign(),
		new GEquals(),
		new GCompareTo(),
		new GToString()
	};
	
	
	public void generateContent(StringBuilder fileContent,XMLBean xb) {
		
		for(int i = 0;i<s.length;i++){
			
			s[i].appendContent(fileContent, xb);				
		}
	}
	
	public void generateContent(StringBuffer fileContent,XMLBean xb) {

		for(int i = 0;i<sg.length;i++){
			
			sg[i].generateContent(fileContent, xb);				
		}
		
		fileContent.append("}");

	}
	
	public static void creatJavaFiles(List<XMLBean> beanList, String beanFilesFloder){
		
		if (null != beanList){
			for(XMLBean xb : beanList){
				
				//把单个bean的主要内容存在jfc里边
				JFCreater jfc = new JFCreater();
				
				StringBuffer fileContent = new StringBuffer();
				
				StringBuilder content = new StringBuilder();

				jfc.generateContent(content,xb);
				
				//写入文件
				jfc.writeToFile(beanFilesFloder,new StringBuffer(content),xb);
				
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
	
	private void writeToFile (String beanFilesFloder, StringBuffer fileContent, XMLBean xb){
		
		String path = xb.getPath();
		String beanName = xb.getBeanName();
		
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
