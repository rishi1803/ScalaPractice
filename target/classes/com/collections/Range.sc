val subjects = List("Noel", "The cat", "The dog")
val verbs = List("wrote", "chased", "slept on")
val objects = List("the book", "the ball", "the bed")

def allSentences: List[(String, String, String)] =
  for {
    subject <- subjects
    verb <- verbs
    obj <- objects
  } //println(s"${subject} ${verb} ${obj}")
    yield (subject, verb, obj)
println(allSentences)
