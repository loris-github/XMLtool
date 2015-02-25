package tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataOfTool {
	public String topPackageName;
	public List<BeanStruct> beanList = new ArrayList<BeanStruct>();
	public Map<String,List<BeanStruct>> subPackage = new HashMap<String,List<BeanStruct>>();
}
