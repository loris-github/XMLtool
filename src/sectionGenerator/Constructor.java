package sectionGenerator;

import sectionGenerator.generatorInterface.Section;
import tool.XMLBean;

public class Constructor extends Section {
	
	StringBuilder methodTitle;
	StringBuilder upperPart;
	StringBuilder middlePart;
	StringBuilder lowerPart;
	
	Constructor(XMLBean xb) {
		super(xb);
	}
	
	private static StringBuilder getBlock(){
		StringBuilder block = new StringBuilder();

		return block;		
	}
	
	
	private void genMiddlePart(int Result){
		
		//获取类型字符串
		
		//根据判断结果生成处理
		switch(Result){
		
		case 1 :
			break;
			
		case 2 :
			break;
			
		case 3 :
			break;
		
		}
	}
	
	private void genForString(String memberName,String memberType){
		
		joint (content,
				TAB,TAB,
				THIS,DOT,memberName,SPACE,EQUAL,SPACE,QUOTE,QUOTE,
				ENTER);
	}
	
	@Override
	protected void appendToContent(StringBuilder content) {
		
		//生成方法的title
		
		//生成方法内容
		
		//添加代码块

	}

}
