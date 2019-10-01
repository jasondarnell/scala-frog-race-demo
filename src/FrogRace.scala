
import scala.util.control.Breaks._

case object FrogRace {

  val raceDistance = 100
  var frogs = List[Frog]()
  var threads = List[Thread]()


  def leftPad(str:String,
              paddedLength:Int,
              ch:Char =' ') : String = {
    var remLength = paddedLength - str.length;

    if (remLength <= 0) {
      return str;
    }

    val builder = StringBuilder.newBuilder

    for( a <- 0 until remLength){
      builder.append(ch);
    }

    builder.append(str);

    return builder.toString();
  }

  def race(): Unit ={

    println("\nBeginning frog race....\n")

    for (frog <- frogs){
      println("\t" + frog.name + " (strength = " + frog.strength + ")");
    }

    println("\n")
    for (frog <- frogs){
      val thread = new Thread {
        override def run: Unit = {
          frog.doRace(raceDistance)
        }
      }
      thread.start()
      threads.::(thread)
    }

    breakable { while(true) {

      println("\n------------------------------------------------------------------------------------------------------------------------------")
      for (frog <- frogs){
        //println("\t" + frog.name + " (distance = " + frog.distance + ")");

        //var spaces  = " " * Math.round((frog.distance/raceDistance) * 100)
        //val spaces = List.fill(Math.round((frog.distance/raceDistance) * 100))(' ').mkString
        val numSpacesLeft = Math.min(Math.round((frog.distance/raceDistance) * 100).toInt, 100)
        val numSpacesRight = Math.max(100 - numSpacesLeft, 0)
        val spacesLeft = 0 to numSpacesLeft map (_=> " ") reduce(_+_)
        val spacesRight = 0 to numSpacesRight map (_=> " ") reduce(_+_)

        val name = leftPad(frog.name, 15)
        println(name + ":" + spacesLeft + "=>" + spacesRight + "|")

        frog.name
        if(frog.distance > raceDistance){
          println("\n WINNER - " + frog.name)
          break
        }
      }

      Thread.sleep(1000)
    } }


    // join threads here...


    print("\nDone!")
  }

}
