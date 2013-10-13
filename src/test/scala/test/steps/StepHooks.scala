package test.steps

import com.escalatesoft.subcut.inject.BindingModule
import cucumber.api.scala.ScalaDsl
import com.escalatesoft.subcut.inject.Injectable
import cucumber.api.Scenario
import test.webdriver.SharedWebDriver

class StepHooks(implicit val bindingModule: BindingModule) extends ScalaDsl with Injectable {

  val driver = inject[SharedWebDriver]

  After {
    s: Scenario =>
      driver.mkScreenshot(s)
      println("driver.close")
      driver.close()
  }
  
}

