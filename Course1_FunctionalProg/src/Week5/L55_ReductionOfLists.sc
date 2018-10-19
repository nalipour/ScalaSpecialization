package Week5

object L55_ReductionOfLists {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	def sum (xs: List[Int]) = (0 :: xs) reduceLeft ((x, y) => x+y)
                                                  //> sum: (xs: List[Int])Int
	def product (xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> product: (xs: List[Int])Int
	
	sum(List(1, 3, 4))                        //> res0: Int = 8

	

}