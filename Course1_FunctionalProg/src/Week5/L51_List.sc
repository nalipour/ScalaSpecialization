package Week5

object L51_List {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def last[T](xs: List[T]): T = xs match {
		case List() => throw new Error("last of empty list")
		case	 List(x) => x
		case y :: ys => last(ys)
}                                                 //> last: [T](xs: List[T])T

  def init[T](xs: List[T]): List[T] = xs match {
  		case List() => throw new Error ("init of empty list")
  		case List(x) => List()
  		case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  val l = List(1, 2, 3, 4)                        //> l  : List[Int] = List(1, 2, 3, 4)
  last(l)                                         //> res0: Int = 4
  init(l)                                         //> res1: List[Int] = List(1, 2, 3)
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  		case List() => ys
  		case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  def reverse[T](xs: List[T]): List[T] = xs match {
  		case List() => xs
  		case y :: ys => reverse (ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]

	def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
	removeAt(1, List('a', 'b', 'c', 'd'))     //> res2: List[Char] = List(a, c, d)

	def flatten(xs: List[Any]): List[Any] = xs match {
		case List() => xs
		case (y: List[Any]) :: ys => flatten(y) ::: flatten(ys)
		case y :: ys => y :: flatten(ys)
	}                                         //> flatten: (xs: List[Any])List[Any]

	flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res3: List[Any] = List(1, 1, 2, 3, 5, 8)
}