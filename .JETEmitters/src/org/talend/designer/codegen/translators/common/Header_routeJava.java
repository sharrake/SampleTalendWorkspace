package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;
import org.talend.designer.codegen.config.CamelEndpointBuilder;
import org.talend.designer.codegen.config.CamelEndpointBuilder.BuildingValueParamAppender;
import org.talend.designer.codegen.config.CamelEndpointBuilder.ConditionParamAppender;
import org.talend.designer.codegen.config.CamelEndpointBuilder.NodeParamNotDefaultAppender;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.core.model.process.EParameterFieldType;

public class Header_routeJava {

  protected static String nl;
  public static synchronized Header_routeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_routeJava result = new Header_routeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = " ;";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_7 = " Purpose: ";
  protected final String TEXT_8 = "<br>" + NL + " * Description: ";
  protected final String TEXT_9 = " <br>" + NL + " * @author ";
  protected final String TEXT_10 = NL + " * @version ";
  protected final String TEXT_11 = NL + " * @status ";
  protected final String TEXT_12 = NL + " */" + NL + "public class ";
  protected final String TEXT_13 = " extends org.apache.camel.builder.RouteBuilder implements TalendESBRoute {" + NL;
  protected final String TEXT_14 = NL + "\tprivate org.osgi.framework.BundleContext bundleContext;" + NL + "" + NL + "\tpublic void setBundleContext(org.osgi.framework.BundleContext bundleContext) {" + NL + "\t\tthis.bundleContext = bundleContext;" + NL + "\t}";
  protected final String TEXT_15 = NL + "    private final CorrelationIDCallbackHandler correlationIDCallbackHandler_";
  protected final String TEXT_16 = " = new CorrelationIDCallbackHandler();";
  protected final String TEXT_17 = NL + "    public interface Service_";
  protected final String TEXT_18 = " {";
  protected final String TEXT_19 = NL + "        @javax.ws.rs.Path(";
  protected final String TEXT_20 = ")" + NL + "        @javax.ws.rs.";
  protected final String TEXT_21 = "()";
  protected final String TEXT_22 = NL + "        @javax.ws.rs.Consumes(";
  protected final String TEXT_23 = ")";
  protected final String TEXT_24 = NL + "        @javax.ws.rs.Produces(";
  protected final String TEXT_25 = ")";
  protected final String TEXT_26 = NL + "        Object ";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = NL + "                @javax.ws.rs.PathParam(\"";
  protected final String TEXT_30 = "\") String ";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = NL + "                ";
  protected final String TEXT_33 = " payload";
  protected final String TEXT_34 = NL + "        );";
  protected final String TEXT_35 = NL + "    }" + NL;
  protected final String TEXT_36 = NL + "    private final CorrelationIDCallbackHandler correlationIDCallbackHandler_";
  protected final String TEXT_37 = " = new CorrelationIDCallbackHandler();";
  protected final String TEXT_38 = NL + "    //ESB Service Activity Monitor Feature" + NL + "    private org.apache.cxf.feature.Feature eventFeature;" + NL + "" + NL + "    public void setEventFeature(org.apache.cxf.feature.Feature eventFeature) {" + NL + "        this.eventFeature = eventFeature;" + NL + "    }" + NL;
  protected final String TEXT_39 = NL + "    static class CorrelationIDCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "        private String correlationId;" + NL + "        public void setCorrelationId(String correlationId) {" + NL + "            this.correlationId = correlationId;" + NL + "        }" + NL + "        public String getCorrelationId() {" + NL + "            return correlationId;" + NL + "        }" + NL + "    }";
  protected final String TEXT_40 = NL + "\tpublic String getCXFRSEndpointAddress(String endpointUrl) {" + NL + "\t\tif(bundleContext != null) {" + NL + "\t\t\tif (endpointUrl != null && !endpointUrl.trim().isEmpty() && !endpointUrl.contains(\"://\")) {" + NL + "\t\t\t\tif (endpointUrl.startsWith(\"/services\")) {" + NL + "\t\t\t\t\tendpointUrl = endpointUrl.substring(\"/services\".length());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (!endpointUrl.startsWith(\"/\")) {" + NL + "\t\t\t\t\tendpointUrl = '/' + endpointUrl;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn endpointUrl;" + NL + "\t\t}" + NL + "\t\tString defaultEndpointUrl = \"";
  protected final String TEXT_41 = "\";" + NL + "\t\tif (null == endpointUrl || endpointUrl.trim().isEmpty()) {" + NL + "\t\t\t\tendpointUrl = defaultEndpointUrl;" + NL + "\t\t} else if (!endpointUrl.contains(\"://\")) { // relative" + NL + "\t\t\tif (endpointUrl.startsWith(\"/\")) {" + NL + "\t\t\t\tendpointUrl = endpointUrl.substring(1);" + NL + "\t\t\t}" + NL + "\t\t\tendpointUrl = defaultEndpointUrl + endpointUrl;" + NL + "\t\t}" + NL + "\t\treturn endpointUrl;" + NL + "\t}" + NL + "" + NL + "static class CxfPayloadProvider implements javax.ws.rs.ext.MessageBodyWriter<org.apache.camel.component.cxf.CxfPayload<javax.xml.transform.Source>> {" + NL + "    public boolean isWriteable(Class<?> cls, java.lang.reflect.Type type, java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt) {" + NL + "        return cls == org.apache.camel.component.cxf.CxfPayload.class;" + NL + "    }" + NL + "    public long getSize(org.apache.camel.component.cxf.CxfPayload<javax.xml.transform.Source> obj, Class<?> cls, java.lang.reflect.Type type," + NL + "            java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt) {" + NL + "        return -1;" + NL + "    }" + NL + "    public void writeTo(org.apache.camel.component.cxf.CxfPayload<javax.xml.transform.Source> obj, Class<?> cls, java.lang.reflect.Type type," + NL + "            java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt," + NL + "            javax.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)" + NL + "            throws java.io.IOException, javax.ws.rs.WebApplicationException {" + NL + "        java.util.List<javax.xml.transform.Source> bodySource = obj.getBodySources();" + NL + "        if (bodySource == null || bodySource.size() != 1) {" + NL + "            throw new javax.ws.rs.InternalServerErrorException();" + NL + "        }" + NL + "        try {" + NL + "            org.apache.cxf.staxutils.StaxUtils.copy(bodySource.get(0), os);" + NL + "        } catch (javax.xml.stream.XMLStreamException ex) {" + NL + "            throw new javax.ws.rs.InternalServerErrorException(ex);" + NL + "        }" + NL + "        " + NL + "    }" + NL + "}";
  protected final String TEXT_42 = NL + NL + "\tprivate Map<String, String> uriMap;" + NL + "" + NL + "\tpublic Map<String,String> getUriMap() {" + NL + "\t\treturn this.uriMap;" + NL + "\t}" + NL + "" + NL + "\tpublic void loadCustomUriMap(Map<String,String> newMap) {" + NL + "\t\tif(newMap == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tfor(Map.Entry<String, String> entry: newMap.entrySet()) {" + NL + "\t\t\turiMap.put(entry.getKey(), entry.getValue());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/*" + NL + "\t* the readContextValues(contextName) may have to invoked first before this" + NL + "\t*/" + NL + "\tpublic void initUriMap() {" + NL + "\t\turiMap = new HashMap<String, String>();" + NL;
  protected final String TEXT_43 = NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\turiMap.put(\"";
  protected final String TEXT_45 = "\", ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t}";
  protected final String TEXT_48 = NL + "\t}";
  protected final String TEXT_49 = NL;

    private static String getValue(INode node, String __ID__) {
        return ElementParameterParser.getValue(node, __ID__);
    }

    private static boolean getBoolValue(INode node, String __ID__) {
        return Boolean.parseBoolean(getValue(node,__ID__));
    }

    private static <T> T getObjectValue(INode node,String __ID__) {
        return (T) ElementParameterParser.getObjectValue(node, __ID__);
    }

    private static void appendParamWhenNotDefaultNorEmpty(StringBuilder sb, String param, String paramV, String defaultV) {
        if (paramV != null && !paramV.trim().equals("") && !defaultV.equals(paramV)) {
            //the first '&' should replace to '?' later.
            sb.append("+\"&").append(param).append("=\"+").append(paramV);
        }
    }

    private static void appendParamWhenNotDefault(StringBuilder sb, String param, boolean paramV, boolean defaultV) {
        if (paramV != defaultV) {
            sb.append("+\"&").append(param).append('=').append(paramV).append('"');
        }
    }

    private static void appendTableParams(StringBuilder sb, java.util.Collection<Map<String, String>> tableValues){
        for (Map<String, String> map : tableValues) {
            String argName = map.get("NAME").trim();
            String argValue = map.get("VALUE").trim();
            sb.append("+\"&\"+").append(argName).append("+\"=\"+").append(argValue);
        }
    }

    private static String getURI(StringBuilder sb) {
        return sb.toString().replaceFirst("&", "?");
    }

    // the generate method.
    public String generate(CodeGeneratorArgument argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess) v.get(0);
	String version = (String) v.get(1);

	boolean isStudioEEVersion = org.talend.core.PluginChecker.isTIS();
	
	List<? extends INode> processNodes = (List<? extends INode>) process.getGeneratingNodes();
	List<? extends INode> graphicalNodes = (List<? extends INode>) process.getGraphicalNodes();
	boolean stats = codeGenArgument.isStatistics();
	boolean trace = codeGenArgument.isTrace();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
	List<IContextParameter> params = new ArrayList<IContextParameter>();
	params=process.getContextManager().getDefaultContext().getContextParameterList();

    
IBrandingService service = (IBrandingService) GlobalServiceRegister.getDefault().getService(IBrandingService.class);
if (service instanceof AbstractBrandingService) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((AbstractBrandingService) service).getJobLicenseHeader(version));
    
}

	String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_3);
    
	java.util.Set<String> importsSet = new java.util.TreeSet<String>();
