package searchStudentScore;



import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SaxParseService {
	public ArrayList<Student> readXML(String uri)throws Exception{
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		StudentListHandler handler=new StudentListHandler();
		 File file=new File(uri); 
		parser.parse(file, handler);
		return handler.getStudentList();
	}
	
	public static void main(String[] args) throws Exception{
		SaxParseService sps=new SaxParseService();
		ArrayList<Student> studentList=sps.readXML("E:/workspace2/DOM/XML文档2.xml");
		for(Student student:studentList){
			System.out.println(student.toString());
		}
	}

}
