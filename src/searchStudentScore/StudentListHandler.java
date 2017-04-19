package searchStudentScore;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentListHandler extends DefaultHandler {
	private ArrayList<Student>studentList=null;
	private Student student=null;
	private Score score=null;
	private String preTag=null;
	
	public ArrayList<Student> getStudentList(){
		return studentList;
	}
	
	@Override
	public void startDocument() throws SAXException{
		studentList=new ArrayList<Student>();
	}
	
	@Override
	public void startElement(String uri,String localName,String qName,Attributes attributes)throws SAXException{
		if("学生".equals(qName)){
			student=new Student();
		}
		else if("单科成绩".equals(qName)){
			score=new Score();
		}
		preTag=qName;
	}
	
	@Override
	public void characters(char[]ch,int start,int length)throws SAXException{
		String content=null;
		if(preTag!=null){
			content=new String(ch,start,length);
			if("学号".equals(preTag)){
				student.setStudentID(content);
			}
			else if("课程编号".equals(preTag)){
				score.setCourseID(content);
			}
			else if("课程名称".equals(preTag)){
				score.setCourseName(content);
			}
			else if("任课老师".equals(preTag)){
				score.setCourseTeacher(content);
			}
			else if("平时成绩".equals(preTag)){
				score.setOrdinaryScore(Integer.parseInt(content));
			}
			else if("期末成绩".equals(preTag)){
				score.setFinalScore(Integer.parseInt(content));
			}
			else if("总评成绩".equals(preTag)){
				score.setOverallScore(Integer.parseInt(content));
			}
		}
	}
	
	
	@Override
	public void endElement(String uri,String localName,String qName)throws SAXException{
		if("学生".equals(qName)){
			studentList.add(student);
			student=null;
		}
		else if("单科成绩".equals(qName)){
			student.addScore(score);
			score=null;
		}
		preTag=null;
	}

}
