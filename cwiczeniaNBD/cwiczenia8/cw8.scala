object cw8 {
  def main(args: Array[String]): Unit = {
    println("zadanie 1:");
    println(verifyDaysPatternMatching("Wtorek"));
    println(verifyDaysPatternMatching("Sobota"));
    println(verifyDaysPatternMatching("PoPoniedzialek"));
    println()

    println("zadanie 2:");
    val konto1 = new KontoBankowe();
    val konto2 = new KontoBankowe(1000);
    konto1.wyplata(100);
    konto2.wyplata(100);
    konto1.wplata(10);
    println("stan konta to: "+konto1.stanKonta);
    println()

    println("zadanie 3");
    val osoba1 = new Osoba("Maciej", "Chrescionko")
    val osoba2 = new Osoba("Jan", "Kowalski")
    val osoba3 = new Osoba("Robert", "Nowak")
    val osoba4 = new Osoba("Gal", "Anonim")
    println(powitanie(osoba1))
    println(powitanie(osoba2))
    println(powitanie(osoba3))
    println(powitanie(osoba4))
    println()

    println("zadanie 4:")
    println(pierwszaFunkcja(1, drugaFunkcja))
    println()

    println("zadanie 5:")
    val osoba5 = new NOsoba("Maciej", "Chrescionko") with Student
    val osoba6 = new NOsoba("Jan", "Kowalski") with Pracownik
    osoba6.pensjaP = 100
    val osoba7 = new NOsoba("Robert", "Nowak") with Nauczyciel
    osoba7.pensjaP = 100
    val osoba9 = new NOsoba("Jan", "Kowalski") with Student with Pracownik
    val osoba8 = new NOsoba("Maciej", "Chrescionko") with Pracownik with Student
    osoba9.pensjaP = 100
    osoba8.pensjaP = 100
    println(osoba5.podatek)
    println(osoba6.podatek)
    println(osoba7.podatek)
    println(osoba9.podatek)
    println(osoba8.podatek)










  }

  def pierwszaFunkcja(liczba: Int, funkcja: Int => Int ) = {
    funkcja(funkcja(funkcja(liczba)))
  }
  def drugaFunkcja(liczba:Int):Int ={
    liczba*2;
  }

  def powitanie(osoba: Osoba):String = osoba.imie match {
    case "Maciej" => "Cześć"
    case "Jan" => "Hej"
    case "Robert" => "witaj"
    case _ => "witaj nieznajomy"
  }


  def verifyDaysPatternMatching(day: String):String = day match{
    case "Poniedzialek" | "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }
  class KontoBankowe () {
    private var _stanKonta = 0;

    def this(kwota: Int){
      this()
      this._stanKonta = kwota;
    }

    def stanKonta = {
      this._stanKonta
    }

    def wplata(kwota: Int)  = {
      this._stanKonta += kwota
      println("wplacono " + kwota);
    }

    def wyplata(kwota: Int) = {
      if (this._stanKonta >=kwota) {
        this._stanKonta -= kwota
        println("wyplacono " + kwota)
      }
      else
        println("Na koncie nie ma tylu pieniedzy")
    }


  }

  class Osoba (var imie:String, var nazwisko:String)

  abstract class NOsoba(val name: String, val surname: String){
    def podatek: Double
  }

  trait Student extends NOsoba {
    override def podatek = 0.0
  }

  trait Pracownik extends NOsoba {
    private var pensja = 0.0
    def pensjaP = pensja
    def pensjaP_=(value: Double): Unit = pensja = value
    override def podatek = pensja * 0.2
  }

  trait Nauczyciel extends Pracownik {
    override def podatek = pensjaP * 0.1
  }



}