/*	for (String routine : CodeGeneratorRoutine.getRequiredRoutineName(process)) {
		if (!routine.equals(ITalendSynchronizer.TEMPLATE)) {
			importsSet.add("import routines."+routine);
		}
	}
*/
	importsSet.add("import java.util.HashMap");
	importsSet.add("import java.util.Map");
	importsSet.add("import javax.xml.bind.JAXBException");
	importsSet.add("import javax.xml.namespace.QName");
	importsSet.add("import routines.TalendString");
	importsSet.add("import routines.system.api.TalendESBRoute");
	importsSet.add("import routines.*");
	importsSet.add("import routines.system.*");
	importsSet.add("import java.text.ParseException");
	importsSet.add("import org.apache.camel.CamelContext");
	importsSet.add("import java.util.Properties");
	importsSet.add("import org.apache.camel.management.JmxNotificationEventNotifier");
	importsSet.add("import java.util.Set");
	
	String headerImports = ElementParameterParser.getValue(process, "__HEADER_IMPORT__");
	if(headerImports!=null && !"".equals(headerImports.trim())){
		String[] imports = headerImports.split(";");
		for(String s: imports){
			if(s!=null && !"".equals(s.trim())){
				importsSet.add(s.trim());
			}
		}
	}
	String footerImports = ElementParameterParser.getValue(process, "__FOOTER_IMPORT__");
	if(footerImports!=null && !"".equals(footerImports.trim())){
		String[] imports = footerImports.split(";");
		for(String s: imports){
			if(s!=null && !"".equals(s.trim())){
				importsSet.add(s.trim());
			}
		}
	}

	List<? extends INode> generatingNodes = process.getGeneratingNodes();
	for(INode n: generatingNodes){
		List<? extends IElementParameter> elementParameters = n.getElementParameters();
		for(IElementParameter p: elementParameters){
			if(p.getShowIf() != null && !p.isShow(elementParameters)){
				continue;
			}
			if(EParameterFieldType.MEMO_IMPORT == p.getFieldType()){
				Object value = p.getValue();
				if(value == null || !(value instanceof String) || "".equals(((String)value).trim())){
					continue;
				}
				String[] imports = ((String)value).trim().split(";");
				for(String s: imports){
					if(s!=null && !"".equals(s.trim())){
						importsSet.add(s.trim());
					}
				}
			}
		}
		
	}
	
	for(String s: importsSet){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(s);
    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(version );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_13);
    
	for (INode node : graphicalNodes) {
		Object value = node.getPropertyValue("STARTABLE");
		if (null != value && (Boolean) value) {

    stringBuffer.append(TEXT_14);
    
            break;
		}
	}

    boolean hasSam = false;
    boolean hasCorrelationID = false;
    boolean hasCXFRSProvider = false;
	for (INode node : graphicalNodes) {
		if ("cCXF".equals(node.getComponent().getName())) {
            boolean useRegistry = false;
            String dataFormat = ElementParameterParser.getValue(node, "__DATAFORMAT__");
            if (isStudioEEVersion && !"RAW".equals(dataFormat) && !"CXF_MESSAGE".equals(dataFormat)) {
                useRegistry = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_REGISTRY__"));
            }
		    if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SAM__"))
				&& !"RAW".equals(dataFormat) && !useRegistry) {
				hasSam = true;
            }
            if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__")) || useRegistry) {
                hasCorrelationID = true;
                String cid = node.getUniqueName();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
            } // CorrelationID
		} else if ("cCXFRS".equals(node.getComponent().getName())) {
            String cid = node.getUniqueName();
            if ("true".equals(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
                hasSam = true;
            }
            if (node.getIncomingConnections().isEmpty()) {
                hasCXFRSProvider = true;

                if ("MANUAL".equals(ElementParameterParser.getValue(node, "__SERVICE_TYPE__"))) {
final Map<String, String> contentTypes = new java.util.HashMap<String, String>() {{
        put("XML", "{ \"application/xml\", \"text/xml\" }");
        put("JSON", "{ \"application/json\" }");
        put("XML-JSON", "{ \"application/xml\", \"text/xml\", \"application/json\" }");
        put("FORM", "{ \"application/x-www-form-urlencoded\" }");
        put("MULTIPART", "{ \"multipart/form-data\", \"multipart/mixed\", \"multipart/related\" }");
        put("HTML", "{ \"text/html\" }");
        put("ANY", "{ \"*/*\" }");
    }};

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
     
                List<Map<String, String>> mappings = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
                for (Map<String, String> mapping : mappings) {
                    String outputConn = mapping.get("SCHEMA");

                    String httpVerb = mapping.get("HTTP_VERB");
                    String uriPattern = mapping.get("URI_PATTERN");
                    String consumes = mapping.get("CONSUMES");
                    String produces = mapping.get("PRODUCES");
                    String beanClass = mapping.get("BEAN");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(uriPattern);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(httpVerb);
    stringBuffer.append(TEXT_21);
    
            if (contentTypes.containsKey(consumes)) {
                String consumesContentTypes = contentTypes.get(consumes);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(consumesContentTypes);
    stringBuffer.append(TEXT_23);
    
            }

             //if (null != produces) {
            if (contentTypes.containsKey(produces)) {
                String producesContentTypes = contentTypes.get(produces);

    stringBuffer.append(TEXT_24);
    stringBuffer.append(producesContentTypes);
    stringBuffer.append(TEXT_25);
    
            }

    stringBuffer.append(TEXT_26);
    stringBuffer.append(outputConn);
    stringBuffer.append(TEXT_27);
    
    final class URITemplateUtils {

        public static final String TEMPLATE_PARAMETERS = "jaxrs.template.parameters";
        public static final String LIMITED_REGEX_SUFFIX = "(/.*)?";
        public static final String FINAL_MATCH_GROUP = "FINAL_MATCH_GROUP";
        private static final String DEFAULT_PATH_VARIABLE_REGEX = "([^/]+?)";
        private static final String CHARACTERS_TO_ESCAPE = ".*+";

        private final String template;
        private final List<String> variables = new ArrayList<String>();
        private final List<String> customVariables = new ArrayList<String>();
        private final Pattern templateRegexPattern;
        private final String literals;
        private final List<UriChunk> uriChunks;

        public URITemplateUtils(String theTemplate) {
            template = theTemplate;
            StringBuilder literalChars = new StringBuilder();
            StringBuilder patternBuilder = new StringBuilder();
            CurlyBraceTokenizer tok = new CurlyBraceTokenizer(template);
            uriChunks = new ArrayList<UriChunk>();
            while (tok.hasNext()) {
                String templatePart = tok.next();
                UriChunk chunk = createUriChunk(templatePart);
                uriChunks.add(chunk);
                if (chunk instanceof Literal) {
                    String encodedValue = encodePartiallyEncoded(chunk.getValue(), false);
                    String substr = escapeCharacters(encodedValue);
                    literalChars.append(substr);
                    patternBuilder.append(substr);
                } else if (chunk instanceof Variable) {
                    Variable var = (Variable)chunk;
                    variables.add(var.getName());
                    if (var.getPattern() != null) {
                        customVariables.add(var.getName());
                        patternBuilder.append('(');
                        patternBuilder.append(var.getPattern());
                        patternBuilder.append(')');
                    } else {
                        patternBuilder.append(DEFAULT_PATH_VARIABLE_REGEX);
                    }
                }
            }
            literals = literalChars.toString();

            int endPos = patternBuilder.length() - 1;
            boolean endsWithSlash = (endPos >= 0) ? patternBuilder.charAt(endPos) == '/' : false;
            if (endsWithSlash) {
                patternBuilder.deleteCharAt(endPos);
            }
            patternBuilder.append(LIMITED_REGEX_SUFFIX);

            templateRegexPattern = Pattern.compile(patternBuilder.toString());
        }



        public String getLiteralChars() {
            return literals;
        }

        public String getValue() {
            return template;
        }

        /**
         * List of all variables in order of appearance in template.
         *
         * @return unmodifiable list of variable names w/o patterns,
         * e.g. for "/foo/{v1:\\d}/{v2}" returned list is ["v1","v2"].
         */
        public List<String> getVariables() {
            return Collections.unmodifiableList(variables);
        }

        /**
         * List of variables with patterns (regexps). List is subset of elements from {@link #getVariables()}.
         *
         * @return unmodifiable list of variables names w/o patterns.
         */
        public List<String> getCustomVariables() {
            return Collections.unmodifiableList(customVariables);
        }

        private String escapeCharacters(String expression) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                sb.append(isReservedCharacter(ch) ? "\\" + ch : ch);
            }
            return sb.toString();
        }

        private boolean isReservedCharacter(char ch) {
            return CHARACTERS_TO_ESCAPE.indexOf(ch) != -1;
        }




        /**
         * Creates object form string.
         *
         * @param uriChunk stringified uri chunk
         * @return If param has variable form then {@link Variable} instance is created,
         * otherwise chunk is treated as {@link Literal}.
         */
        public UriChunk createUriChunk(String uriChunk) {
            if (uriChunk == null || "".equals(uriChunk)) {
                throw new IllegalArgumentException("uriChunk is empty");
            }
            UriChunk uriChunkRepresentation = new Variable().create(uriChunk);
            if (uriChunkRepresentation == null) {
                uriChunkRepresentation = new Literal().create(uriChunk);
            }
            return uriChunkRepresentation;
        }

        /**
         * Stringified part of URI. Chunk is not URI segment; chunk can span over multiple URI segments or one URI
         * segments can have multiple chunks. Chunk is used to decompose URI of {@link URITemplate} into literals
         * and variables. Example: "foo/bar/{baz}{blah}" is decomposed into chunks: "foo/bar", "{baz}" and
         * "{blah}".
         */
        abstract class UriChunk {

            public abstract String getValue();

            @Override
            public String toString() {
                return getValue();
            }
        }

        final class Literal extends UriChunk {
            private String value;

            private Literal() {
                // empty constructor
            }

            public Literal create(String uriChunk) {
                if (uriChunk == null || "".equals(uriChunk)) {
                    throw new IllegalArgumentException("uriChunk is empty");
                }
                Literal literal = new Literal();
                literal.value = uriChunk;
                return literal;
            }

            @Override
            public String getValue() {
                return value;
            }

        }

        /**
         * Variable of URITemplate. Variable has either "{varname:pattern}" syntax or "{varname}".
         */
        final class Variable extends UriChunk {
            private final Pattern VARIABLE_PATTERN =
                    Pattern.compile("(\\w[-\\w\\.]*[ ]*)(\\:(.+))?");
            private String name;
            private Pattern pattern;

            private Variable() {
                // empty constructor
            }

            /**
             * Creates variable from stringified part of URI.
             *
             * @param uriChunk uriChunk chunk that depicts variable
             * @return Variable if variable was successfully created; null if uriChunk was not a variable
             */
            public Variable create(String uriChunk) {
                Variable newVariable = new Variable();
                if (uriChunk == null || "".equals(uriChunk)) {
                    return null;
                }
                if (insideBraces(uriChunk)) {
                    uriChunk = stripBraces(uriChunk).trim();
                    Matcher matcher = VARIABLE_PATTERN.matcher(uriChunk);
                    if (matcher.matches()) {
                        newVariable.name = matcher.group(1).trim();
                        if (matcher.group(2) != null && matcher.group(3) != null) {
                            String patternExpression = matcher.group(3).trim();
                            newVariable.pattern = Pattern.compile(patternExpression);
                        }
                        return newVariable;
                    }
                }
                return null;
            }

            public String getName() {
                return name;
            }

            public String getPattern() {
                return pattern != null ? pattern.pattern() : null;
            }

            @Override
            public String getValue() {
                if (pattern != null) {
                    return "{" + name + ":" + pattern + "}";
                } else {
                    return "{" + name + "}";
                }
            }
        }

        /**
         * Splits string into parts inside and outside curly braces. Nested curly braces are ignored and treated
         * as part inside top-level curly braces. Example: string "foo{bar{baz}}blah" is split into three tokens,
         * "foo","{bar{baz}}" and "blah". When closed bracket is missing, whole unclosed part is returned as one
         * token, e.g.: "foo{bar" is split into "foo" and "{bar". When opening bracket is missing, closing
         * bracket is ignored and taken as part of current token e.g.: "foo{bar}baz}blah" is split into "foo",
         * "{bar}" and "baz}blah".
         * <p>
         * This is helper class for {@link URITemplate} that enables recurring literals appearing next to regular
         * expressions e.g. "/foo/{zipcode:[0-9]{5}}/". Nested expressions with closed sections, like open-closed
         * brackets causes expression to be out of regular grammar (is context-free grammar) which are not
         * supported by Java regexp version.
         */
        class CurlyBraceTokenizer {

            private List<String> tokens = new ArrayList<String>();
            private int tokenIdx;

            public CurlyBraceTokenizer(String string) {
                boolean outside = true;
                int level = 0;
                int lastIdx = 0;
                int idx;
                for (idx = 0; idx < string.length(); idx++) {
                    if (string.charAt(idx) == '{') {
                        if (outside) {
                            if (lastIdx < idx) {
                                tokens.add(string.substring(lastIdx, idx));
                            }
                            lastIdx = idx;
                            outside = false;
                        } else {
                            level++;
                        }
                    } else if (string.charAt(idx) == '}' && !outside) {
                        if (level > 0) {
                            level--;
                        } else {
                            if (lastIdx < idx) {
                                tokens.add(string.substring(lastIdx, idx + 1));
                            }
                            lastIdx = idx + 1;
                            outside = true;
                        }
                    }
                }
                if (lastIdx < idx) {
                    tokens.add(string.substring(lastIdx, idx));
                }
            }

            public boolean hasNext() {
                return tokens.size() > tokenIdx;
            }

            public String next() {
                if (hasNext()) {
                    return tokens.get(tokenIdx++);
                } else {
                    throw new IllegalStateException("no more elements");
                }
            }
        }

        /**
         * Token is enclosed by curly braces.
         *
         * @param token text to verify
         * @return true if enclosed, false otherwise.
         */
        public boolean insideBraces(String token) {
            return token.charAt(0) == '{' && token.charAt(token.length() - 1) == '}';
        }

        /**
         * Strips token from enclosed curly braces. If token is not enclosed method
         * has no side effect.
         *
         * @param token text to verify
         * @return text stripped from curly brace begin-end pair.
         */
        public String stripBraces(String token) {
            if (insideBraces(token)) {
                return token.substring(1, token.length() - 1);
            } else {
                return token;
            }
        }




        // HttpUtils()

        private final Pattern ENCODE_PATTERN =
                Pattern.compile("%[0-9a-fA-F][0-9a-fA-F]");

        // there are more of such characters, ex, '*' but '*' is not affected by UrlEncode
        private static final String PATH_RESERVED_CHARACTERS = "=@/:";
        private static final String QUERY_RESERVED_CHARACTERS = "?/";

        private String componentEncode(String reservedChars, String value) {

            StringBuilder buffer = new StringBuilder();
            StringBuilder bufferToEncode = new StringBuilder();

            for (int i = 0; i < value.length(); i++) {
                char currentChar = value.charAt(i);
                if (reservedChars.indexOf(currentChar) != -1) {
                    if (bufferToEncode.length() > 0) {
                        buffer.append(urlEncode(bufferToEncode.toString()));
                        bufferToEncode.setLength(0);
                    }
                    buffer.append(currentChar);
                } else {
                    bufferToEncode.append(currentChar);
                }
            }

            if (bufferToEncode.length() > 0) {
                buffer.append(urlEncode(bufferToEncode.toString()));
            }

            return buffer.toString();
        }

        public String queryEncode(String value) {

            return componentEncode(QUERY_RESERVED_CHARACTERS, value);
        }

        public String urlEncode(String value) {

            try {
                value = java.net.URLEncoder.encode(value, "UTF-8");
            } catch (java.io.UnsupportedEncodingException ex) {
                // unlikely to happen
            }

            return value;
        }

        public String pathEncode(String value) {

            String result = componentEncode(PATH_RESERVED_CHARACTERS, value);
            // URLEncoder will encode '+' to %2B but will turn ' ' into '+'
            // We need to retain '+' and encode ' ' as %20
            if (result.indexOf('+') != -1) {
                result = result.replace("+", "%20");
            }
            if (result.indexOf("%2B") != -1) {
                result = result.replace("%2B", "+");
            }

            return result;
        }

        public boolean isPartiallyEncoded(String value) {
            return ENCODE_PATTERN.matcher(value).find();
        }

        /**
         * Encodes partially encoded string. Encode all values but those matching pattern
         * "percent char followed by two hexadecimal digits".
         *
         * @param encoded fully or partially encoded string.
         * @return fully encoded string
         */
        public String encodePartiallyEncoded(String encoded, boolean query) {
            if (encoded.length() == 0) {
                return encoded;
            }
            Matcher m = ENCODE_PATTERN.matcher(encoded);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (m.find()) {
                String before = encoded.substring(i, m.start());
                sb.append(query ? queryEncode(before) : pathEncode(before));
                sb.append(m.group());
                i = m.end();
            }
            String tail = encoded.substring(i, encoded.length());
            sb.append(query ? queryEncode(tail) : pathEncode(tail));
            return sb.toString();
        }

    }

            boolean paramCommaWritten = false;

            URITemplateUtils uriTemplate = new URITemplateUtils(uriPattern);
            List<String> uriVariables = uriTemplate.getVariables();
            // we are going to declare all uri template variables ("Path" parameter type by REST)
            for (String uriVariable : uriVariables) {
                if (!paramCommaWritten) {
                    paramCommaWritten = true;
                } else {
                    
    stringBuffer.append(TEXT_28);
    
                }

    stringBuffer.append(TEXT_29);
    stringBuffer.append(uriVariable);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(uriVariable);
    
            }
            if (contentTypes.containsKey(consumes)) {
                if (!paramCommaWritten) {
                    paramCommaWritten = true;
                } else {
                    
    stringBuffer.append(TEXT_31);
    
                }
                String contentClass = null;
                 if ("XML".equals(consumes) || "JSON".equals(consumes) || "XML-JSON".equals(consumes))
                 {
                 	contentClass = beanClass == null || beanClass.isEmpty() ? "org.w3c.dom.Document" : beanClass;
                 }
                 else
                 {
                 	contentClass = "ANY".equals(consumes) ? "String" : "org.w3c.dom.Document";
                 }

    stringBuffer.append(TEXT_32);
    stringBuffer.append(contentClass);
    stringBuffer.append(TEXT_33);
    
            }

    stringBuffer.append(TEXT_34);
     
                } // mappings

    stringBuffer.append(TEXT_35);
    
                } // "MANUAL"
            } // service

            if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__"))) {
                hasCorrelationID = true;

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
            } // CorrelationID

		} // "cCXFRS"
	} // for

    if (hasSam) {

    stringBuffer.append(TEXT_38);
    
    }

    if (hasCorrelationID) {

    stringBuffer.append(TEXT_39);
    
    }

    if (hasCXFRSProvider) {
		String defaultUri = (String) System.getProperties().get("restServiceDefaultUri");
		if (null == defaultUri || defaultUri.trim().isEmpty() || !defaultUri.contains("://")) {
			defaultUri = "http://127.0.0.1:8090/";
		} else if (!defaultUri.endsWith("/")) {
			defaultUri = defaultUri + "/";
		}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(defaultUri);
    stringBuffer.append(TEXT_41);
    
    }


    stringBuffer.append(TEXT_42);
    
