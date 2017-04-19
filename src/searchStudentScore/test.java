package searchStudentScore;

import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class test {
	
		public void Date_start_end(final String start_date,  final String end_date) throws ParseException{
			   Calendar dayc1 = new GregorianCalendar();
			   Calendar dayc2 = new GregorianCalendar();
			   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			   Date daystart = df.parse(start_date); //按照yyyy-MM-dd格式转换为日期
			   Date dayend = df.parse(end_date);
			   dayc1.setTime(daystart); //设置calendar的日期
			   dayc2.setTime(dayend);
			 
			for (; dayc1.compareTo(dayc2) <= 0;) {   //dayc1在dayc2之前就循环
			   
			    String date=dayc1.get(Calendar.YEAR)+"-"+changeM( dayc1.get(Calendar.MONTH)) +"-"+ changeD(dayc1.get(Calendar.DATE));  //打印年月日
			    System.out.println(date);
			    dayc1.add(Calendar.DAY_OF_YEAR, 1);}  //加1天
			   
			}
		public String changeM(int m){
			String result="";
			m++;
			if(m<10)
				result="0"+String.valueOf(m);
			else
				result=String.valueOf(m);
			return result;
		}
		
		public String changeD(int m){
			String result="";
			if(m<10)
				result="0"+String.valueOf(m);
			else
				result=String.valueOf(m);
			return result;
		}
		
		public double randomLength(){
			DecimalFormat    df   = new DecimalFormat("######0.00");   
			return Double.valueOf(df.format(Math.random()*10));//Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 
		}
		
		public static void main(String [] args) throws ParseException{
			test t=new test();
			System.out.println(t.randomLength());
			System.out.println(t.randomLength());
			System.out.println(t.randomLength());
			System.out.println(t.randomLength());
			System.out.println(t.randomLength());
		}
	

}
