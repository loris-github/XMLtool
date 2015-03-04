package tool;

import java.util.List;

public class ToolMain {
	
	public static void main(String[] args) {
		
		String strXMLPath = "gnet.gsd(1).xml";

		processWithXFReader (strXMLPath,"src");
        
    }
	
	public static void  processWithXFReader (String XMLPath,String beanFilesFloder) {
	
		List<XMLBean> beanList = XFReader.parseXMLFile (XMLPath);
		
		System.out.println("解析完毕");
		
		JFCreater.creatJavaFiles(beanList,beanFilesFloder);

	}
	
}