String cid = "";
String componentName = "";
String uri = "";
String statements = null;
for (INode node : graphicalNodes) {
	if(!node.isActivate()){
		continue;
	}
	NodeParamsHelper helper = new NodeParamsHelper(node);
   	cid = node.getUniqueName();
//  http://jira.talendforge.org/browse/TESB-5241
	/*
   	 * change to use label + unique to make it unique but readable
   	 */
//	IElementParameter param = node.getElementParameter("LABEL");
//	if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
//		cid = (String)param.getValue()+"_"+cid;	
//	}
   	
	componentName = node.getComponent().getName();
	uri = "";
	if ("cMessagingEndpoint".equals(componentName)) {
		uri = ElementParameterParser.getValue(node, "__URI__");
	}else if("cDirect".equals(componentName)){
		if(node.getIncomingConnections().size()>0){
			continue;//is productor node. use exist endpoint.
		}
		String directName=getValue(node, "__NAME__");
		uri="\"direct:\"+"+directName;
		StringBuilder sb=new StringBuilder();
		List<Map<String, String>> tableValues = getObjectValue(node, "__ADVARGUMENTS__");
		appendTableParams(sb,tableValues);
		if(sb.length()>0){
			sb.setCharAt(sb.indexOf("&"),'?');
			uri = uri + sb.toString();
		}
	}else if("cVM".equals(componentName)||"cSEDA".equals(componentName)){
		boolean inputName=getBoolValue(node, "____INPUT_ENDPOINT_NAME____");
		if(node.getIncomingConnections().size()>0 && (!inputName)){
			continue;//is productor node. and use exist endpoint.
		}
		String endpointName=getValue(node, "__NAME__");
		uri="\""
			+ ("cVM".equals(componentName) ? "vm":"seda" )
			+ ":\"+" + endpointName;
		if(!inputName){
			//consumer
			StringBuilder sb=new StringBuilder();
			boolean  specifySize=getBoolValue(node, "__SPECIFY_SIZE__");
			if(specifySize){
				String size=getValue(node, "__SIZE__");
				appendParamWhenNotDefaultNorEmpty(sb,"size",size,"0");
			}
			String concurCnsmrs=getValue(node, "__CONCURRENT_CONSUMERS__");
			appendParamWhenNotDefaultNorEmpty(sb,"concurrentConsumers",concurCnsmrs,"1");

			String waitForTaskToComplete=getValue(node, "__WAIT_FOR_TASK_TO_COMPLETE__");
			appendParamWhenNotDefaultNorEmpty(sb,"waitForTaskToComplete",waitForTaskToComplete,"\"IfReplyExpected\"");

			String timeout=getValue(node, "__TIMEOUT__");
			appendParamWhenNotDefaultNorEmpty(sb,"timeout",timeout,"30000");

			String multipleConsumers=getValue(node, "__MULTIPLE_CONSUMERS__");
			appendParamWhenNotDefaultNorEmpty(sb,"multipleConsumers",multipleConsumers,"false");

			String limitConcurrentConsumers=getValue(node, "__LIMIT_CONCURRENT_CONSUMERS__");
			appendParamWhenNotDefaultNorEmpty(sb,"limitConcurrentConsumers",limitConcurrentConsumers,"true");

			String blockWhenFull=getValue(node, "__BLOCK_WHEN_FULL__");
			appendParamWhenNotDefaultNorEmpty(sb,"blockWhenFull",blockWhenFull,"false");

			String pollTimeout=getValue(node, "__POLLTIMEOUT__");
			appendParamWhenNotDefaultNorEmpty(sb,"pollTimeout",pollTimeout,"1000");

			List<Map<String, String>> tableValues = getObjectValue(node, "__ADVARGUMENTS__");
			appendTableParams(sb,tableValues);
			
			if(sb.length()>0){
				sb.setCharAt(sb.indexOf("&"),'?');
				uri = uri + sb.toString();
			}
		}
	}else if("cDirectVM".equals(componentName)){
		boolean inputName= getBoolValue(node, "____INPUT_ENDPOINT_NAME____");
		boolean isProducer = node.getIncomingConnections().size()>0;
		
		INode consumerNode = node;
		if(isProducer && !inputName){
			String desNodeName= (String)getValue(node, "____ROUTE_COMPONENT_TYPE_ID____");
			if(desNodeName!=null){
				List<? extends INode> allNodes = node.getProcess().getGraphicalNodes();
				for(INode aNode : allNodes){
					if(aNode.getUniqueName().equals(desNodeName)){
						consumerNode=aNode;
						break;
					}
				}
			}
		}
		
		String endpointName=getValue(consumerNode, "__ENDPOINT_NAME__");
		
		uri="\"direct-vm:\"+" + endpointName;
		
		if(isProducer){
			boolean isBlock= getBoolValue(node, "____BLOCK____");
			if(isBlock){
				uri += "+\"?block=true&timeout="+getValue(consumerNode, "__TIMEOUT__")+"\"";
			}
		}
			
	}else if("cTimer".equals(componentName)){
		uri = "\"timer:\"+\""+node.getUniqueName()+"\"";
		StringBuilder sb = new StringBuilder();
		String period = ElementParameterParser.getValue(node, "__PERIOD__");
		if(period!=null && !period.trim().equals("") && !"1000".equals(period)){
			sb.append("+\"?period=\"+");
			sb.append(period);
		}
		String repeat = ElementParameterParser.getValue(node, "__REPEATCOUNT__");
		if(repeat!=null && !repeat.trim().equals("") && !"0".equals(repeat)){
			if(sb.length()==0){
				sb.append("+\"?repeatCount=\"+");
				sb.append(repeat);
			}else{
				sb.append("+\"&repeatCount=\"+");
				sb.append(repeat);
			}
		}
		String delay = ElementParameterParser.getValue(node, "__DELAY__");
		if(delay!=null && !delay.trim().equals("")){
			if(sb.length()==0){
				sb.append("+\"?delay=\"+");
				sb.append(delay);
			}else{
				sb.append("+\"&delay=\"+");
				sb.append(delay);
			}
		}
		String fixedRate = ElementParameterParser.getValue(node, "__FIXEDRATE__");
		if("true".equals(fixedRate)){
			if(sb.length()==0){
				sb.append("+\"?fixedRate=true\"");
			}else{
				sb.append("+\"&fixedRate=true\"");
			}
		}
		String daemon = ElementParameterParser.getValue(node, "__DAEMON__");
		if("false".equals(daemon)){
			if(sb.length()==0){
				sb.append("+\"?daemon=false\"");
			}else{
				sb.append("+\"&daemon=false\"");
			}
		}
		String setTime = ElementParameterParser.getValue(node, "__SET_TIME__");
		if("true".equals(setTime)){
			String time = ElementParameterParser.getValue(node, "__TIME__");
			if(sb.length()==0){
				sb.append("+\"?time=\"+");
				sb.append(time);
			}else{
				sb.append("+\"&time=\"+");
				sb.append(time);
			}
		}
		if(sb.length()>0){
			uri = uri + sb.toString();
		}
	}else if("cDataset".equals(componentName)){
		uri = "\"dataset:\"+"+ElementParameterParser.getValue(node, "__DATASET_NAME__");
		StringBuilder sb = new StringBuilder();
		String produceDelay = ElementParameterParser.getValue(node, "__PRODUCE_DELAY__");
		if(produceDelay!=null && !produceDelay.trim().equals("") && !"3".equals(produceDelay)){
			sb.append("+\"?produceDelay=\"+");
			sb.append(produceDelay);
		}
		String consumeDelay = ElementParameterParser.getValue(node, "__CONSUME_DELAY__");
		if(consumeDelay!=null && !consumeDelay.trim().equals("") && !"0".equals(consumeDelay)){
			if(sb.length()==0){
				sb.append("+\"?consumeDelay=\"+");
				sb.append(consumeDelay);
			}else{
				sb.append("+\"&consumeDelay=\"+");
				sb.append(consumeDelay);
			}
		}
		String preloadSize = ElementParameterParser.getValue(node, "__PRELOAD_SIZE__");
		if(preloadSize!=null && !preloadSize.trim().equals("") && !"0".equals(preloadSize)){
			if(sb.length()==0){
				sb.append("+\"?preloadSize=\"+");
				sb.append(preloadSize);
			}else{
				sb.append("+\"&preloadSize=\"+");
				sb.append(preloadSize);
			}
		}
		String initialDelay = ElementParameterParser.getValue(node, "__INITIAL_DELAY__");
		if(initialDelay!=null && !initialDelay.trim().equals("") && !"1000".equals(initialDelay)){
			if(sb.length()==0){
				sb.append("+\"?initialDelay=\"+");
				sb.append(initialDelay);
			}else{
				sb.append("+\"&initialDelay=\"+");
				sb.append(initialDelay);
			}
		}
		String minRate = ElementParameterParser.getValue(node, "__MIN_RATE__");
		if(minRate!=null && !minRate.trim().equals("") && !"0".equals(minRate)){
			if(sb.length()==0){
				sb.append("+\"?minRate=\"+");
				sb.append(minRate);
			}else{
				sb.append("+\"&minRate=\"+");
				sb.append(minRate);
			}
		}
		
		if(sb.length()>0){
			uri = uri + sb.toString();
		}
	} else if ("cFile".equals(componentName)) {
		String filePath = ElementParameterParser.getValue(node, "__URI__");
		String noop = ElementParameterParser.getValue(node, "__NOOP__");
		String flatten = ElementParameterParser.getValue(node, "__FLATTEN__");
		String bufferSize = ElementParameterParser.getValue(node, "__BUFFER_SIZE__");
		String autoCreate = ElementParameterParser.getValue(node, "__AUTOCREATE__");
		String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
		String charset = ElementParameterParser.getValue(node, "__ENCODING__");

		StringBuffer arguments = new StringBuffer();

		uri = "\"file://\"+" + filePath;

		if ("true".equals(noop)) {
			arguments.append("\"noop=true\"+");
		} else {
			arguments.append("\"noop=false\"+");
		}

		if ("false".equals(autoCreate)) {// default true, ignore.
			arguments.append("\"&autoCreate=false\"+");
		}

		if ("true".equals(flatten)) {// default false, ignore.
			arguments.append("\"&flatten=true\"+");
		}

		if (fileName != null && !fileName.equals("\"\"") && fileName.length() > 0 ) {
			arguments.append("\"&fileName=\"+").append(fileName).append("+");
		}

		if (charset != null  && !charset.equals("\"\"") && charset.length() > 0) {
			arguments.append("\"&charset=\"+").append(charset).append("+");
		}

		if (bufferSize != null && !bufferSize.equals("\"\"") && bufferSize.length() > 0) {
			arguments.append("\"&bufferSize=\"+").append(bufferSize).append("+");
		}

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME");
			String argValue = map.get("VALUE");
			arguments.append("\"&\"+").append(argName).append("+\"=\"+").append(argValue).append("+");
		}

		if (arguments.length() > 0) {
			arguments.deleteCharAt(arguments.length() - 1);
			uri = uri + "+\"?\"+" + arguments.toString();
		}
		System.out.println(uri);

	} else if ("cCXF".equals(componentName)) {
		
    
// included in header_route.javajet
// available variables :
// INode node;
// String cid;
// String componentName;
// NodeParamsHelper helper;
// return values:
// String uri = ""; generate the endpoint uri.
// String statements = null; generate the statements before wrapping endpoint uri.

String url = ElementParameterParser.getValue(node, "__ADDRESS__").trim();

String dataformat = ElementParameterParser.getValue(node, "__DATAFORMAT__");

boolean useServiceRegistry = helper.getVisibleBoolParam("__ENABLE_REGISTRY__");
if(!isStudioEEVersion || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
	useServiceRegistry = false;
}

boolean useSecurity = helper.getVisibleBoolParam("__ENABLE_SECURITY__");
if(useServiceRegistry || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
	useSecurity = false;
}

List<? extends IConnection> conns = node.getIncomingConnections();
if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SL__")) 
		&&  (!useServiceRegistry)) {
	if (!conns.isEmpty()) {
		// consumer role
		url = "((null == bundleContext) ? " + url + " : \"locator://locator/\")";
	}
}

