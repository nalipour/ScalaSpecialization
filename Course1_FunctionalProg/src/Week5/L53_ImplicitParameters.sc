package Week5

object L53_ImplicitParameters {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	// Generalised merge sort
	def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
				case (Nil, ys) => ys
				case (xs, Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (lt(x, y)) x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
			}
			
			val (fst, snd) = xs splitAt n
			merge(msort(fst)(lt), msort(snd)(lt))
		}
	}                                         //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]

	val nums = List(2, -4, 5, 7, 1)           //> nums  : List[Int] = List(2, -4, 5, 7, 1)
	var fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
	msort(nums)((x: Int, y: Int) => x < y)    //> res0: List[Int] = List(-4, 1, 2, 5, 7)
	msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res1: List[String] = List(apple, banana, orange, pineapple)

}