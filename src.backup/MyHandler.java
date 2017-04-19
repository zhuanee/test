import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler{
	private ArrayList<CourseScore> courseScoreList=null;
	private CourseScore courseScore=null;
	private Score score=null;
	private String preTag=null;
	
	public ArrayList<CourseScore> getCourseScoreList(){
		return courseScoreList;
	}
	
	@Override
	public void startDocument() throws SAXException{
		courseScoreList=new ArrayList<CourseScore> ();
	}
	
	@Override
	public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException{
		if("课程成绩".equals(qName)){
			courseScore=new CourseScore();
			courseScore.setCourseId(attributes.getValue(0));
			courseScore.setScoreProperty(attributes.getValue(1));
		}
		else if("成绩".equals(qName)){
			score=new Score();
		}
		preTag=qName;
	}
	
	@Override
	public void characters(char[] ch,int start,int length)throws SAXException{
		String content=null;
		if(preTag!=null){
			content=new String(ch,start,length);
			if("学号".equals(preTag)){
				score.setStudentId(content);;
			}
			else if("得分".equals(preTag)){
				score.setScore(content);
			}
		}
	}
	
	@Override
	public void endElement(String uri,String localName,String qName)throws SAXException{
		if("课程成绩".equals(qName)){
			courseScoreList.add(courseScore);
			courseScore=null;
		}
		else if("成绩".equals(qName)){
			if(Integer.parseInt(score.getScore())<60)
			{
			courseScore.addScore(score);
			}
			score=null;
		}
		preTag=null;
	}

}
