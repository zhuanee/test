
public class Score {
	private String studentId;
	private String score;
	
	public String getStudentId(){
		return studentId;
	}
	
	public String getScore(){
		return score;
	}
	
	public void setStudentId(String studentId){
		this.studentId=studentId;
	}
	
	public void setScore(String score){
		this.score=score;
	}
	
	public String toString(){
		return studentId+":"+score;
	}

}