String serviceType = ElementParameterParser.getValue(node, "__SERVICE_TYPE__");

StringBuilder sb = new StringBuilder();
sb.append("\"cxf://\"+").append(url);
sb.append("+\"?dataFormat=" + dataformat + "\"");

if ("true".equals(ElementParameterParser.getValue(node, "__LOG_MESSAGES__"))) {
	sb.append("+\"&loggingFeatureEnabled=true\"");
}

if ("wsdlURL".equals(serviceType)) {
	if(!useServiceRegistry){
		sb.append("+\"&" + serviceType + "=\"");
		//http://jira.talendforge.org/browse/TESB-6226
	    String filePath = "";
		
		String wsdlType = ElementParameterParser.getValue(node, "__WSDL_TYPE__");
		if("file".equals(wsdlType)){
		  filePath =  ElementParameterParser.getValue(node, "__WSDL_FILE__");
		}else{
			filePath =  ElementParameterParser.getValue(node, "__ROUTE_RESOURCE_TYPE_RES_URI__");
			filePath = "\"classpath:" + filePath + "\"";
		}
		filePath.replaceAll("\\\\","/");
		sb.append("+").append(filePath);
	} else {
		sb.append("+\"&wsdlURL=\"");
	}
} else {
	sb.append("+\"&" + serviceType + "=\"");
	sb.append("+" + ElementParameterParser.getValue(node, "__SERVICE_CLASS__"));
}




