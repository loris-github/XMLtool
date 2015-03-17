package sectionGenerator.generatorInterface;

public interface CharacterAndSymbol {
	
	public static final String _0 = "0";
	public static final String _1 = "1";
	public static final String _1L = "1L";
	public static final String _31 = "31";
	
	public static final String _a = "a";
	public static final String _c = "c";
	public static final String _e = "e";
	public static final String _h = "h";
	public static final String _s = "s";
	public static final String _i = "i";
	public static final String _o = "o";
	public static final String _serialVersionUID = "serialVersionUID";

	public static final String _package = "package";
	public static final String _import = "import";
	
	public static final String _util = "java.util.";
	public static final String _Util = "sectionGenerator.generatorInterface.Util";
	public static final String _Comparable = "Comparable";
	public static final String _Cloneable = "Cloneable";
	public static final String _Serializable = "java.io.Serializable";
	
	
	public static final String _class = "class";
	public static final String _implements = "implements";
	public static final String _static = "static";
	public static final String _final = "final";
	public static final String _private = "private";
	public static final String _public = "public";
	public static final String _void = "void";

	public static final String _byte = "byte";
	public static final String _short = "short";
	public static final String _int = "int";
	public static final String _long = "long";
	public static final String _float = "float";
	public static final String _double = "double";
	public static final String _char = "char";	
	public static final String _boolean = "boolean";
	
	public static final String _String = "String";
	public static final String _Float = "Float";
	public static final String _Long = "Long";
	public static final String _Double = "Double";
	public static final String _Object = "Object";
	
	public static final String _Map = "Map";
	public static final String _List = "List";
	public static final String _Set = "Set";
	public static final String _MapARRAY = "Map[]";
	public static final String _ListARRAY = "List[]";
	public static final String _SetARRAY = "Set[]";
	public static final String _HashMap = "HashMap";
	public static final String _ArrayList = "ArrayList";
	public static final String _HashSet = "HashSet";
	public static final String _StringBuilder = "StringBuilder";
	
	public static final String _get = "get";
	public static final String _set = "set";
	public static final String _equals = "equals";
	public static final String _hashCode = "hashCode";
	public static final String _append = "append";
	public static final String _toString = "toString";
	public static final String _clear = "clear";
	public static final String _clone = "clone";
	public static final String _reset = "reset";
	public static final String _assign = "assign";
	public static final String _putAll = "putAll";
	public static final String _addAll = "addAll";
	public static final String _compare = "compare";
	public static final String _compareTo = "compareTo";
	public static final String _signum = "signum";
	
	public static final String _new = "new";
	public static final String _if = "if";
	public static final String _this = "this";
	public static final String _null = "null";
	public static final String _return = "return";
	public static final String _false = "false";
	public static final String _true = "true";
	public static final String _instanceof = "instanceof";
	
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
	public static final String MINUS = "-"; // minus
	public static final String PLUS = "+"; // plus
	
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
	
	public static final StringBuilder nothing = new StringBuilder();
	public static final StringBuilder StrImportCollection = Util.joint(new StringBuilder(), _import,SPACE,_util);
}
