import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object cw7 {
  def main(args: Array[String]) = {
    val week = List(
      "poniedzialek", "wtorek", "sroda", "czawartek", "piatek", "sobota", "niedziela"
    )
    val products = Map("Chleb" -> 5.00, "Bułka" -> 2.00, "Ciasto" -> 20.00, "Pizza" -> 25.00, "Tort" -> 60.00)

    val numbers = List[Int](1,2,3,0,1,2,3,0,2,3,1)

    val numbersDouble = List[Double](-10.0, -20.0, 0.0, 24.0, 4.0, 44.0)

    println("Zadanie 1a: ")
    println(withFor(week))
    println("Zadanie 1b: ")
    println(withForStartsWithP(week))
    println("Zadanie 1c: ")
    println(withWhile(week))
    println("Zadanie 2a: ")
    println(rek(week))
    println("Zadanie 2b: ")
    println(rekBackwards(week))
    println("Zadanie 3: ")
    println(rekTail(week))
    println("Zadanie 4a: ")
    println(foldL(week))
    println("Zadanie 4b: ")
    println(foldR(week))
    println("Zadanie 4c: ")
    println(foldLStartsWithR(week))
    println("Zadanie 5: ")
    println(discount(products))
    println("Zadanie 6: ")
    println(defineTuple("Raz", 2.0, 3))
    println("Zadanie 7: ")
    println(findKEy(products.get("Chleb")))
    println("Zadanie 8: ")
    println(find0(numbers))
    println("Zadanie 9: ")
    println(newList(numbers))
    println("Zadanie 10: ")
    println(newListFromMinus5to12ABS(numbersDouble))

  }

  def withFor(days: List[String]): String = {

    var result = days.head
    for (i <- 1 until days.length)
      result += ("," + days(i))

    return result

  }

  def withForStartsWithP(days: List[String]): String = {

    var withP = new ListBuffer[String]()

    for (i <- days.indices)
      if (days(i).toLowerCase().startsWith("p"))
        withP += days(i)

    return withFor(withP.toList)

  }

  def withWhile(days: List[String]): String = {
    var result = "";
    var i = 0;
    while (i < days.length) {
      if (i == 0) {
        result = result + days(i);
      } else {
        result = result + "," + days(i);
      }
      i = i + 1;
    }
    return result;
  }

  def rek(dni: List[String]): String = {
    if (dni.length == 1) {
      return dni.head
    };
    return dni.head + "," + rek(dni.tail);
  }

  def rekBackwards(dni: List[String]): String = {
    if (dni.length == 1) {
      return dni.head
    };
    rekBackwards(dni.tail) + "," + dni.head
  }

  def rekTail(dni: List[String]): String = {
    @tailrec
    def iter(days: List[String], result: String): String =
      if (days.isEmpty) {
        result
      };
      else iter(days.tail, result + "," + days.head);
    iter(dni.tail, dni.head);
  }

  def foldL(days: List[String]): String = {
    days.foldLeft("")(_ + _ + ", ").dropRight(2)
  }

  def foldR(days: List[String]): String = {
    days.foldRight("")(_ + ", " + _).dropRight(2)
  }

  def foldLStartsWithR(days: List[String]): String = {

    days.foldLeft("") { (rest, day) => {
      if (day.startsWith("p")) rest + day + ", " else rest
    }
    }.dropRight(2)
  }

  def discount(products: Map[String, Double]): Map[String, Double] = {
    products.map(product => (product._1, (product._2) * 0.9))
  }

  def defineTuple(tuple: (String, Double, Int)) = {
    tuple
  }

  def findKEy(option: Option[Double]) = option match {
    case Some(x) => x
    case None => "not in this map"
  }

  @tailrec
  def find0(numbers: List[Int], rest: List[Int] = List.empty[Int]): List[Int] = {
    numbers match {
      case Nil => rest
      case 0 :: tail  => find0(tail, rest)
      case head :: tail => find0(tail, rest :+ head)
    }
  }

  def newList(oldList: List[Int]) : List[Int] = {
    oldList.map((x) => (x + 1))
  }

  def newListFromMinus5to12ABS(oldList: List[Double]) : List[Double] = {
   oldList.filter(x =>(x >= -5)).filter(x =>(x <= 12)).map((x) => (x.abs))
  }





}
