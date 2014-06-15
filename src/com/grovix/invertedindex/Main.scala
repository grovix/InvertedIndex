package com.grovix.invertedindex
import scala.io.Source
import java.io.File
import scala.util.matching.Regex

object IndexManager{
  def getInvertedIndex(folder: String)= {
    val file_list = new File(folder).list().map(file_list => folder+"/"+file_list)
    val index_list = List.range(1, file_list.length+1)
    val file_map = (file_list zip index_list).toMap
    for(file <- file_map){
      println(file._1)
      val text = Source.fromFile(file._1,"utf-8").mkString.toLowerCase()
      val regex = new Regex("[a-z]+") 
      regex.findAllIn(text).foreach(text => IndexTrie.addWord(text, file._2 ))
    }
  }
  
  def main(args: Array[String]) {
    IndexManager.getInvertedIndex("E:/Pages")
    println(IndexTrie.toString())
  }
}

