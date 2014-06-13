package com.grovix.invertedindex
import scala.io.Source
import java.io.File

object IndexManager{
  def getInvertedIndex(folder: String) = {
    val file_list = new File(folder).list().map(file_list => folder+"/"+file_list)
    //file_list.foreach(file_list=>println(file_list))
    
  }
}