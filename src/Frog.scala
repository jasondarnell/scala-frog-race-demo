
case class Frog(name:String, strength:Float, quickness: Float){

  val K = 10
  val rnd = new scala.util.Random()
  var distance = 0.0

  def jump(): Unit ={
    val jumpDist = rnd.between(0.0, strength) * K
    distance = distance + jumpDist
  }

  def doRace(raceDistance: Int): Unit ={
    while(distance<raceDistance){
      jump()
      val delay = (1250 * (1-rnd.between(0,quickness))).toInt
      Thread.sleep(delay)
    }
  }

}
