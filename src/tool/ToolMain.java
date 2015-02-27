package tool;

import java.util.List;

public class ToolMain {
	
	public static void main(String[] args) {

		processWithXFReader ("gnet.gsd.xml","src");
        
    }
	
	public static void  processWithXFReader (String XMLPath,String beanFilesFloder) {
	
		List<XMLBean> beanList = XFReader.parseXMLFile (XMLPath);
		
		JFCreater.doXToJ(beanList,beanFilesFloder);

	}
	
	public static void  processWithXFReader2 (String XMLPath,String beanFilesFloder) {
		
		List<XMLBean> beanList = XFReader.parseXMLFile (XMLPath);
		
		JFCreater.doXToJ(beanList,beanFilesFloder);

	}
	
	
}
