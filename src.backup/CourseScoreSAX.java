import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;


public class CourseScoreSAX {
	
	public void buildXML() throws Exception{
		Result resultXML=new StreamResult(new FileOutputStream("XML文档5.xml"));
		SAXTransformerFactory sff=(SAXTransformerFactory)SAXTransformerFactory.newInstance();
		TransformerHandler th=sff.newTransformerHandler();
		Transformer transformer=th.getTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		th.setResult(resultXML);

		
        SaxParseService sps=new SaxParseService();
		ArrayList<CourseScore> courseScoreList=sps.readXML("XML文档3.xml");
		
		
		
		//构建xml文档�?��
		th.startDocument();
		AttributesImpl attr=new AttributesImpl();
		attr.clear();
		attr.addAttribute("", "", "xmlns", "", "http://jw.nju.edu.cn/schema");
		attr.addAttribute("", "", "xmlns:tns", "", "http://jw.nju.edu.cn/schema");
		attr.addAttribute("", "", "xmlns:xsi", "", "http://www.w3.org/2001/XMLSchema-instance");
		attr.addAttribute("", "", "xsi:schemaLocation", "", "http://jw.nju.edu.cn/schema ./ScoreList.xsd");
		th.startElement("", "", "课程成绩列表", attr);
		attr.clear();
		
		for(CourseScore courseScore:courseScoreList){
			attr.addAttribute("", "", "课程编号", "", courseScore.getCourseId());
			attr.addAttribute("", "", "成绩性质", "", courseScore.getScoreProperty());
			th.startElement("", "", "课程成绩", attr);
			attr.clear();
			for(Score score:courseScore.getScoreList()){
				th.startElement("", "", "成绩", attr);
				
				th.startElement("", "", "学号", attr);
				th.characters(score.getStudentId().toCharArray(), 0, score.getStudentId().length());
			    th.endElement("", "", "学号");
			    
			    th.startElement("", "", "得分", attr);
			    th.characters(score.getScore().toCharArray(), 0, score.getScore().length());
			    th.endElement("", "", "得分");
			    
			    th.endElement("", "", "成绩");
			}
			th.endElement("", "", "课程成绩");
		}
		
		th.endElement("", "", "课程成绩列表");
		th.endDocument();
		
	}
	
	public static void main(String[] args) throws Exception{
		CourseScoreSAX css=new CourseScoreSAX();
		css.buildXML();
	}

}
