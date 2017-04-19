package searchStudentScore;

import java.util.ArrayList;
import java.util.List;



public class Student {
	private String studentID;
	private ArrayList<Score> scoreList;
	
	public Student(){
		studentID=null;
		scoreList=new ArrayList<Score>();
	}
	
	public String getStudentID(){
		return studentID;
	}
	
	public List<Score> getScoreList(){
		return scoreList;
	}
	
	public void setStudentID(String studentID){
		this.studentID=studentID;
	}
	
	public void setScoreList(ArrayList<Score> scoreList){
		this.scoreList=scoreList;
	}
	
	public void addScore(Score score){
		scoreList.add(score);
	}
	
	
	public String toString(){
		String result=studentID+"\n";
		for(Score score:getScoreList()){
			result+=score.getCourseID()+" "+score.getCourseName()+" "+score.getCourseTeacher()+" "+score.getOrdinaryScore()+" "+score.getFinalScore()+" "+score.getOverallScore()+"\n";
		}
		return result;
	}

}
