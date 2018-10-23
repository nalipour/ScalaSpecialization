package Week6

object L64_maps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V 
                                                  //| -> 5, X -> 10)
	val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)

	capitalOfCountry get "Andorra"            //> res0: Option[String] = None
	capitalOfCountry get "US"                 //> res1: Option[String] = Some(Washington)
	capitalOfCountry get "Bern"               //> res2: Option[String] = None



	def showCapital(country: String) = capitalOfCountry.get(country) match {
		case Some(capital) => capital
		case None => "missing data"
	}                                         //> showCapital: (country: String)String

	showCapital("USP")                        //> res3: String = missing data

	val fruit = List ("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
	fruit sortWith (_.length < _.length)      //> res4: List[String] = List(pear, apple, orange, pineapple)
	fruit.sorted                              //> res5: List[String] = List(apple, orange, pear, pineapple)

	fruit groupBy (_.head)                    //> res6: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))

}