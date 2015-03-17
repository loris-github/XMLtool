package sectionGenerator.generatorInterface;

public class TypeSortStrategy implements CharacterAndSymbol {
	
//生成策略列表
	private static final String[] basicTypes = { BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, BOOLEAN };
	
	private static final String[] collectionTypes = { MAP, LIST, SET, HASHMAP, ARRAYLIST, HASHSET };
	
	// GConstructor
	public static final String[][] TSS_Constructor = 	{
														basicTypes, 
														{ STRING },
														{ MAP },
														{ LIST },
														{ SET }
														};

	// GConstructorWithArgs
	public static final String[][] TSS_ConstructorWithArgs = 	{
																basicTypes,
																{ STRING },
																{ MAP, HASHMAP },
																{ LIST, ARRAYLIST },
																{ SET, HASHSET },
																}; 
	
	// GAssign
	public static final String[][] TSS_Assign  = 	{
													basicTypes,
													{ STRING },
													{ MAP, HASHMAP },
													{ LIST, ARRAYLIST, SET, HASHSET },
													}; 	
	
	// GCompareTo
	public static final String[][] TSS_CompareTo  =	{
														{ FLOAT },
														{ DOUBLE },
														{ LONG },
														{ BYTE, SHORT, INT,CHAR, BOOLEAN },
														{ MAP, HASHMAP, LIST, ARRAYLIST, SET, HASHSET },
														}; 
	// ToString
	public static final String[][] TSS_ToString = 	{
													collectionTypes,
													}; 
	// GReset
	public static final String[][] TSS_Reset  =	{
													{ BYTE,SHORT,INT,LONG,FLOAT,DOUBLE,CHAR },
													{ BOOLEAN },
													{ STRING },
													collectionTypes
													}; 
	// GHashCode
	public static final String[][] TSS_HashCode = 	{
													basicTypes,
													}; 
	
	// GEquals
	public static final String[][] TSS_Equals   =	{
													basicTypes,
													}; 
	// GImport
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
