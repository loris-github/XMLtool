package tool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import com.sun.tools.javac.Main;

public class CreaterOfJavaFile {
	
	private static String srcSaveDir;
	private static String classDir;
	
	private static final String PRIVATE = "private";
	private static final String PUBLIC = "public";
	private static final String SPACE = " ";
	private static final String ENTER = "\n";
	private static final String TAB = "\t";
	private static final String SEMICOLON = ";";
	
	private static List<String> javaFiles;
	
	public static void createBean(Connection conne) throws Exception{
		if (conne == null)
			   return;
			  DatabaseMetaData metaData = conne.getMetaData();
			  List<String> tables = getDbTables(metaData);
			  for (String table : tables) {
			   Statement state = conne.createStatement();
			   ResultSet rs = state.executeQuery("SELECT * FROM " + table);
			   ResultSetMetaData rsmd = rs.getMetaData();
			   int colsLength = rsmd.getColumnCount();
			   
			   List<String> memberTypes = new ArrayList<String>();
			   List<String> memberNames = new ArrayList<String>();
			   StringBuffer buffer = null;
			   for (int i = 1; i <= colsLength; i++) {
			    memberTypes.add(rsmd.getColumnClassName(i));
			    //java命名规范，属性首字母小写
			    memberNames.add(Character.toLowerCase(rsmd.getColumnName(i)
			      .charAt(0)) + rsmd.getColumnName(i).substring(1));
			    // 生成java文件
			    buffer = new StringBuffer();
			    // 声明包结构
			    File file = new File(srcSaveDir);
			    if (!file.exists()) {// 如果路径不存在，则创建一个路径
			     System.out.println(file.mkdirs() ? "文件路径不存在，创建成功!"
			       : "文件路径不存在!");
			    }
			    String pack = srcSaveDir.replace("/", ".");
			    
			    // 截取指定资源路径
			    pack = pack.substring(pack.indexOf("src") + 4);
			    if (pack == null || pack.length() < 1) {
			     System.out.println("无包结构!");
			    } else {
			     buffer.append("package ").append(pack)
			       .append(SEMICOLON).append(ENTER);
			    }
			    
			    // java命名规范，类首字母大小
			    table = Character.toUpperCase(table.charAt(0))
			      + table.substring(1);
			    
			    // 声明类
			    buffer.append("public class ")
			      .append(table)
			      .append(" implements java.io.Serializable ")// 实现序列化接口
			      .append("{")
			      .append(ENTER)
			      .append(TAB)
			      .append("private static final long serialVersionUID = 1L;")
			      .append(ENTER);// 生成序列号
			    
			    // 声明私有属性
			    for (int index = 0; index < memberTypes.size(); index++) {
			     buffer.append(TAB).append(PRIVATE)
			       .append(SPACE)
			       .append(memberTypes.get(index))
			       .append(SPACE)
			       .append(memberNames.get(index))
			       .append(SEMICOLON).append(ENTER);
			    }
			    
			    // 生成get/set方法
			    for (int index = 0; index < memberTypes.size(); index++) {
			     // create method get;
			     buffer.append(TAB)
			       .append(PUBLIC)
			       .append(SPACE)
			       .append(memberTypes.get(index))
			       .append(SPACE)
			       .append("get")
			       .append(Character.toUpperCase(memberNames
			         .get(index).charAt(0)))
			       .append(memberNames.get(index).substring(1))
			       .append("()").append("{").append(ENTER)
			       .append(TAB).append(TAB)
			       .append("return this.")
			       .append(memberNames.get(index))
			       .append(SEMICOLON).append(ENTER);
			     buffer.append(TAB).append("}")
			       .append(SEMICOLON).append(ENTER)
			       .append(ENTER);
			     // create method set;
			     buffer.append(TAB)
			       .append(PUBLIC)
			       .append(SPACE)
			       .append("void")
			       .append(SPACE)
			       .append("set")
			       .append(Character.toUpperCase(memberNames
			         .get(index).charAt(0)))
			       .append(memberNames.get(index).substring(1))
			       .append("(").append(memberTypes.get(index))
			       .append(SPACE)
			       .append(memberNames.get(index)).append(")")
			       .append("{").append(ENTER)
			       .append(TAB).append(TAB)
			       .append("this.").append(memberNames.get(index))
			       .append("=").append(memberNames.get(index))
			       .append(SEMICOLON).append(ENTER);
			     buffer.append(TAB).append("}")
			       .append(SEMICOLON).append(ENTER)
			       .append(ENTER);
			    }
			    buffer.append("}");
			   }
			   
			   String javaFileName = srcSaveDir + "/" + table + ".java";
			   javaFiles.add(javaFileName);
			   System.out.println("create file:" + javaFileName);
			   
			   //生成java文件
			   BufferedWriter writer = new BufferedWriter(new FileWriter(
			     javaFileName));
			   writer.write(buffer.toString());
			   writer.flush();
			   //关闭资源
			   writer.close();
			  }
			  //关闭数据库连接对象
			  conne.close();
	}
	
	
	
	/**
	  * 获取DB中表集合
	  * @param metaData
	  * @return ArrayList
	  * @throws SQLException
	  */
	 public static List<String> getDbTables(DatabaseMetaData metaData) throws SQLException {
	  ResultSet rs = metaData.getTables(null, null, "%",
	    new String[] { "TABLE" });// 取表
	  List<String> tables = new ArrayList<String>();
	  javaFiles = new ArrayList<String>();
	  while (rs.next()) {
	   tables.add(rs.getString(3));
	  }
	  return tables;
	 }
	 
	 
	 /**
	  * 编译指定目录下的java文件
	  * @param dir
	  */
	 public static void compiles(String dir){
	  
	 }
	 
	 
	 
	 /**
	  * 编译java文件
	  * 
	  * @param javaFiles
	  *            被编译的java文件
	  */
	 
	 
	 
	 
	 /**
	  * 编译刚刚生成的BEAN；如果IDE是设置为自动编译，则此过程可以不需要
	  */
	 
	 /*
	 public static void compiles() {
	  compile(javaFiles);
	 }
	 
	 public static void compiles(List<String> javaFiles) {
		  compile(javaFiles);
		 }
		 
	 
	 private static void compile(List<String> javaFiles){
	  if(classDir == null || "".equals(classDir.trim())){
	   throw new RuntimeException("未设置编译保存路径");
	  }
	  String[] arg = null;
	  for (String javaFile : javaFiles) {
	   arg = new String[] { "-d", classDir, javaFile };
	   int statues = Main.compile(arg);// 如果为0说明编译成功
	   System.out.println(statues == 0 ? "compile success:" + javaFile
	     : "compile unSuccess!");
	  }
	}
	*/
}
