package Week6

object L63 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val s = (1 to 6).toSet                          //> s  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
  // Remove duplicates
  s map (_/2)                                     //> res0: scala.collection.immutable.Set[Int] = Set(0, 1, 2, 3)
  s contains 5                                    //> res1: Boolean = true


	def isSafe(col: Int, queens: List[Int]): Boolean = {
		val row = queens.length
		val queensWithRow = (row - 1 to 0 by -1) zip queens
		queensWithRow forall {
			case (r, c) => col != c && math.abs(col - c) != row - r
		}
	}                                         //> isSafe: (col: Int, queens: List[Int])Boolean

	def queens(n: Int): Set[List[Int]] = {
		def placeQueens(k: Int): Set[List[Int]] =
			if (k == 0) Set(List())
			else
				for {
					queens <- placeQueens(k-1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col::queens
			
		placeQueens(n)
	}                                         //> queens: (n: Int)Set[List[Int]]


	queens(4)                                 //> res2: Set[List[Int]] = Set(List(2, 0, 3, 1), List(1, 3, 0, 2))


	def show(queens: List[Int]) = {
		val lines =
			for (col <- queens.reverse)
			yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
		"\n" + (lines mkString "\n")
	}                                         //> show: (queens: List[Int])String
	
	queens(4) map show                        //> res3: scala.collection.immutable.Set[String] = Set("
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * ", "
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * ")

	(queens(4) map show) mkString "\n"        //> res4: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "

}