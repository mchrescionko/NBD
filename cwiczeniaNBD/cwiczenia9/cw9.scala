object cw9 {
  def main(args: Array[String]): Unit = {
    println("zadanie 1:")
    val container = new Container[String]("pierwszy kontener")
    println("nazwa: " +container.getContent)
    println("dlugosc nazwy: "+container.applyFunction(funkcja))
    println()

    println("zadanie 2:")
    val no = new No;
    println("podtyp Maybe[_]: "+no.isInstanceOf[Maybe[_]])
    val yes = new Yes[Int](5)
    println("podtyp Maybe[_]: "+yes.isInstanceOf[Maybe[_]])

    println("zadanie 3:")
    println("no.applyfunction: "+no.applyFunction(5))
    println("yes.applyfunction: "+yes.applyFunction[Int](x=>x))
    println()

    println("zadanie 4:")
    println("no.getOrElse: "+no.getOrElse("ft"))
    println("yes.getOrElse: "+yes.getOrElse[String]("sth"))
    println()


  }
  def funkcja(string: String):Int={
    string.length
  }
  class Container[A](private val a : A){

    def getContent:A={
      a
    }

    def applyFunction[R](function: A=>R):R={
      function(a)
    }
  }

  trait Maybe[A]{
  }

  class No extends Maybe[Nothing]{
    def applyFunction(int: Int):No={
      this
    }
    def getOrElse[A](getOrElse: A): A ={
      getOrElse
    }
  }

  class Yes[A](val _a:A) extends Maybe[A]{
    val a:A = _a;
    def applyFunction[R](f: A => R):Yes[R]={
      val yes = new Yes[R](f(a))
      return yes
    }
    def getOrElse[R](getOrElse: R): A ={
      a
    }
  }


}
