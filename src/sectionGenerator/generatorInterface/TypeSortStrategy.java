package sectionGenerator.generatorInterface;

public class TypeSortStrategy implements CharacterAndSymbol {
	
//生成策略列表
	private static final String[] basicTypes = { BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, BOOLEAN };
	
	private static final String[] collectionTypes = { MAP, LIST, SET, HASHMAP, ARRAYLIST, HASHSET };
	
	//GConstructor
	public static final String[][] TSS_Constructor = 	{
														basicTypes, 
														{ STRING },
														{ MAP },
														{ LIST },
														{ SET }
														};

	//GConstructorWithArgs
	public static final String[][] TSS_ConstructorWithArgs = 	{
																basicTypes,
																{ STRING },
																{ MAP, HASHMAP },
																{ LIST, ARRAYLIST },
																{ SET, HASHSET },
																}; 
	
	//GAssign
	public static final String[][] TSS_Assign  = 	{
													basicTypes,
													{ STRING },
													{}
													}; 	
	
	//GCompareTo
	public static final String[][] TSS_CompareTo  =	{
														{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
														{STRING},
														{}
														}; 
	//HashCode
	public static final String[][] TSS_ToString = 	{
													{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}
													}; 
	//GReset
	public static final String[][] TSS_Reset  =	{
													{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}
													}; 
	//GHashCode
	public static final String[][] TSS_HashCode = 	{
													{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}
													}; 
	
	//GEquals
	public static final String[][] TSS_Equals   =	{
													{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}
													}; 
	
	//GClone
	public static final String[][] TSS_Clone   =	{
													{BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN},
													{STRING},
													{}
													}; 

	//GClone
	public static final String[][] TSS_Import   =	{
													{ MAP },
													{ LIST },
													{ SET },
													{ MAPARRAY },
													{ LISTARRAY },
													{ SETARRAY },
													{ HASHMAP },
													{ ARRAYLIST },
													{ HASHSET },
													}; 
}
