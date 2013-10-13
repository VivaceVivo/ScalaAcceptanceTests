package test.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.How
import com.escalatesoft.subcut.inject.BindingModule
import com.escalatesoft.subcut.inject.Injectable
import org.openqa.selenium.support.PageFactory
import test.webdriver.SharedWebDriver

/**
 * Things, all Pages have in common
 *  
 */
abstract class Page(implicit val module: BindingModule) extends Injectable {
  println("creating NEW "+this.getClass().getSimpleName())
  
  val driver = inject[SharedWebDriver]

  @FindBy(how = How.TAG_NAME, using = "title")
  private val titleElem: WebElement = null

  def title = titleElem.getText()

  def updateWebElementBindings() = {
    PageFactory.initElements(driver, Page.this);
  }
}