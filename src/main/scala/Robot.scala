import scala.collection.mutable.ListBuffer

class Robot() {
  var used_name = new ListBuffer[String]()

  // Recursive function call made here
  def auto_gen(): String ={
    val chars = 'A' to 'Z'
    val num = 1 to 9
    val sb = new StringBuilder
    for (i <- 0 until 2) {
      sb.append(chars(scala.util.Random.nextInt(chars.length)))
    }
    for (i <- 0 until 3) {
      sb.append(num(scala.util.Random.nextInt(num.length)))
    }
    val new_name = sb.toString
    if(used_name contains new_name){
      this.auto_gen()
    }else{
      used_name += new_name
    }
    new_name
  }

  var name: String = auto_gen()

  def reset(): String ={
    this.name = auto_gen()
    this.name
  }
}

object Robot {
  def main(args: Array[String]): Unit = {
    val robo = new Robot
    val name = robo.name
    println(name, robo.name)
  }
}


//  ------------------------------------------- LEGIT SOLUTION ------------------------------------------------------

//import scala.annotation.tailrec
//
//class Robot {
//  private val usednames = scala.collection.mutable.ListBuffer.empty[String]
//
//  def reset(): String = {
//    this.name = generateName()
//    this.name
//  }
//  var name = generateName()
//
//  @tailrec
//  private def generateName(): String = {
//    val r = new scala.util.Random
//    val prefix = r.shuffle(('A' to 'X').toList).take(2).mkString
//    val digits = r.shuffle((0 to 9).toList).take(3).mkString
//    val newName = prefix + digits
//    if (this.usednames contains newName)
//      this.generateName()
//    else {
//      this.usednames += newName
//      newName
//    }
//  }
//}
