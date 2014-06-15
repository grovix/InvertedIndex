package com.grovix.invertedindex
import scala.collection.mutable.MutableList

object IndexTrie {
  private var trie = new Trie[MutableList[Int]]
  
  def addWord(s:String,i:Int)={
    trie.put(s,
			trie.get(s) match{
				case Some(a) => a += i
				case None => MutableList(i)
		})
  }
  
  override def toString()={
    trie.toString()
  }

}