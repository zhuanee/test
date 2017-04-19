<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                              xmlns:tns="http://jw.nju.edu.cn/schema">
<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" />
	<xsl:template match="/">
		<课程成绩列表 xsi:schemaLocation="http://jw.nju.edu.cn/schema ./ScoreList.xsd" 
		          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		          xmlns="http://jw.nju.edu.cn/schema">
		          <课程成绩 课程编号="00000001" 成绩性质="平时成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000001'">
		              <xsl:if test="@成绩性质='平时成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000001" 成绩性质="期末成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000001'">
		              <xsl:if test="@成绩性质='期末成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000001" 成绩性质="总评成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000001'">
		              <xsl:if test="@成绩性质='总评成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000002" 成绩性质="平时成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000002'">
		              <xsl:if test="@成绩性质='平时成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000002" 成绩性质="期末成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000002'">
		              <xsl:if test="@成绩性质='期末成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000002" 成绩性质="总评成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000002'">
		              <xsl:if test="@成绩性质='总评成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000003" 成绩性质="平时成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000003'">
		              <xsl:if test="@成绩性质='平时成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000003" 成绩性质="期末成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000003'">
		              <xsl:if test="@成绩性质='期末成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000003" 成绩性质="总评成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000003'">
		              <xsl:if test="@成绩性质='总评成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000004" 成绩性质="平时成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000004'">
		              <xsl:if test="@成绩性质='平时成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000004" 成绩性质="期末成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000004'">
		              <xsl:if test="@成绩性质='期末成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000004" 成绩性质="总评成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000004'">
		              <xsl:if test="@成绩性质='总评成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000005" 成绩性质="平时成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000005'">
		              <xsl:if test="@成绩性质='平时成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000005" 成绩性质="期末成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000005'">
		              <xsl:if test="@成绩性质='期末成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		          <课程成绩 课程编号="00000005" 成绩性质="总评成绩">
		          <xsl:for-each select="tns:课程成绩列表/tns:课程成绩">
		            <xsl:sort select="tns:成绩/tns:得分" order="descending" data-type="number"></xsl:sort>
		            <xsl:if test="@课程编号='00000005'">
		              <xsl:if test="@成绩性质='总评成绩'">
		                <成绩>
		                  <学号><xsl:value-of select="tns:成绩/tns:学号"></xsl:value-of></学号>
		                  <得分><xsl:value-of select="tns:成绩/tns:得分"></xsl:value-of></得分>
		                </成绩>
		              </xsl:if>
		            </xsl:if>
		          </xsl:for-each>
		          </课程成绩>
		</课程成绩列表>
	</xsl:template>
</xsl:stylesheet>