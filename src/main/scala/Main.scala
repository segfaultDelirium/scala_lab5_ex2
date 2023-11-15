trait HumanComps {

  def now(): Boolean
  def aboutNow(): Boolean
  def momentAgo(): Boolean
  // def earlier(): Boolean
  // def later(): Boolean
  def human: String = {
    if now() then {
      return "now"
    }
    if aboutNow() then {
      return "about now"
    }
    if momentAgo() then {
      return "a moment ago"
    }
    // if earlier() then {
    //   return "earlier"
    // }
    // if later() then {
    //   return "later"
    // }

    "unkown"
  }

}

class TDist(val t: Int) {
  def now(): Boolean = {
    t == 0
  }
  def aboutNow(): Boolean = {
    t < 9
  }
  def momentAgo(): Boolean = {
    t < 26
  }

}

case class H(val d: Int) extends TDist(d) with HumanComps {
  // def now() = {
  //   d == 0
  // }

  // def aboutNow(): Boolean = {
  //   d.abs < 9
  // }

  // def momentAgo(): Boolean = {
  //   d < 26
  // }
}

case class TPeriod(val start: Int, val stop: Int) {

  // def difference = stop - start
  def tDist = TDist(stop - start)
  def now() = {
    // TDist(difference).now()
    tDist.now()
  }

  def aboutNow(): Boolean = {
    // TDist(difference).aboutNow()
    tDist.aboutNow()
  }

  def momentAgo(): Boolean = {
    // TDist.momentAgo(stop - start)
    tDist.momentAgo()
  }
}

@main def hello: Unit = {
  val x = new H(0)
  println(x.human)
  val y = new H(8)
  println(y.human)
  val z = new H(15)
  println(z.human)
  println(s"${z.now()} ${z.aboutNow()} ${z.momentAgo()}")

  println()
  val h1 = new TPeriod(100, 120) with HumanComps
  println(h1.human)
}
