package Week4

object exprs {
	def show(e: Expr): String = e match {
		case Number(x) => x.toString
		case Sum(l, r) => show(l) + " + " + show(r)
		//case Var(x) => x
		//case Prod(l, r) => show(l) + " * " + show(r)
		
	}                                         //> show: (e: Week4.Expr)String
	
	show(Sum(Number(1), Number(44)))          //> res0: String = 1 + 44
	//show(Sum(Prod(2, Var("x")), Var("y")))
}