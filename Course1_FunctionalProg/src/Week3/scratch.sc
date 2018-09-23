
object scratch {
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
  
  val x = null                                    //> x  : Null = null
  val y: String = x                               //> y  : String = null
  
  // val z: Int = null // This does not work
  
  if (true) 1 else false                          //> res0: AnyVal = 1
}