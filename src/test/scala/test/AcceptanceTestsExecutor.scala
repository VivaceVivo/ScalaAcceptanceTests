package test

import org.junit.runner.RunWith
import cucumber.api.junit.Cucumber;

@RunWith(classOf[Cucumber])
@Cucumber.Options(
		glue=Array("test"),
		features = Array("classpath:features/my/"),
		strict = true,
//		tags = "@Now",
		format = Array("html:target/cucumber") )
class AcceptanceTestsExecutor {
}
