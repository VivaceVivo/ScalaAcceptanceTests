package test.providers

object UserProvider {

  val users = Map {
    ("Alice" -> Credentials("Alice", "secret"))
    ("Bob" -> Credentials("test@test.de", "123456"))
  }.withDefaultValue(Credentials("",""))

  def provideUser(name: String): Credentials = {
    users(name)
  }
}

case class Credentials(val name: String, val password: String)