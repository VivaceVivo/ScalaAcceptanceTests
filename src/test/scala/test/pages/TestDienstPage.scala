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
import org.openqa.selenium.By
import scala.collection.JavaConversions._
import java.util.{List=>JList}
import org.scalatest.matchers.ShouldMatchers

class TestDienstPage(implicit val bindingModule: BindingModule) extends Page with Injectable with ShouldMatchers  {

  @FindBy(how = How.CLASS_NAME, using = "btn-submit")
  val links: JList[WebElement] = null

  def openDienst(url: String, expectedTitle: String) = { 
    driver.get(url);
    title should be(expectedTitle)
  }

  def clickLink(name:String) = {
    links.find(elem => elem.getAttribute("value")==name).map(_.click())
  }
}