String serviceName = helper.getVisibleStringParam("__SERVICE_NAME__").trim();
if(!serviceName.isEmpty() && !serviceName.equals("\"\"")) {
	sb.append("+\"&serviceNameString=\"+").append(serviceName);
}
String portName = helper.getVisibleStringParam("__PORT_NAME__").trim();
if(!portName.isEmpty() && !portName.equals("\"\"")) {
	sb.append("+\"&endpointNameString=\"+").append(portName);
}
String operationName = helper.getVisibleStringParam("__OPERATION_NAME__").trim();
if(!operationName.isEmpty() && !operationName.equals("") && !operationName.equals("\"\"") ) {
	StringBuilder stmt = new StringBuilder();
	stmt.append("QName operation = null;\n");
	stmt.append("try { operation = QName.valueOf(")
		.append(operationName)
		.append(");}catch(Exception e){}\n");
	statements = stmt.toString();
	sb.append("+ (operation == null?\"\":(")
	.append("\"&defaultOperationNamespace=\"+operation.getNamespaceURI()")
	.append("+\"&defaultOperationName=\"+operation.getLocalPart()))");
}

List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
for (Map<String, String> map : tableValues) {
	String argName = map.get("NAME").trim();
	String argValue = map.get("VALUE").trim();
	sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
}

