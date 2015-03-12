package sectionGenerator.generatorInterface;

import tool.XMLBean;

public class MethodSection extends Section {
	
	protected MethodSection(XMLBean xb) {
		super(xb);
	}

	@Override
	protected void appendToContent(StringBuilder content) {
		
		joint(content,
				gentMethodTilte(),
				genUpperPart(),
				genMidPart(),
				genLowerPart(),
				TAB,LB,ENTER);
	}
	
	//生成方法标题部分 + 左大括号
	protected StringBuilder gentMethodTilte(){
		return nothing;
	}
	
	//生成方法内容的上半部分
	protected StringBuilder genUpperPart(){
		return nothing;
	}
	
	//生成方法内容的中间部分
	protected StringBuilder genMidPart(){
		return nothing;
	}	
	
	//生成方法内容的下半部分
	protected StringBuilder genLowerPart(){
		return nothing;
	}

}
