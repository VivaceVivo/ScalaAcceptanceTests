package test.injection

import com.escalatesoft.subcut.inject.NewBindingModule
import com.gargoylesoftware.htmlunit.WebClient
import test.webdriver.SharedWebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

object SubCutConfigurationModule extends NewBindingModule(module => {
  import module._

  println("SubCutConfigurationModule instantiated")

  bind[SharedWebDriver] toSingle new SharedWebDriver(new FirefoxDriver(new FirefoxProfile()))
}) 


//  bind[WebClient] toProvider { println("providing new WebClient"); WebClientProvider.provide() }
//else {
//    }
//    all.filter(res => res.isDefined).map(_.get)
//  }
//
//  def string2Class[T <: AnyRef](name: String)(implicit classLoader: ClassLoader): Class[T] = {
//    val clazz = Class.forName(name, true, classLoader)
//    clazz.asInstanceOf[Class[T]]
//  }
//
//  def bindIt[T <: PageFeature](typ: Class[T], module: MutableBindingModule)(implicit manifest: Manifest[T]): BindingModule = {
//
//    val mirror = ru.runtimeMirror(getClass.getClassLoader)
//    val clsSym = mirror.classSymbol(typ)
//    val clsReflect = mirror.reflectClass(clsSym)
//    val constructor = clsSym.selfType.declaration(ru.nme.CONSTRUCTOR).asMethod
//    val constrReflect = clsReflect.reflectConstructor(constructor)
//    val result = constrReflect(module).asInstanceOf[T]
//    println("Binding " + typ.getSimpleName() + " to " + result.getClass.getName())
//
////    ru.stringToTypeName(typ.getName())
//    val moduleX = new NewBindingModule(module => {
//
//      module.bind[T] toSingle result
//    })
//    moduleX.listBindings.foreach(s => println("Binding: " + s))
//    moduleX
//  }