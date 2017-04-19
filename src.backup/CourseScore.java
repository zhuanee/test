import java.util.ArrayList;


public class CourseScore {
	private String courseId;
	private String scoreProperty;
	private ArrayList<Score> scoreList;
	
	public CourseScore(){
		courseId=null;
		scoreProperty=null;
		scoreList=new ArrayList<Score>();
	}
	
	public String getCourseId(){
		return courseId;
	}
	
	public String getScoreProperty(){
		return scoreProperty;
	}
	
	public ArrayList<Score> getScoreList(){
		return scoreList;
	}
	
	public void setCourseId(String courseId){
		this.courseId=courseId;
	}
	
	public void setScoreProperty(String scoreProperty){
		this.scoreProperty=scoreProperty;
	}
	
	public void addScore(Score score){
		scoreList.add(score);
	}
	
	public void setScoreList(ArrayList<Score> scoreList){
		this.scoreList=scoreList;
	}
	
	public String toStirng(){
		String result=courseId+":"+scoreProperty+"\n";
		for(Score score:scoreList){
			result+=score.toString()+"\n";
		}
		return result;
		
	}
}
