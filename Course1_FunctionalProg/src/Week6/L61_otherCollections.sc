package Week6

object L61_otherCollections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	val xs = Array(1, 2, 3, 44)               //> xs  : Array[Int] = Array(1, 2, 3, 44)
	xs map (x => x * 2)                       //> res0: Array[Int] = Array(2, 4, 6, 88)
	
	val s = "Hello World"                     //> s  : String = Hello World
	s filter (c => c.isUpper)                 //> res1: String = HW

	val r: Range = 1 until 5                  //> r  : Range = Range 1 until 5
	val s3: Range = 1 to 5                    //> s3  : Range = Range 1 to 5
	1 to 10 by 3                              //> res2: scala.collection.immutable.Range = Range 1 to 10 by 3
	6 to 1 by -2                              //> res3: scala.collection.immutable.Range = inexact Range 6 to 1 by -2

	val pairs = List(1, 2, 3) zip s           //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
	pairs.unzip                               //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
	
	s flatMap (c => List('.', c))             //> res5: String = .H.e.l.l.o. .W.o.r.l.d
	
	def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
		(xs zip ys).map(xy => xy._1 * xy._2).sum
                                                  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
		
	// Pattern matching
	def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
		(xs zip ys).map{ case (x, y) => x * y }.sum
                                                  //> scalarProduct2: (xs: Vector[Double], ys: Vector[Double])Double
		
	
	def isPrime(n: Int): Boolean =
		(2 until n) forall (d => n%d!=0)  //> isPrime: (n: Int)Boolean

	isPrime(12)                               //> res6: Boolean = false
}