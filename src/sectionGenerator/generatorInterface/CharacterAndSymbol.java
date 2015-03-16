package sectionGenerator.generatorInterface;

public interface CharacterAndSymbol {

	public static final StringBuilder nothing = new StringBuilder();
	
	public static final String PRIVATE = "private";
	public static final String PUBLIC = "public";
	public static final String NEW = "new";
	public static final String IF = "if";
	public static final String BYTE = "byte";
	public static final String SHORT = "short";
	public static final String INT = "int";
	public static final String LONG = "long";
	public static final String FLOAT = "float";
	public static final String DOUBLE = "double";
	public static final String CHAR = "char";	
	public static final String BOOLEAN = "boolean";
	public static final String STRING = "String";
	
	public static final String MAP = "Map";
	public static final String LIST = "List";
	public static final String SET = "Set";
	public static final String MAPARRAY = "Map[]";
	public static final String LISTARRAY = "List[]";
	public static final String SETARRAY = "Set[]";
	public static final String HASHMAP = "HashMap";
	public static final String ARRAYLIST = "ArrayList";
	public static final String HASHSET = "HashSet";
	
	public static final String PUTALL = "putAll";
	public static final String ADDALL = "addAll";
	public static final String COMPARE = "compare";
	public static final String COMPARETO = "compareTo";
	

	public static final String THIS = "this";
	public static final String NULL = "null";
	public static final String RETURN = "return";
	
	public static final String ASTERISK = "*"; // asterisk 
	public static final String COMMA = ","; // comma 
	public static final String SPACE = " ";
	public static final String ENTER = "\n";
	public static final String TAB = "\t";
	public static final String QUOTE = "\""; // quotation mark
	public static final String EXCLA = "!"; // exclamation mark
	public static final String DOT = ".";
	public static final String COLON = ":"; // colon
	public static final String SEMI = ";"; // semicolon
	public static final String EQUAL = "="; // equal sign
	public static final String QUSET = "?"; //question mark
	
	public static final String LRB = "("; // left round bracket
	public static final String RRB = ")"; // right round bracket
	public static final String RBS = ")"; // round brackets
	
	public static final String LSB = "["; // left square bracket
	public static final String RSB = "]"; // right square bracket
	
	public static final String LAB = "<"; // left angle bracket
	public static final String RAB = ">"; // right angle bracket

	public static final String LB = "{"; // left brace
	public static final String RB = "}"; // right brace
	public static final String BS = "{}"; // braces
	
	public static final StringBuilder StrImportCollection = Util.joint(new StringBuilder(), "import",SPACE,"java",DOT,"util",DOT);
}