if(!conns.isEmpty()){
	sb.append("+\"&headerFilterStrategy=#CXF_PAYLOAD_HEADER_FILTER\"");
	sb.append("+\"&properties.id=\"+\"");
	sb.append(node.getUniqueName());
	sb.append("\"");
}else if(useServiceRegistry || (useSecurity && "SAML".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__")))) {
	sb.append("+\"&cxfBinding=#DEFAULT_CXF_BINDING\"");
}
uri = sb.toString();

    
    } else if ("cCXFRS".equals(componentName)) {
        StringBuilder sb = new StringBuilder("\"cxfrs://bean://" + node.getUniqueName() + '"');

        //sb.append(ElementParameterParser.getValue(node, "__URL__"));
        sb.append("+\"?loggingFeatureEnabled=").append(ElementParameterParser.getValue(node, "__LOG_MESSAGES__")).append('"');

        List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
        for (Map<String, String> map : tableValues) {
            String argName = map.get("NAME").trim();
            String argValue = map.get("VALUE").trim();
            sb.append("+\"&\"+" + argName + "+'='+" + argValue);
        }

        uri = sb.toString();
	} else if ("cFtp".equals(componentName)) {
		String type = ElementParameterParser.getValue(node, "__TYPE__");
		String username = ElementParameterParser.getValue(node, "__USERNAME__");
		String server = ElementParameterParser.getValue(node, "__SERVER__");
		String port = ElementParameterParser.getValue(node, "__PORT__");
		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
		String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");

		StringBuffer fragments = new StringBuffer();
		fragments.append("\"" + type + "://\"");
		fragments.append("+\"");
		fragments.append("ftpServer");
		fragments.append(".");
		fragments.append(cid);
		fragments.append("\"");

/*		if (username.trim().length() > 0) {
			fragments.append("+" + username.trim()).append("+\"@\"");
		}

		fragments.append("+" + server.trim());
*/
		if (port.trim().length() > 0) {
			fragments.append("+\":\"").append("+" + port.trim());
		}
/*
		if (directory.trim().length() > 0) {
			fragments.append("+\"/\"").append("+" + directory.trim());
		}
*/
		boolean hasArg = false;
/*		if (password.trim().length() > 0) {
			hasArg = true;
			fragments.append("+\"?password=\"+" + password);
		}
*/
		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			if (!hasArg) {
				fragments.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasArg = true;
			} else {
				fragments.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		}
		uri = fragments.toString();

	} else if("cJMS".equals(componentName)) {
		//http://jira.talendforge.org/browse/TESB-4861
		String name = ElementParameterParser.getValue(node, "__ROUTE_COMPONENT_TYPE_ID__");
		if (name == null || name.equals("")) {
			name = "jms";
		}
		name = name.replace("_", "");
		name = "\"" + name + "\"";
		//String name = ElementParameterParser.getValue(node, "__NAME__").trim();
		//Remove unnecessary subfix
		//name += "+";
		//name += ElementParameterParser.getValue(node, "__SUBFIX__").trim();
		String type = ElementParameterParser.getValue(node, "__TYPE__");
		String destination = ElementParameterParser.getValue(node, "__DESTINATION__").trim();

		boolean hasOptions = false;

		StringBuffer sb = new StringBuffer();
		sb.append(name).append("+\":" + type + ":\"").append("+" + destination);

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__URI_OPTIONS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();

			if (!hasOptions) {
				sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasOptions = true;
			} else {
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		}

		uri = sb.toString();
	} else if("cAMQP".equals(componentName)) {
		String name = ElementParameterParser.getValue(node, "__ROUTE_COMPONENT_TYPE_ID__");
		if (name == null || name.equals("")) {
			name = "amqp";
		}
		name = name.replace("_", "");
		name = "\"" + name + "\"";
		String type = ElementParameterParser.getValue(node, "__TYPE__");
		String destination = ElementParameterParser.getValue(node, "__DESTINATION__").trim();

		boolean hasOptions = false;

		StringBuffer sb = new StringBuffer();
		sb.append(name).append("+\":" + type + "://\"").append("+" + destination);

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__URI_OPTIONS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();

			if (!hasOptions) {
				sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasOptions = true;
			} else {
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		}

		uri = sb.toString();

	} else if ("cLog".equals(componentName)) {
		String useLogEIP = ElementParameterParser.getValue(node, "__USE_LOGEIP__");
		if ("true".equals(useLogEIP)) {
			continue;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("\"log:");
		String logName = ElementParameterParser.getValue(node, "__LOGGING_CATEGORY__");
		if(logName != null) {
			sb.append("\"+").append(logName).append("+\"");
		}

		String level = ElementParameterParser.getValue(node, "__LEVEL_TYPE__");
		sb.append("?").append("level=").append(level);

		String isSize = ElementParameterParser.getValue(node, "__GROUP_SIZE__");
		String isInterval = ElementParameterParser.getValue(node, "__GROUP_INTERVAL__");
		String isFormat = ElementParameterParser.getValue(node, "__FORMAT__");

		if ("true".equals(isSize)) {
			String groupSize = ElementParameterParser.getValue(node, "__SIZE__");
			sb.append("&groupSize=").append(groupSize).append("\"");
		} else if ("true".equals(isInterval)) {
			String interval = ElementParameterParser.getValue(node, "__INTERVAL__");
			sb.append("&groupInterval=").append(interval);
			String delay = ElementParameterParser.getValue(node, "__DELAY__");
			if (!"0".equals(delay)) {
				sb.append("&groupDelay=").append(delay);
			}
			String activeOnly = ElementParameterParser.getValue(node, "__ACTIVE_ONLY__");
			if (!"true".equals(activeOnly)) {
				sb.append("&groupActiveOnly=").append(activeOnly);
			}
			sb.append("\"");
		} else if ("true".equals(isFormat)) {
			sb.append("\"");
			List<Map<String, String>> formatValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
			for (Map<String, String> map : formatValues) {
				String argName = map.get("NAME").trim();
				String argValue = map.get("VALUE").trim();
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		} else {
			sb.append("\"");
		}

		uri = sb.toString();

	} else if ("cMail".equals(componentName)) {

		StringBuffer sb = new StringBuffer();

		String protocols = ElementParameterParser.getValue(node, "__PROTOCOLS__");
		sb.append("\"").append(protocols).append("://");

		String host = ElementParameterParser.getValue(node, "__HOST__");
		sb.append("\"+").append(host);

		String port = ElementParameterParser.getValue(node, "__PORT__");
		if (!"\"\"".equals(port)) {
			sb.append("+\":\"+").append(port);
		}

		boolean hasParam = false;
/*		String userName = ElementParameterParser.getValue(node, "__USERNAME__");
		if (!"\"\"".equals(userName)) {
			sb.append("+\"?username=\"+").append(userName);
			hasParam = true;
		}

		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
		if (!"\"\"".equals(password)) {
			if (hasParam) {
				sb.append("+\"&password=\"+");
			} else {
				sb.append("+\"?password=\"+");
			}
			sb.append(password);
			hasParam = true;
		}

		String subject = ElementParameterParser.getValue(node, "__SUBJECT__");
		if (!"\"\"".equals(subject)) {
			if (hasParam) {
				sb.append("+\"&subject=\"+");
			} else {
				sb.append("+\"?subject=\"+");
			}
			sb.append(subject);
			hasParam = true;
		}

		String from = ElementParameterParser.getValue(node, "__FROM__");
		if (!"\"\"".equals(from)) {
			if (hasParam) {
				sb.append("+\"&from=\"+");
			} else {
				sb.append("+\"?from=\"+");
			}
			sb.append(from);
			hasParam = true;
		}

		String to = ElementParameterParser.getValue(node, "__TO__");
		if (!"\"\"".equals(to)) {
			if (hasParam) {
				sb.append("+\"&to=\"+");
			} else {
				sb.append("+\"?to=\"+");
			}
			sb.append(to);
			hasParam = true;
		}
*/

		String contentType = ElementParameterParser.getValue(node, "__CONTENTTYPE__");
		if (!"\"\"".equals(contentType)) {
			if (hasParam) {
				sb.append("+\"&contentType=\"+");
			} else {
				sb.append("+\"?contentType=\"+");
			}
			sb.append(contentType);
			hasParam = true;
		}

/*		String cc = ElementParameterParser.getValue(node, "__CC__");
		if (!"\"\"".equals(cc)) {
			if (hasParam) {
				sb.append("+\"&CC=\"+");
			} else {
				sb.append("+\"?CC=\"+");
			}
			sb.append(cc);
			hasParam = true;
		}

		String bcc = ElementParameterParser.getValue(node, "__BCC__");
		if (!"\"\"".equals(bcc)) {
			if (hasParam) {
				sb.append("+\"&BCC=\"+");
			} else {
				sb.append("+\"?BCC=\"+");
			}
			sb.append(bcc);
			hasParam = true;
		}
*/
		List<Map<String, String>> formatValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
		for (Map<String, String> map : formatValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			if (hasParam) {
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			} else {
				sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasParam = true;
			}
		}

		//sb.append("+\"");
		uri = sb.toString();
	} else if ("cMQTT".equals(componentName)) {
		CamelEndpointBuilder eb = CamelEndpointBuilder.getBuilder();
		
		String factoryCompName =  helper.getStringParam("__ROUTE_COMPONENT_TYPE_ID__");
		factoryCompName = factoryCompName.replace("_", "");
		eb.setComponent(factoryCompName);

		eb.setName("\""+cid+"\"");

		String topicName = helper.getStringParam("__TOPIC_NAME__");
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if(conns.size()>0) {
			eb.addParam("publishTopicName", topicName);
		} else {
			eb.addParam("subscribeTopicName", topicName);
		}

		List<Map<String, String>> tableValues = getObjectValue(node, "__URI_OPTIONS__");
		eb.addParams(tableValues);
		uri = eb.build();
	} else if ("cHttp".equals(componentName)) {

		String isServer = ElementParameterParser.getValue(node, "__SERVER__");
		String resourceUri = ElementParameterParser.getValue(node, "__URI__");
		
		StringBuffer sb = new StringBuffer();


		boolean hasParam = resourceUri==null?false:resourceUri.contains("?");
		
		if("true".equals(isServer)){
			sb.append("\"jetty://\"+");
			sb.append(resourceUri);
			String disableStream = ElementParameterParser.getValue(node, "__DISABLE_STREAM__");
			String sessionSupport = ElementParameterParser.getValue(node, "__SESSION_SUPPORT__");
			String chunked = ElementParameterParser.getValue(node, "__CHUNKED__");
			String enableJmx = ElementParameterParser.getValue(node, "__ENABLEJMX__");
			String matchOnUriPrefix = ElementParameterParser.getValue(node, "__MATCH_ON_URI_PREFIX__");
			String traceEnable = ElementParameterParser.getValue(node, "__TRACE_ENABLE__");
			String useContinuation = ElementParameterParser.getValue(node, "__USE_CONTINUATION__");
			
			if("true".equals(disableStream)){
				if(hasParam){
					sb.append("+\"&disableStreamCache=true\"");
				}else{
					sb.append("+\"?disableStreamCache=true\"");
				}
				hasParam = true;
			}
			
			if("true".equals(sessionSupport)){
				if(hasParam){
					sb.append("+\"&sessionSupport=true\"");
				}else{
					sb.append("+\"?sessionSupport=true\"");
				}
				hasParam = true;
			}
			
			if("false".equals(chunked)){
				if(hasParam){
					sb.append("+\"&chunked=false\"");
				}else{
					sb.append("+\"?chunked=false\"");
				}
				hasParam = true;
			}
			
			if("true".equals(enableJmx)){
				if(hasParam){
					sb.append("+\"&enableJmx=true\"");
				}else{
					sb.append("+\"?enableJmx=true\"");
				}
				hasParam = true;
			}
			
			if("true".equals(matchOnUriPrefix)){
				if(hasParam){
					sb.append("+\"&matchOnUriPrefix=true\"");
				}else{
					sb.append("+\"?matchOnUriPrefix=true\"");
				}
				hasParam = true;
			}
			
			if("true".equals(traceEnable)){
				if(hasParam){
					sb.append("+\"&traceEnabled=true\"");
				}else{
					sb.append("+\"?traceEnabled=true\"");
				}
				hasParam = true;
			}
			
			if("false".equals(useContinuation)){
				if(hasParam){
					sb.append("+\"&useContinuation=false\"");
				}else{
					sb.append("+\"?useContinuation=false\"");
				}
				hasParam = true;
			}
			
			List<Map<String, String>> arguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__HEADERS__");
			for (Map<String, String> map : arguments) {
				String argName = map.get("KEY").trim();
				String argValue = map.get("VALUE").trim();

				if (hasParam) {
					sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
				} else {
					sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
					hasParam = true;
				}
			}
			
		}else{
			sb.append(resourceUri);
			String method = ElementParameterParser.getValue(node, "__METHOD__");
			if("GET".equals(method)||"HEAD".equals(method) || "DELETE".equals(method)){
				List<Map<String, String>> parameters = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__PARAMETERS__");
				String encodeCharset = ElementParameterParser.getValue(node, "__ENCODER_CHARSET__");
	
				for (Map<String, String> map : parameters) {
					String argName = map.get("KEY").trim();
					String argValue = map.get("VALUE").trim();
					try{
						if(argName.startsWith("\"")&&argName.endsWith("\"")&&argName.length()>=2){
							argName = URLEncoder.encode(argName.substring(1, argName.length()-1),encodeCharset);
							argName = "\""+argName+"\"";
						}else{
							argName = URLEncoder.encode(argName,encodeCharset);
						}
						if(argValue.startsWith("\"")&&argValue.endsWith("\"")&&argValue.length()>=2){
							argValue = URLEncoder.encode(argValue.substring(1, argValue.length()-1),encodeCharset);
							argValue = "\""+argValue+"\"";
						}else{
							argValue = URLEncoder.encode(argValue,encodeCharset);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (hasParam) {
						sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
					} else {
						sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
						hasParam = true;
					}
				}
			}
	
		}
		uri = sb.toString();
	} else if ("cFlatPack".equals(componentName)) {
		if(node.getIncomingConnections().size()>0){
			continue;//is productor node. use exist endpoint.
		}
		StringBuilder sb = new StringBuilder("\"flatpack:");
		boolean isfixed = getBoolValue(node, "__ISFIXED__");
		boolean isdelimited = getBoolValue(node, "__ISDELIMITED__");
		if (isfixed){
			sb.append("fixed:");
		} else if (isdelimited) {
			sb.append("delim:");
		}
		sb.append('"');
		
		final String filePath;
		String pzmap_filetype = ElementParameterParser.getValue(node, "__PZMAP_FILETYPE__");
		if ("file".equals(pzmap_filetype)) {
			filePath = "\"file://\"+" + ElementParameterParser.getValue(node, "__PZMAP_FILENAME__");
		} else {
			filePath = "\"classpath:" + ElementParameterParser.getValue(node, "__ROUTE_RESOURCE_TYPE_RES_URI__") + '"';
		}
		sb.append("+").append(filePath.replaceAll("\\\\","/"));

		boolean splitRows = getBoolValue(node, "__SPLIT_ROWS__");
		boolean allowShortLines = getBoolValue(node, "__ALLOW_SHORT_LINES__");
		boolean ignoreExtraColumns = getBoolValue(node, "__IGNORE_EXTRA_COLUMNS__");
	
		appendParamWhenNotDefault(sb, "splitRows", splitRows, true);
		appendParamWhenNotDefault(sb, "allowShortLines", allowShortLines, false);
		appendParamWhenNotDefault(sb, "ignoreExtraColumns", ignoreExtraColumns, false);
	
		if (isdelimited) {
			String textQualifier = ElementParameterParser.getValue(node, "__TEXT_QUALIFIER__");
			appendParamWhenNotDefaultNorEmpty(sb, "textQualifier", textQualifier, "\"");

			String delimiter = ElementParameterParser.getValue(node, "__TEXT_DELIMITER__");
			appendParamWhenNotDefaultNorEmpty(sb, "delimiter", delimiter, ",");

			boolean ignoreFirstRecord = getBoolValue(node, "__IGNORE_FIRST_RECORD__");
			appendParamWhenNotDefault(sb, "ignoreFirstRecord", ignoreFirstRecord, true);
		}

		uri = getURI(sb);
	} else {
		continue;
	}
	if(statements != null) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(statements);
    
	}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_46);
    
	if(statements != null) {
		statements = null;//reset then another node.

    stringBuffer.append(TEXT_47);
    
}}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}