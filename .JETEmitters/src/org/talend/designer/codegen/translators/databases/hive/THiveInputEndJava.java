package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class THiveInputEndJava
{
  protected static String nl;
  public static synchronized THiveInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveInputEndJava result = new THiveInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_5 = " + \".\");" + NL + "\t";
  protected final String TEXT_6 = NL + "\t}" + NL + "}finally{" + NL + "\tstmt_";
  protected final String TEXT_7 = ".close();";
  protected final String TEXT_8 = NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Closing the connection to the database.\");" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\tconn_";
  protected final String TEXT_12 = ".close();" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Connection to the database closed.\");" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_NB_LINE\",nb_line_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tlog.info(\"";
  protected final String TEXT_20 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_21 = " +\".\");";
  protected final String TEXT_22 = NL + NL + "String currentClientPathSeparator_";
  protected final String TEXT_23 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_24 = "!=null) {" + NL + "\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_25 = ");" + NL + "\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String currentClientUsername_";
  protected final String TEXT_26 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "if(currentClientUsername_";
  protected final String TEXT_27 = "!=null) {" + NL + "\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_28 = ");" + NL + "\tglobalMap.put(\"current_client_user_name\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_29 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_30 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_31 = "!=null) {" + NL + "\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_32 = ");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_33 = "\", null);" + NL + "} else {" + NL + "\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
	if(!("true").equals(useExistingConn))
	{
		
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
