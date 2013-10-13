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

class LoginStepDefinitions(implicit val bindingModule: BindingModule) extends ScalaDsl with Injectable with DE with ShouldMatchers {

  val driver = inject[SharedWebDriver]

  val loginFormPage = injectIfBound(new LoginFormPage)

  Before {
    s: Scenario => 
      loginFormPage.updateWebElementBindings
  }
 
  Dann("""^öffnet sich das Loginformular "([^"]*)".$""") { (title: String) =>
  	loginFormPage.title should be(title) 
  }
  
  Wenn("""^der User "([^"]*)" seine Credentials eingibt und das Formular absendet.$"""){ (name:String) =>
  	val credentials = UserProvider.provideUser(name)
  	loginFormPage.username.sendKeys(credentials.name)
  	loginFormPage.password.sendKeys(credentials.password)
  	loginFormPage.submitButton.click()
  }
  
  Angenommen("""^irgendwas$""") { () =>
    //// Express the Regexp above with the code you wish you had
  }

}