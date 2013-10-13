package test.steps

import org.scalatest.matchers.ShouldMatchers
import com.escalatesoft.subcut.inject.BindingModule
import com.escalatesoft.subcut.inject.Injectable
import cucumber.api.Scenario
import cucumber.api.scala.DE
import cucumber.api.scala.ScalaDsl
import test.pages.TestDienstPage
import test.webdriver.SharedWebDriver
import test.providers.UserProvider
import test.pages.LoginFormPage
import org.hamcrest.MatcherAssert._
import test.providers.ServiceProvider

class GeneralStepDefinitions(implicit val bindingModule: BindingModule) extends ScalaDsl with Injectable with DE with ShouldMatchers {

  val driver = inject[SharedWebDriver]

  val testDienstPage = injectIfBound(new TestDienstPage)

  Before {
    s: Scenario => 
      testDienstPage.updateWebElementBindings
  }

  Angenommen("""^ein User befindet sich auf der Startseite des Test-Dienstes "([^"]*)".$""") { (serviceName: String) =>
    val service = ServiceProvider.provideService(serviceName)
    testDienstPage.openDienst(service.url, service.title)
  }
 
  Und("""^klickt auf den button "([^"]*)".$""") { (button: String) =>
    testDienstPage.clickLink(button)
  }
 
  Dann("""^wird er auf die Seite "([^"]*)" des Dienstes weitergeleitet.$""") { (title: String) =>
    testDienstPage.title should be(title)
  }

}