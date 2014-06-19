import com.grovix.invertedindex.IndexManager
object work {

 IndexManager.getInvertedIndex("E:/Pages", "E:/test.txt")
 IndexManager.find("az")                          //> word not found
}