package sectionGenerator;

import sectionGenerator.generatorInterface.Section;

public class GImport extends Section {
	//生成方法声明部分 + 左大括号
	protected StringBuilder genDeclarePart(){
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
