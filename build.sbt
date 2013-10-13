name := "scrowdlectorAcceptanceTests"

// https://groups.google.com/forum/#!topic/simple-build-tool/Sq-9YJE7Wbg

version := "0.0.7"

organization := "scala-hamburg"

scalaVersion := "2.10.0"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies ++= Seq(
	"junit" % "junit" % "4.11" % "test",
	"info.cukes" % "cucumber-core" % "1.1.6-SNAPSHOT" % "test",
	"info.cukes" % "cucumber-junit" % "1.1.6-SNAPSHOT" % "test",
	"info.cukes" %% "cucumber-scala" % "1.1.6-SNAPSHOT" ,
	"info.cukes" %% "cucumber-subcut" % "1.1.6-SNAPSHOT" ,
	"org.scalatest" %% "scalatest" % "1.9.1" % "test",
	"org.seleniumhq.selenium" % "selenium-java" % "2.32.0" % "test",
	"com.escalatesoft.subcut" %% "subcut" % "2.0",
	"com.novocode" % "junit-interface" % "0.10" % "test"
)

//seq(cucumberSettingsWithTestPhaseIntegration : _*)

//parallelExecution in ThisBuild := false

//parallelExecution in IntegrationTest := false

//parallelExecution in Global := false 

//cucumberStepsBasePackage := "test"

//cucumberHtmlReport := true

//cucumberJunitReport := true 

//	cucumberJsonReport := true
