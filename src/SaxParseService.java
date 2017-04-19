import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SaxParseService {
	public ArrayList<CourseScore> readXML(String uri)throws Exception{
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		MyHandler handler=new MyHandler();
		parser.parse(uri, handler);
		return handler.getCourseScoreList();
	}
	
	public static void main(String[]args) throws Exception{
		SaxParseService sps=new SaxParseService();
		ArrayList<CourseScore> courseScoreList=sps.readXML("XML文档3.xml");
		for(CourseScore courseScore:courseScoreList){
			System.out.println(courseScore.toStirng()+"\n");
		}
	} 
}
