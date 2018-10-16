package Week5

object L52_pairs_tuples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
				case Nil => ys
				case x :: xs1 => ys match {
					case Nil => xs
					case y :: ys1 => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
				}
			}
			val (fst, snd) = xs splitAt n
			merge(msort(fst), msort(snd))
		}
	}                                         //> msort: (xs: List[Int])List[Int]

	// implementation of merge using tuples (more elegant)
	def merge_2(xs: List[Int], ys: List[Int]): List[Int] =
	  (xs, ys) match {
	    case (Nil, ys) => ys
	    case (xs, Nil) => xs
	    case (x :: xs1, y:: ys1) =>
	    		if (x < y) x :: merge_2(xs1, ys)
	    		else y :: merge_2(xs, ys1)
	  }                                       //> merge_2: (xs: List[Int], ys: List[Int])List[Int]
}