import java.io.File;

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
		Element root=doc.createElementNS("http://jw.nju.edu.cn/schema","学生列表");
		root.setAttribute("xmlns:nju","http://www.nju.edu.cn/schema");
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:schemaLocation", "http://jw.nju.edu.cn/schema ./StudentList.xsd");
		doc.appendChild(root);
		return doc;
	}
	
	
	//添加学生节点到学生列表节�?
	public boolean addStudent(Document doc,String name,String sex,String both,String identity,String departmentID,String departmentName,String id,String profession,String entranceYear,String belongYear,String duration,boolean studentState){
		boolean result=true;
		
		Element student=doc.createElement("学生");
		//设置个人信息node
		Element personalInf=doc.createElement("个人信息");
		Element nameElement=doc.createElement("nju:姓名");
		Element sexElement=doc.createElement("nju:性别");
		Element bothElement=doc.createElement("nju:出生日期");
		Element identityElement=doc.createElement("nju:身份证号");
		Element departmentElement=doc.createElement("nju:部门信息");
		Element departmentIDElement=doc.createElement("nju:部门编号");
		Element departmentNameElement=doc.createElement("nju:部门名称");
		nameElement.setTextContent(name);
		sexElement.setTextContent(sex);
		bothElement.setTextContent(both);
		identityElement.setTextContent(identity);
		departmentIDElement.setTextContent(departmentID);
		departmentNameElement.setTextContent(departmentName);
        departmentElement.appendChild(departmentNameElement);
        departmentElement.appendChild(departmentIDElement);
        personalInf.appendChild(nameElement);
        personalInf.appendChild(sexElement);
        personalInf.appendChild(bothElement);
        personalInf.appendChild(identityElement);
        personalInf.appendChild(departmentElement);
        
        //设置其他node
		Element idElement=doc.createElement("学号");
		idElement.setTextContent(id);
		Element professionElement=doc.createElement("专业");
		professionElement.setTextContent(profession);
		Element durationElement=doc.createElement("学制");
		durationElement.setTextContent(duration);
		Element studentStateElement=doc.createElement("学籍状�?");
		if(studentState)
			studentStateElement.setTextContent("true");
		else
			studentStateElement.setTextContent("false");
		Element entranceElement=doc.createElement("入学年级");
		entranceElement.setTextContent(entranceYear);
		Element belongElement=doc.createElement("�?��年级");
		belongElement.setTextContent(belongYear);
		Element personalScore=doc.createElement("个人成绩列表");
		
		//挂在node到根节点root
		doc.getFirstChild().appendChild(student);
		student.appendChild(personalInf);
		student.appendChild(idElement);
		student.appendChild(professionElement);
		student.appendChild(durationElement);
		student.appendChild(studentStateElement);
		student.appendChild(entranceElement);
		student.appendChild(belongElement);
		student.appendChild(personalScore);
		return result;
	}
	
	
	//添加单科成绩到学生节点的个人成绩节点
	public boolean addScore(Document doc,String id,String courseID,String courseName,String teacher,String ordinaryGrade,String fianlGrade,String totalGrade ){
		boolean result=true;
		NodeList nl=doc.getElementsByTagName("学号");
		Element subjectScore=doc.createElement("单科成绩");
		Element courseElement=doc.createElement("课程");
		Element courseIDElement=doc.createElement("课程编号");
		Element courseNameElement=doc.createElement("课程名称");
		Element teacherElement=doc.createElement("任课老师");
		Element ordinaryElement=doc.createElement("平时成绩");
		Element finalElement=doc.createElement("期末成绩");
		Element totalElement=doc.createElement("总评成绩");
		courseIDElement.setTextContent(courseID);
		courseNameElement.setTextContent(courseName);
		teacherElement.setTextContent(teacher);
		ordinaryElement.setTextContent(ordinaryGrade);
		finalElement.setTextContent(fianlGrade);
		totalElement.setTextContent(totalGrade);
		courseElement.appendChild(courseIDElement);
		courseElement.appendChild(courseNameElement);
		courseElement.appendChild(teacherElement);
		subjectScore.appendChild(courseElement);
		subjectScore.appendChild(ordinaryElement);
		subjectScore.appendChild(finalElement);
		subjectScore.appendChild(totalElement);
		for(int i=0;i<nl.getLength();i++){
			if(nl.item(i).getTextContent().equals(id)){
				Node m=nl.item(i).getParentNode();
				m.getChildNodes().item(7).appendChild(subjectScore);
				break;
			}
		}
		
		return result;
	}
	
	
	//转换函数
	public  void transferDoc(Document doc,String uri) throws TransformerFactoryConfigurationError, TransformerException{
		Transformer t=TransformerFactory.newInstance().newTransformer();
	    t.setOutputProperty(OutputKeys.INDENT,"yes");
	    t.setOutputProperty(OutputKeys.METHOD, "xml");
		Source xmlSource=new DOMSource(doc);
		Result outputTarget=new StreamResult(new File(uri));
		t.transform(xmlSource, outputTarget);
	}
	
	//随机生成0-100的分�?
	public String randomScore(){
		return String.valueOf((int)(Math.random()*101));
	}
	
	
	public static void main(String []args) throws Exception{
		DomGeneration dg=new DomGeneration();
		Document doc=dg.createStudnetListDoc();
		
		dg.addStudent(doc, "李轩", "�?, "1996�?�?�?, "320925199601020018", "131313", "软件学院", "131250038", "软件工程","2013", "2013","4.0",true);
		dg.addStudent(doc, "肖旖", "�?, "1996�?�?�?, "320925199601020018", "131313", "软件学院", "131250037", "软件工程","2013", "2013","4.0",true);
		dg.addStudent(doc, "傅全�?, "�?, "1996�?�?�?, "320925199601020018", "131313", "软件学院", "131250045", "软件工程","2013", "2013","4.0",true);
		dg.addStudent(doc, "韩淳", "�?, "1996�?�?�?, "320925199601020018", "131313", "软件学院", "131250092", "软件工程","2013", "2013","4.0",true);
		dg.addStudent(doc, "黄春�?, "�?, "1996�?�?�?, "320925199601020018", "131313", "软件学院", "131250199", "软件工程","2013", "2013","4.0",true);

		dg.addScore(doc, "131250038", "00000001", "软件测试与质�?, "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250038", "00000002", "Linux程序设计", "贝加", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250038", "00000003", "Linux系统基础", "曾生", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250038", "00000004", "软件设计", "哦哦", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250038", "00000005", "人机交互", "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
		
		dg.addScore(doc, "131250037", "00000001", "软件测试与质�?, "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250037", "00000002", "Linux程序设计", "贝加", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250037", "00000003", "Linux系统基础", "曾生", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250037", "00000004", "软件设计", "哦哦", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250037", "00000005", "人机交互", "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());		
	
		dg.addScore(doc, "131250045", "00000001", "软件测试与质�?, "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250045", "00000002", "Linux程序设计", "贝加", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250045", "00000003", "Linux系统基础", "曾生", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250045", "00000004", "软件设计", "哦哦", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250045", "00000005", "人机交互", "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
	
		dg.addScore(doc, "131250092", "00000001", "软件测试与质�?, "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250092", "00000002", "Linux程序设计", "贝加", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250092", "00000003", "Linux系统基础", "曾生", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250092", "00000004", "软件设计", "哦哦", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250092", "00000005", "人机交互", "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
	
		dg.addScore(doc, "131250199", "00000001", "软件测试与质�?, "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250199", "00000002", "Linux程序设计", "贝加", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250199", "00000003", "Linux系统基础", "曾生", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250199", "00000004", "软件设计", "哦哦", dg.randomScore(), dg.randomScore(), dg.randomScore());
		dg.addScore(doc, "131250199", "00000005", "人机交互", "陈振�?, dg.randomScore(), dg.randomScore(), dg.randomScore());
		
		dg.transferDoc(doc, "studentList.xml");
	}

}
