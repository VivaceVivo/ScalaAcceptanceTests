package test.pages

import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import test.webdriver.SharedWebDriver
import org.hamcrest.CoreMatchers.is
import org.hamcrest.MatcherAssert.assertThat
import org.openqa.selenium.WebElement
import javax.annotation.PostConstruct
import org.openqa.selenium.support.PageFactory
import com.escalatesoft.subcut.inject.BindingModule
import com.escalatesoft.subcut.inject.Injectable
import cucumber.api.scala.ScalaDsl
import cucumber.api.Scenario

class LoginFormPage(implicit val bindingModule: BindingModule) extends Page with Injectable  {

  @FindBy(how = How.ID, using = "username")
  val username: WebElement = null

  @FindBy(how = How.ID, using = "password")
  val password: WebElement = null

  @FindBy(how = How.ID, using = "login-large")
  val submitButton: WebElement = null

}