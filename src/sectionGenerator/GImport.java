package sectionGenerator;

import java.util.HashSet;
import java.util.Set;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GImport extends Section {
	
	Set<String> memberTypes ;
	Set<String> strImports ;
	
	public GImport (){	
		
		this.typeSortStrategy = TypeSortStrategy.TSS_Import;
		
		this.memberTypes = new HashSet<String>();
		
		this.strImports =  new HashSet<String>();		
	}
	
	//初始化memberTypes
	@Override
	protected final StringBuilder genUpperPart(){
		
		for(String memberName: memberNames) memberTypes.add(members.get(memberName));
		
		return nothing;
	}	
	
	//方法中间部分
	@Override
	protected final void genByMembers(StringBuilder midPart, int strategyID, String memberName,String memberType){
	
		//语句中间部分
		switch(strategyID){

		case 0 :
			Util.joint(midPart,StrImportCollection,"Map",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;
			Util.joint(midPart,StrImportCollection,"HashMap",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;
			break;

		case 1 :
			Util.joint(midPart,StrImportCollection,"List",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;
			Util.joint(midPart,StrImportCollection,"ArrayList",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;
			break;

		case 2 :
			Util.joint(midPart,StrImportCollection,"Set",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;
			Util.joint(midPart,StrImportCollection,"HashSet",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;
			break;

		case 3 :
			Util.joint(midPart,StrImportCollection,"Map",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;			
			break;

		case 4 :
			Util.joint(midPart,StrImportCollection,"List",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;	
			break;

		case 5 :
			Util.joint(midPart,StrImportCollection,"Set",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;	
			break;
			
		case 6 :
			Util.joint(midPart,StrImportCollection,"HashMap",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;	
			break;
			
		case 7 :
			Util.joint(midPart,StrImportCollection,"ArrayList",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;	
			break;
			
		case 8 :
			Util.joint(midPart,StrImportCollection,"HashSet",SEMI);
			strImports.add(midPart.toString());
			midPart = nothing;	
			break;
			
		case -1 :
			break;
		}			
	}
	
	//方法下半部分
	@Override
	protected StringBuilder genLowerPart(){
		
		if(strImports.size()>0) {
			
			for(String strImport : strImports) Util.joint(content, strImport);

		}
		
		return nothing;
	}
}
