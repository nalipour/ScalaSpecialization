package Week5

object L54_HigherOrderListFunctions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
		case Nil => xs
		case y :: ys => y * factor :: scaleList(ys, factor)
	}                                         //> scaleList: (xs: List[Double], factor: Double)List[Double]
	
	// Map
	def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  val l = List(1, 2, 3, 4)                        //> l  : List[Int] = List(1, 2, 3, 4)
  squareList(l)                                   //> res0: List[Int] = List(1, 4, 9, 16)
  
  def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x * x)                             //> squareList2: (xs: List[Int])List[Int]
  
  def posElems(xs: List[Int]): List[Int] = xs match {
  		case Nil => xs
  		case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
  }                                               //> posElems: (xs: List[Int])List[Int]
  
  
}