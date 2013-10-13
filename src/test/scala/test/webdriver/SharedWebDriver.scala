package test.webdriver

import org.openqa.selenium.support.events.EventFiringWebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import java.util.concurrent.TimeUnit
import cucumber.api.Scenario
import org.openqa.selenium.OutputType
import java.net.URI
import org.openqa.selenium.remote.UnreachableBrowserException
import cucumber.api.scala.ScalaDsl
import org.openqa.selenium.NoSuchWindowException
import org.openqa.selenium.WebDriver

class SharedWebDriver(webdriver:WebDriver) extends EventFiringWebDriver(webdriver) {
  println("creating SharedWebDriver")

  manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS)

  def mkScreenshot(result: Scenario): Unit = {
    try {
      result.embed(getScreenshotAs(OutputType.BYTES), "image/png")
    } catch {
      case x: UnreachableBrowserException => println("Your Browser died...")
    }
  }

  def getCurrentPath(): String = {
    new URI(this.getCurrentUrl()).getPath();
  }

  override def close() = {
    try {
      super.close()
    } catch {
      case x: UnreachableBrowserException => println("Browser was already closed!")
      case x: NoSuchWindowException => println("Window was already closed!")
    }
  }
}