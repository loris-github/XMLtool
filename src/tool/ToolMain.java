package tool;

import java.util.List;

public class ToolMain {
	
	public static void main(String[] args) {
		
		String strXMLPath = "gnet.gsd(1).xml";
		
		System.gc();

		long start = System.currentTimeMillis();
		
		processWithXFReader (strXMLPath,"src");
		
		long end = System.currentTimeMillis();
		
		System.out.println("费时:" + (end - start));
        
    }
	
	public static void  processWithXFReader (String XMLPath,String beanFilesFloder) {
	
		List<XMLBean> beanList = XFReader.parseXMLFile (XMLPath);
		
		System.out.println("解析完毕");
		
		JFCreater.creatJavaFiles(beanList,beanFilesFloder);

	}
	
}
