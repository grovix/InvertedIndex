
import io.Source
import io.BufferedSource
import java.io.File
import com.grovix.invertedindex.IndexManager
import scala.util.matching.Regex

object work{
	val files = Source.fromFile("E:/Pages/1.txt").mkString
                                                  //> files  : String = ������, ����, ������, �����, ���, ����
	val Name = """(Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+)""".r
                                                  //> Name  : scala.util.matching.Regex = (Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+
                                                  //| )
	Name.findAllIn("Mr. Griroriy Trofimyuk asgds").foreach(println)
                                                  //> Mr. Griroriy Trofimyuk
	val file_2 = Source.fromFile("E:/RegTest.txt").mkString.toLowerCase()
                                                  //> file_2  : String = "
                                                  //| �� ����� � ������ ������������ ������� �rosetta� � ������ ��������-���������
                                                  //| �� ������ �� ���. � ������ ��� ��� ���� ������� �� ��������� ������ ������, 
                                                  //| ��������, � ���, ��� ������� ������ ������������ ����� ����������� �������. 
                                                  //| 
                                                  //| 
                                                  //| ������ � ��� ���� ������� �������. ���� � ���, ��� ����� �������� ����������
                                                  //| ���� ������� ����� � ������� �����. ������ ���������� ���������� �� ��������
                                                  //| �� ������������� � ���������� ������ �� �����. ��� ��� � ���������� � ������
                                                  //| ������ ����� ������, �� ������� ��� ����������� ���������� � ���� ������� ��
                                                  //| ��.
                                                  //| 
                                                  //| ������ rosetta ��������� ���������� �� �������� ����� ����������, ������� ��
                                                  //| �������� ����� �������� � ������. ����� �� ����� ������� � 11 ������� ������
                                                  //| ��, �� ������� ��� ��� ������ ��������.
                                                  //| 
                                                  //| ���� ���� �� ���������������� ������������ alice, ������������� ������� miro
                                                  //| , � ����� � ������� ies.
                                                  //| 
                                                  //| alice � �������, ������� ����� ���������� ����
                                                  //| Output exceeds cutoff limit.
	
	val test_reg = new Regex("\\w+")          //> test_reg  : scala.util.matching.Regex = \w+
	test_reg.findAllIn(file_2).foreach(println)
                                                  //> rosetta
                                                  //| rosetta
                                                  //| 11
                                                  //| alice
                                                  //| miro
                                                  //| ies
                                                  //| alice
                                                  //| alice
                                                  //| 4
                                                  //| 6
                                                  //| miro
                                                  //| ies
                                                  //| 5
                                                  //| rosetta
                                                  //| orbiter
                                                  //| spectrometer
                                                  //| for
                                                  //| ion
                                                  //| and
                                                  //| neutral
                                                  //| analysis
                                                  //| rosina
                                                  //| 26
                                                  //| 04
                                                  //| 1994
	
}