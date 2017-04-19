import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CourseScoreDom {
	public Document createCourseScoreList() throws ParserConfigurationException{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.newDocument();
		Element root=doc.createElementNS("http://jw.nju.edu.cn/schema", "课程成绩列表");
		root.setAttribute("xsi:schemaLocation", "http://jw.nju.edu.cn/schema ./ScoreList.xsd");
		root.setAttribute("xmlns:tns", "http://jw.nju.edu.cn/schema");
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		doc.appendChild(root);
		return doc;
	}
	
	
	public void addCourseScore(Document doc,CourseScore courseScore){
		Element courseScoreElement=doc.createElement("课程成绩");
		
		courseScoreElement.setAttribute("课程编号", courseScore.getCourseId());
		courseScoreElement.setAttribute("成绩性质", courseScore.getScoreProperty());
		
		for(Score score:courseScore.getScoreList()){
		Element scoreElement=doc.createElement("成绩");
		Element idElement=doc.createElement("学号");
		Element gradeElement=doc.createElement("得分");
		idElement.setTextContent(score.getStudentId());
		gradeElement.setTextContent(score.getScore());
		scoreElement.appendChild(idElement);
		scoreElement.appendChild(gradeElement);
		courseScoreElement.appendChild(scoreElement);
		}
		
		doc.getFirstChild().appendChild(courseScoreElement);
		
	}
	
	
	public void transformDoc(Document doc,String uri) throws TransformerFactoryConfigurationError, TransformerException{
		Transformer t=TransformerFactory.newInstance().newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.setOutputProperty(OutputKeys.METHOD, "xml");
		Source xmlSource=new DOMSource(doc);
		Result outputTarget=new StreamResult(new File(uri));
		t.transform(xmlSource, outputTarget);
	}
	
	
	public static void main(String[]args) throws Exception{
		CourseScoreDom csd=new CourseScoreDom();
		SaxParseService sps=new SaxParseService();
		
		Document doc=csd.createCourseScoreList();
		ArrayList<CourseScore> courseScoreList=sps.readXML("XML文档3.xml");
		for(CourseScore courseScore:courseScoreList){
			csd.addCourseScore(doc, courseScore);
		}
		csd.transformDoc(doc, "XML文档4.xml");
		
	}
	
	

}
