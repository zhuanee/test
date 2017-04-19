<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                              xmlns:tns="http://jw.nju.edu.cn/schema">
<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" />
	<xsl:template match="/">
		<课程成绩列表 xmlns="http://jw.nju.edu.cn/schema"
                  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                  xsi:schemaLocation="http://jw.nju.edu.cn/schema ./ScoreList.xsd">
            <xsl:for-each select="tns:学生列表 /tns:学生">
               
               <xsl:for-each select="tns:个人成绩列表/tns:单科成绩">
               <课程成绩>
                 <xsl:attribute name="课程编号"><xsl:value-of select="tns:课程/tns:课程编号"></xsl:value-of></xsl:attribute>
                 <xsl:attribute name="成绩性质">平时成绩</xsl:attribute>
                 <成绩>
                   <学号><xsl:value-of select="../../tns:学号"></xsl:value-of></学号>
                   <得分><xsl:value-of select="tns:平时成绩"></xsl:value-of></得分>
                 </成绩>
               </课程成绩>
               <课程成绩>
                 <xsl:attribute name="课程编号"><xsl:value-of select="tns:课程/tns:课程编号"></xsl:value-of></xsl:attribute>
                 <xsl:attribute name="成绩性质">期末成绩</xsl:attribute>
                 <成绩>
                   <学号><xsl:value-of select="../../tns:学号"></xsl:value-of></学号>
                   <得分><xsl:value-of select="tns:期末成绩"></xsl:value-of></得分>
                 </成绩>
               </课程成绩>
               <课程成绩>
                 <xsl:attribute name="课程编号"><xsl:value-of select="tns:课程/tns:课程编号"></xsl:value-of></xsl:attribute>
                 <xsl:attribute name="成绩性质">总评成绩</xsl:attribute>
                 <成绩>
                   <学号><xsl:value-of select="../../tns:学号"></xsl:value-of></学号>
                   <得分><xsl:value-of select="tns:总评成绩"></xsl:value-of></得分>
                 </成绩>
               </课程成绩>
               </xsl:for-each>
               
            </xsl:for-each>
        </课程成绩列表>
	</xsl:template>
</xsl:stylesheet>