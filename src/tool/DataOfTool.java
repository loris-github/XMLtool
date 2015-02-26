package tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataOfTool {
	public String topPackageName;
	public List<XMLBean> beanList = new ArrayList<XMLBean>();
	public Map<String,List<XMLBean>> subpackages = new HashMap<String,List<XMLBean>>();
}
