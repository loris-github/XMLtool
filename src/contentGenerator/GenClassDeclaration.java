package contentGenerator;

import tool.XMLBean;

public class GenClassDeclaration implements ContentGenerator {

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		String beanName = xb.getBeanName();
		
		String className = Character.toUpperCase(beanName.charAt(0))
			      + beanName.substring(1);
		
		fileContent.append("public").append(SPACE).append("class").append(SPACE)
	      .append(className).append(SPACE).append("implements").append(SPACE)
	      .append("Comparable<").append(beanName).append(">,").append(SPACE)
	      .append("java.io.Serializable").append(SPACE).append("{") // 实现序列化接口
	      .append(ENTER)
	      .append(ENTER)
	      .append(TAB)
	      .append("private static final long serialVersionUID = 1L;")
	      .append(ENTER).append(ENTER);// 生成序列号

	}

}