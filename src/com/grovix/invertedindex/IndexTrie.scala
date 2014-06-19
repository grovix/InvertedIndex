package com.grovix.invertedindex

import scala.collection.Seq
import scala.collection.mutable.Set
import scala.collection.immutable.TreeMap
import scala.collection.immutable.WrappedString
import scala.math.LowPriorityOrderingImplicits
import java.io._

 class IndexTrie(key: Option[Char]) {
 
    def this() {
      this(None);
    }
 
    var nodes = new TreeMap[Char, IndexTrie]; 
 
    var value : Option[Set[Int]] = None;
    
    def put(k: String, i: Int): IndexTrie = {
 
      wrap(k) match {
        case Seq()        => {
          this.value = this.value match{
            case None => Some(Set(i))
            case Some(a) => Some(a+=i)
          }
          this;
        }
        case Seq(h,t @_*) => {
          val node = this.nodes.get(h) match {
            case None => {
              val n = new IndexTrie(Some(h));
              this.nodes = this.nodes.insert(h, n);
              n;
            }
            case Some(n) => {
              n
            }
          }
          node.put(t,i);
        }
      }
    }
    
   def putSet(k: String, s: Set[Int]): IndexTrie = {
 
      wrap(k) match {
        case Seq()        => {
          this.value = Some(s)
          this;
        }
        case Seq(h,t @_*) => {
          val node = this.nodes.get(h) match {
            case None => {
              val n = new IndexTrie(Some(h));
              this.nodes = this.nodes.insert(h, n);
              n;
            }
            case Some(n) => {
              n
            }
          }
          node.putSet(t,s);
        }
      }
    }
    
   private def printAllWordsAcc(m : TreeMap[Char, IndexTrie], s:Seq[Char]): Int={
	for(elem <- m){
	elem._2.value match{
	case None =>
	case Some(a) => val t = s:+elem._1; t.foreach(print);print(" ");a.foreach(a=>print(a+" "));print("\n")
	}
	printAllWordsAcc(elem._2.nodes,s:+elem._1)
	}
	return 1;
  } 
  
  def printAllWords()= {
    printAllWordsAcc(nodes, Seq())
  }
  
  def printToFile(file:String)={
      val writer = new PrintWriter(new File(file))
      printToFileAcc(nodes, Seq(),writer)
      writer.close();
  }
  
  private def printToFileAcc(m: TreeMap[Char, IndexTrie], s:Seq[Char], writer : PrintWriter): Int= {
	for(elem <- m){
	elem._2.value match{
	case None =>
	case Some(a) => {
		val t = s:+elem._1
		t.foreach(t=>writer.write(t))
		writer.write(" ")
		a.foreach(a=>writer.write(a+" "))
		writer.println()
		}
	}
	printToFileAcc(elem._2.nodes,s:+elem._1,writer)
	}
	return 1;
  }
  
  def isEmpty:Boolean={
    return nodes.isEmpty
  }
  
  def clear() = {
    nodes = TreeMap[Char, IndexTrie]()
  }
     
    private def wrap(s: String) : WrappedString = {
      new WrappedString(s)
    }
 
    def get(k: String): Option[Set[Int]] = {
      nodeFor(k).flatMap { (n) => n.value }
    }
 
    def getAll : Seq[Set[Int]] = {
      this.value.toList ++ this.nodes.values.flatMap { n => n.getAll }
    }
 
    override def toString = {
      key.toString ++ ":" ++ value.toString ++ "\n" ++ nodes.values.map { n => n.toString.split("\n").map { l => "  " + l }.mkString("\n") }.mkString("\n")
    }
 
    def nodeFor(k: String): Option[IndexTrie] =  {
      wrap(k) match {
        case Seq()          => Some(this)
        case Seq(h, t @_*) => nodes.get(h).flatMap { n => n.nodeFor(t) }
      }
    }
 
    implicit def charSeq2String(s: Seq[Char]) : String = {
      s.mkString
    }
    
    def toFile(file : String)={
       val writer = new PrintWriter(new File(file))
       writer.write(toString())
       writer.close();

    }
    
  }