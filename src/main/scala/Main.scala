trait HumanComps {

  def timeDifference(): Int

  def now(): Boolean = timeDifference() == 0

  def aboutNow(): Boolean = timeDifference() < 9

  def momentAgo(): Boolean = timeDifference() < 26

  def earlier(): Boolean = timeDifference() < 100

  def later(): Boolean = timeDifference() >= 100

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
    if earlier() then {
      return "earlier"
    }
    if later() then {
      return "later"
    }

    "unkown"
  }

}

class TDist(val t: Int) {
  def timeDifference() = t - 0
}

case class H(val d: Int) extends TDist(d) with HumanComps {}

case class TPeriod(val start: Int, val stop: Int) {
  def timeDifference() = stop - start
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
