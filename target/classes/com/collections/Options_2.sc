
val people = Set(
  "Alice",
  "Bob",
  "Charlie",
  "Derek",
  "Edith",
  "Fred")

val ages = Map(
  "Alice" -> 20,
  "Bob" -> 30,
  "Charlie" -> 50,
  "Derek" -> 40,
  "Edith" -> 10,
  "Fred" -> 60)

val favoriteColors = Map(
  "Bob" -> "green",
  "Derek" -> "magenta",
  "Fred" -> "yellow")

val favoriteLolcats = Map(
  "Alice" -> "Long Cat",
  "Charlie" -> "Ceiling Cat",
  "Edith" -> "Cloud Cat")

def favouriteColour(name: String): String = {
  favoriteColors(name)
}

favoriteColors("Bob")

def favouriteColourOrDefault(name: String): String = {
  favoriteColors.getOrElse(name,"beige")
}

favouriteColourOrDefault("Bob")
favouriteColourOrDefault("Rishabh")

def printColours  = {
  favoriteColors.values
}

printColours

def lookup[A](name: String, map:Map[String,A] ) = {
  map get name
}

lookup("Alice",favoriteLolcats)

val oldest =
  people.foldLeft(Option.empty[String]) { (older,person) =>
    if(ages.getOrElse(person,0) > older.flatMap(ages.get).getOrElse(0)) {
      Some(person)
    } else {
      older
    }
  }

val favourite: Option[String] = {
  for {
    oldest <- oldest
    color <- favoriteColors.get(oldest)
  } yield color
}

//Option.empty[String].flatMap(ages.get).getOrElse(0)
//List(1,2,3).flatMap(ages.get)
//Some("A").flatMap(ages.get).getOrElse(0)
//val abc = people.flatMap(ages.get)

val people1 = Set(
  "Alice",
  "Bob",
  "Charlie",
  "Derek",
  "Edith",
  "Fred")

val people2 = Set(
  "A",
  "B",
  "C",
  "D",
  "E",
  "F")

def uni[A](set1: Set[A],set2: Set[A]):Set[A] = {
  set1.foldLeft(set2)((init, value) =>
  init + value)
}

uni(people1,people2)