package Week2

object Currying {

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

	def cube (x: Int): Int = x*x*x            //> cube: (x: Int)Int
	
	sum(cube)(0, 2)                           //> res0: Int = 9


	// A product
  def product(f: Int => Int)(a: Int, b: Int): Int = {
      if (a > b) 1
      else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int

	product(x => x * x)(3, 4)                 //> res1: Int = 144
	
	// Factorial in terms of product
	def fact(n: Int) = product(x=>x)(1, n)    //> fact: (n: Int)Int
	fact(3)                                   //> res2: Int = 6

  // A generalised function for product and sum
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  product2(x => x * x)(3, 4)                      //> res3: Int = 144
}