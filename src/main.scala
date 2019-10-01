case object main extends App{


  val frogRace = FrogRace

  print("How many frogs? ")
  val numFrogs = scala.io.StdIn.readInt()

  for (i <- 1 to numFrogs){
    val frogName = scala.io.StdIn.readLine("Frog name? " + "(" + i + ") ")
    println("Frog strength? " + "(" + i + ") ")
    val frogStrength = scala.io.StdIn.readFloat()
    val newFrog = Frog(frogName, frogStrength)

    frogRace.frogs = frogRace.frogs :+ newFrog
  }

  frogRace.race()
}
