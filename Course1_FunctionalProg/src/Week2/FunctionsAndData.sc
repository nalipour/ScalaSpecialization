package Week2

object FunctionsAndData {

  val a = new Rational(1, 2)                      //> a  : Week2.Rational = 1/2
  a.numer                                         //> res0: Int = 1
  a.denom                                         //> res1: Int = 2

  val b = new Rational(2, 3)                      //> b  : Week2.Rational = 2/3
  a.add(b)                                        //> res2: Week2.Rational = 7/6

  val x = new Rational(1, 3)                      //> x  : Week2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Week2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Week2.Rational = 3/2
  x.sub(y).sub(z)                                 //> res3: Week2.Rational = -79/42
  y.add(y)                                        //> res4: Week2.Rational = 10/7
  x.less(y)                                       //> res5: Boolean = true
  x.max(y)                                        //> res6: Week2.Rational = 5/7

  //val strange = new Rational(1, 0)
  //strange.add(strange)

  new Rational(2)                                 //> res7: Week2.Rational = 2/1
}

class Rational(x: Int, y: Int) {

  require(y != 0, "denominator must be nonzero")

  // Different constructor
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  //private val g = gcd(x, y)
  def numer = x // / g
  def denom = y // / g

  def less(that: Rational) = numer * that.denom < that.numer * denom
	//def < (that: Rational) = numer * that.denom < that.numer * denom
	
  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom, denom * that.denom)

  def neg: Rational = new Rational(-numer, denom)
  def sub(that: Rational) = add(that.neg)

  override def toString = {
  		val g = gcd(numer, denom)
    numer/g + "/" + denom/g
  }
}