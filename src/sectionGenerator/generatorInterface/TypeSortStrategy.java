package sectionGenerator.generatorInterface;

public class TypeSortStrategy implements CharacterAndSymbol {
	
//生成策略列表
	private static final String[] basicTypes = { _byte, _short, _int, _long, _float, _double, _char, _boolean };
	
	private static final String[] collectionTypes = { _Map, _List, _Set, _HashMap, _ArrayList, _HashSet };
	
	// GConstructor
	public static final String[][] TSS_Constructor = 	{
														basicTypes, 
														{ _String },
														{ _Map },
														{ _List },
														{ _Set }
														};

	// GConstructorWithArgs
	public static final String[][] TSS_ConstructorWithArgs = 	{
																basicTypes,
																{ _String },
																{ _Map, _HashMap },
																{ _List, _ArrayList },
																{ _Set, _HashSet },
																}; 
	
	// GAssign
	public static final String[][] TSS_Assign  = 	{
													basicTypes,
													{ _String },
													{ _Map, _HashMap },
													{ _List, _ArrayList, _Set, _HashSet },
													}; 	
	
	// GCompareTo
	public static final String[][] TSS_CompareTo  =	{
														{ _float },
														{ _double },
														{ _long },
														{ _byte, _short, _int, _char, _boolean },
														{ _Map, _HashMap, _List, _ArrayList, _Set, _HashSet },
														}; 
	// ToString
	public static final String[][] TSS_ToString = 	{
													collectionTypes,
													}; 
	// GReset
	public static final String[][] TSS_Reset  =	{
													{ _byte, _short, _int, _long, _float, _double, _char },
													{ _boolean },
													{ _String },
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
													{ _Map },
													{ _List },
													{ _Set },
													{ _MapARRAY },
													{ _ListARRAY },
													{ _SetARRAY },
													{ _HashMap },
													{ _ArrayList },
													{ _HashSet },
													}; 
}
