package sectionGenerator;

import java.util.HashSet;
import java.util.Set;

import sectionGenerator.generatorInterface.Section;
import sectionGenerator.generatorInterface.TypeSortStrategy;
import sectionGenerator.generatorInterface.Util;

public class GImport extends Section {
	
	Set<String> memberTypes ;
	Set<String> strImports ;
	boolean addUtilFlag ;
	
	public GImport (){
		
		this.typeSortStrategy = TypeSortStrategy.TSS_Import;
		
		this.memberTypes = new HashSet<String>();
		
		this.strImports =  new HashSet<String>();
		
		this.addUtilFlag = false;
		
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
		
		for(String memberType: memberTypes){
			
			String strType = Util.getStrBeforeLeftAngleBracket(memberType);
			
			int strategyID = Util.getStrategyID (strType,typeSortStrategy);

			genByTypes(strategyID);

		}
		
		memberTypes.clear();
		
		return nothing;
	}
	
	protected final void genByTypes(int strategyID){
	
		//语句中间部分
		switch(strategyID){

		case 0 :
			strImports.add(new StringBuilder(StrImportCollection).append(_Map).append(SEMI).toString());
			strImports.add(new StringBuilder(StrImportCollection).append(_HashMap).append(SEMI).toString());
			addUtilFlag = true;			
			break;

		case 1 :
			strImports.add(new StringBuilder(StrImportCollection).append(_List).append(SEMI).toString());
			strImports.add(new StringBuilder(StrImportCollection).append(_ArrayList).append(SEMI).toString());
			addUtilFlag = true;
			break;

		case 2 :
			strImports.add(new StringBuilder(StrImportCollection).append(_Set).append(SEMI).toString());
			strImports.add(new StringBuilder(StrImportCollection).append(_HashSet).append(SEMI).toString());
			addUtilFlag = true;
			break;

		case 3 :
			strImports.add(new StringBuilder(StrImportCollection).append(_Map).append(SEMI).toString());	
			addUtilFlag = true;
			break;

		case 4 :
			strImports.add(new StringBuilder(StrImportCollection).append(_List).append(SEMI).toString());
			addUtilFlag = true;
			break;

		case 5 :
			strImports.add(new StringBuilder(StrImportCollection).append(_Set).append(SEMI).toString());
			addUtilFlag = true;
			break;
			
		case 6 :
			strImports.add(new StringBuilder(StrImportCollection).append(_HashMap).append(SEMI).toString());
			addUtilFlag = true;
			break;
			
		case 7 :
			strImports.add(new StringBuilder(StrImportCollection).append(_ArrayList).append(SEMI).toString());
			addUtilFlag = true;
			break;
			
		case 8 :
			strImports.add(new StringBuilder(StrImportCollection).append(_HashSet).append(SEMI).toString());	
			addUtilFlag = true;
			break;
			
		case -1 :
			break;
		}			
	}
	
	//方法下半部分
	@Override
	protected StringBuilder genLowerPart(){	
		
		StringBuilder lowerPart = new StringBuilder();
		
		if(!strImports.isEmpty()) {
			
			for(String strImport : strImports) Util.joint(lowerPart, strImport,ENTER);

		}
		
		strImports.clear();

		if(addUtilFlag) {
			
			Util.joint(lowerPart,_import,SPACE,P_Util,SEMI,ENTER);
			addUtilFlag = false;
		}

		Util.joint(lowerPart,_import,SPACE,P_Bean,SEMI,ENTER,ENTER);
		
		Util.joint(lowerPart,ENTER);
		
		return lowerPart;
	}
	
}
