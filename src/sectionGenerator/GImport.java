package sectionGenerator;

import java.util.HashSet;
import java.util.Set;

import contentGenerator.ContentKit;
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
	protected final StringBuilder genMidPart(){
		
		StringBuilder midPart = new StringBuilder(nothing);

		for(String memberType: memberTypes){
			
			String strType = ContentKit.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = Util.getStrategyID (strType,typeSortStrategy);

			genByTypes(strategyID);

		}

		return midPart;
	}
	
	protected final void genByTypes(int strategyID){
	
		//语句中间部分
		switch(strategyID){

		case 0 :
			strImports.add(new StringBuilder(StrImportCollection).append(MAP).append(SEMI).toString());
			strImports.add(new StringBuilder(StrImportCollection).append(HASHMAP).append(SEMI).toString());
			break;

		case 1 :
			strImports.add(new StringBuilder(StrImportCollection).append(LIST).append(SEMI).toString());
			strImports.add(new StringBuilder(StrImportCollection).append(ARRAYLIST).append(SEMI).toString());
			break;

		case 2 :
			strImports.add(new StringBuilder(StrImportCollection).append(SET).append(SEMI).toString());
			strImports.add(new StringBuilder(StrImportCollection).append(HASHSET).append(SEMI).toString());
			break;

		case 3 :
			strImports.add(new StringBuilder(StrImportCollection).append(MAP).append(SEMI).toString());		
			break;

		case 4 :
			strImports.add(new StringBuilder(StrImportCollection).append(LIST).append(SEMI).toString());
			break;

		case 5 :
			strImports.add(new StringBuilder(StrImportCollection).append(SET).append(SEMI).toString());
			break;
			
		case 6 :
			strImports.add(new StringBuilder(StrImportCollection).append(HASHMAP).append(SEMI).toString());	
			break;
			
		case 7 :
			strImports.add(new StringBuilder(StrImportCollection).append(ARRAYLIST).append(SEMI).toString());
			break;
			
		case 8 :
			strImports.add(new StringBuilder(StrImportCollection).append(HASHSET).append(SEMI).toString());	
			break;
			
		case -1 :
			break;
		}			
	}
	
	//方法下半部分
	@Override
	protected StringBuilder genLowerPart(){
		
		if(strImports.size()>0) {
			
			for(String strImport : strImports) Util.joint(content, strImport,ENTER);

		}
		
		Util.joint(content, ENTER);
		return nothing;
	}
}
