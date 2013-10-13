package test.providers

object ServiceProvider {
  val services = Map {
    ("testdienst-dev" -> Service("It works not!", "It works"))
  }.withDefaultValue(Service("", ""))

  def provideService(name: String): Service = {
    services(name)
  }
}

case class Service(val url: String, val title: String)