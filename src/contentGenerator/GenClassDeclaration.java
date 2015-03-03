package contentGenerator;

import tool.JFCreater;

public class GenClassDeclaration implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, JFCreater JFC) {
		
		String beanName = JFC.getBeanName();
		
		String className = Character.toUpperCase(beanName.charAt(0))
			      + beanName.substring(1);
		
		fileContent.append("public class ")
	      .append(className)
	      .append(" implements java.io.Serializable ")// 实现序列化接口
	      .append("{")
	      .append(ENTER)
	      .append(ENTER)
	      .append(TAB)
	      .append("private static final long serialVersionUID = 1L;");// 生成序列号

	}

}