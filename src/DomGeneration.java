import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DomGeneration {
	//创建文档
	public Document createStudnetListDoc() throws ParserConfigurationException{
		DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=docFactory.newDocumentBuilder();
		Document doc=builder.newDocument();
		Element root=doc.createElement("运动数据列表");
		doc.appendChild(root);
		return doc;
	}
	
	
	//添加学生节点到学生列表节点
	public boolean addDataItem(Document doc,String name,String date,double length,double time,double energy){
		boolean result=true;
		
		Element student=doc.createElement("运动数据");
		//设置个人信息node
		student.setAttribute("用户名", name);
		student.setAttribute("日期",date);
		
        
        //设置其他node
		Element lengthElement=doc.createElement("运动距离");
		lengthElement.setTextContent(String.valueOf(length));
		Element timeElement=doc.createElement("运动时长");
		timeElement.setTextContent(String.valueOf(time));
		Element energyElement=doc.createElement("燃烧热量");
		energyElement.setTextContent(String.valueOf(energy));
		
		
		//挂在node到根节点root
		doc.getFirstChild().appendChild(student);
		student.appendChild(lengthElement);
		student.appendChild(timeElement);
		student.appendChild(energyElement);
		
		return result;
	}
	
	
	//添加单科成绩到学生节点的个人成绩节点
	
	
	
	//转换函数
	public  void transferDoc(Document doc,String uri) throws TransformerFactoryConfigurationError, TransformerException{
		Transformer t=TransformerFactory.newInstance().newTransformer();
	    t.setOutputProperty(OutputKeys.INDENT,"yes");
	    t.setOutputProperty(OutputKeys.METHOD, "xml");
		Source xmlSource=new DOMSource(doc);
		Result outputTarget=new StreamResult(new File(uri));
		t.transform(xmlSource, outputTarget);
	}
	
	//随机生成0-100的分数
	public double randomLength(){
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		return Double.valueOf(df.format(Math.random()*10));//Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 
	}
	
	public double randomTime(){
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		return Double.valueOf(df.format(Math.random()*50));//Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 
	}
	
	public double randomEnergy(){
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		return Double.valueOf(df.format(Math.random()*5000));//Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 
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
	public static void main(String []args) throws Exception{
		
		
		DomGeneration dg=new DomGeneration();
		Document doc=dg.createStudnetListDoc();
		
		Calendar dayc1 = new GregorianCalendar();
		   Calendar dayc2 = new GregorianCalendar();
		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		   Date daystart = df.parse("2016-01-01"); //按照yyyy-MM-dd格式转换为日期
		   Date dayend = df.parse("2016-12-04");
		   dayc1.setTime(daystart); //设置calendar的日期
		   dayc2.setTime(dayend);
		 
		for (; dayc1.compareTo(dayc2) <= 0;) {   //dayc1在dayc2之前就循环
		   
		    String date=dayc1.get(Calendar.YEAR)+"-"+dg.changeM( dayc1.get(Calendar.MONTH)) +"-"+ dg.changeD(dayc1.get(Calendar.DATE));  //打印年月日
		    dg.addDataItem(doc, "zhuanee", date, dg.randomLength(), dg.randomTime(), dg.randomEnergy());
		    dayc1.add(Calendar.DAY_OF_YEAR, 1);}  //加1天
		
		dg.transferDoc(doc, "dataList.xml");
	}

}
