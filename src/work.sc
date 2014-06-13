
import io.Source
import io.BufferedSource
import java.io.File
import com.grovix.invertedindex.IndexManager
import scala.util.matching.Regex

object work{
	val files = Source.fromFile("E:/Pages/1.txt").mkString
                                                  //> files  : String = молоко, хлеб, €блоко, банан, рис, рыба
	val Name = """(Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+)""".r
                                                  //> Name  : scala.util.matching.Regex = (Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+
                                                  //| )
	Name.findAllIn("Mr. Griroriy Trofimyuk asgds").foreach(println)
                                                  //> Mr. Griroriy Trofimyuk
	val file_2 = Source.fromFile("E:/RegTest.txt").mkString.toLowerCase()
                                                  //> file_2  : String = "
                                                  //| на хабре о миссии межпланетной станции Ђrosettaї к комете чурюмова-герасимен
                                                  //| ко писали не раз. и каждый раз это были новости об очередном успехе миссии, 
                                                  //| например, о том, что станци€ смогла Ђпроснутьс€ї после длительного просто€. 
                                                  //| 
                                                  //| 
                                                  //| теперь Ч еще одна хороша€ новость. дело в том, что часть научного инструмент
                                                  //| ари€ станции вошла в рабочий режим. сейчас провод€тс€ наблюдени€ за окружающ
                                                  //| им пространством с пересылкой данных на землю. все это Ч подготовка к исслед
                                                  //| ованию самой кометы, до которой еще полмиллиона километров и пара мес€цев пу
                                                  //| ти.
                                                  //| 
                                                  //| сейчас rosetta находитс€ поблизости от главного по€са астероидов, который ра
                                                  //| сположен между юпитером и марсом. всего на борту станции Ч 11 научных прибор
                                                  //| ов, из которых три уже начали работать.
                                                  //| 
                                                  //| речь идет об ультрафиолетовом спектрометре alice, микроволновом приборе miro
                                                  //| , а также о датчике ies.
                                                  //| 
                                                  //| alice Ч система, котора€ будет заниматьс€ анал
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