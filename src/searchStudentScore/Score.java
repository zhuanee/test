package searchStudentScore;

public class Score {
	private String courseID;
	private String courseTeacher;
	private String courseName;
	private int ordinaryScore;
	private int finalScore;
	private int overallScore;
	
	
	
	public String getCourseID(){
		return courseID;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public String getCourseTeacher(){
		return courseTeacher;
	}
	
	public int getOrdinaryScore(){
		return ordinaryScore;
	}
	
	public int getFinalScore(){
		return finalScore;
	}
	
	public int getOverallScore(){
		return overallScore;
	}
	
	public void setCourseID(String courseID){
		this.courseID=courseID;
	}
	
	public void setCourseName(String courseName){
		this.courseName=courseName;
	}
	
	public void setCourseTeacher(String courseTeacher){
		this.courseTeacher=courseTeacher;
	}
	
	public void setOrdinaryScore(int ordinaryScore){
		this.ordinaryScore=ordinaryScore;
	}
	
	public void setFinalScore(int finalScore){
		this.finalScore=finalScore;
	}
	
	public void setOverallScore(int overallScore){
		this.overallScore=overallScore;
	}
	
	
	

}
