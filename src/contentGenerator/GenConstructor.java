package contentGenerator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import tool.JFCreater;
import tool.XMLBean;

public class GenConstructor implements ContentGenerator {
	
	

	@Override
	public void generateContent(StringBuffer fileContent, XMLBean xb) {
		
		String beanName = xb.getBeanName();
		
		
		
		
		fileContent.append(TAB)
	       .append(PUBLIC)
	       .append(SPACE)
	       .append(beanName)
	       .append(SPACE)
	       .append("()").append(" {").append(ENTER);
		
		fileContent.append(TAB).append("}")
	       .append(ENTER).append(ENTER);

	}

}


/*
Map<String,String> members = JFC.getMembers();
Set<String> types = new HashSet<String>();		
Set<String> keys = members.keySet();

for(String key: keys) types.add(members.get(key));		 

Set<String> strImports = new HashSet<String>();

for(String type: types) {
	
	if(type.contains("Map")){
		
		strImports.add("import java.util.Map;"+ENTER);
		
	} else if(type.contains("List")){
		
		strImports.add("import java.util.List;"+ENTER);
		
	}
}

if(strImports.size()>0) {		
	for(String strImport : strImports) fileContent.append(strImport);		
}
*/
