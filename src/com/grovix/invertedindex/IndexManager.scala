package com.grovix.invertedindex
import scala.io.Source
import java.io.File
import scala.util.matching.Regex
import scala.collection.mutable.Set

object IndexManager{
  var file_list = Map[Int,String]()
  var trie = new IndexTrie
  
  def getInvertedIndex(folder: String,file: String)= {
    file_list = getFilesFromFolder(folder)
    for(file <- file_list){
      val text = Source.fromFile(file._2,"cp1251").getLines()
      val regex = new Regex("[a-zа-я]+") 
      for(line <- text){
        if(!line.isEmpty())
    	  regex.findAllIn(line.toLowerCase()).foreach(n => trie.put(n, file._1 ))
      } 
    }
    trie.printToFile(file)
  }
  
  def loadInvertedIndex(folder: String, file: String){
    if(!trie.isEmpty)
      trie.clear()
    file_list = getFilesFromFolder(folder)
    val dictionary = Source.fromFile(file,"utf-8").getLines()
    for(str <- dictionary){
      val str_array = str.split(" ")
      val num_set = Set(str_array.tail.map{_.toInt} :_*)
      trie.putSet(str_array.head, num_set)
    }
  }
  
  def main(args: Array[String]) {
    IndexManager.getInvertedIndex("E:/Pages","E:/test.txt")
    IndexManager.find("bbb")

  }
  
  def getFilesFromFolder(folder: String):Map[Int,String]={
    val file_list = new File(folder).list().map(file_list => folder+"/"+file_list)
    val index_list = List.range(1, file_list.length+1)
    val file_map = (index_list zip file_list).toMap
    return file_map
  }
  
  def find(s :String)={
    //кинуть исключение,если file_list пуст
    val result = trie.get(s)
    result match{
      case None => println("word not found")
      case Some(a) => a.foreach(n => println(file_list.get(n).get))
    }
  }
}

