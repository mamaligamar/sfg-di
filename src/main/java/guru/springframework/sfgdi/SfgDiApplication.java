package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * <p><b>Dependency injection</b> -> you have a dependency and you ask framework give you that dependency (is where a neded dependency is injected by anotger object)
 * The class being injected has o responsability in instantiating the object being injected --> you avoid declaring objects using 'new'
 * For example: when we need a datasource, we don't care about the configuratoion of that data source so it can H2, Oracle, etc --> the frmawork manage the datasource for us
 * We can inject dependencies by private properties, by setters or constructors. The latter is the preferred option</p>
 *
 * <p>Dependency injection can be done by classes or or interfaces. The preferred option is use dependency injection with interfaces
 * because it allows in runtime to decide the implementation to inject. Also it follows the interface segregation principle. </p>
 * <p>
 * DI refers much to the composition of our classes: you compose your classes with DI in mind
 * </p>
 *
 * <p>Inversion of control --> Is a technique to allow dependencies to be injected at runtime. The control is done by the frameworks of springs
 *
 * The framework is going to control most of the activity bringing up the structure.</p>
 * <p>IoC is the runtime environment of my code: Spring is in control of the injection of dependencies.</p>
 *
 * <p>Best practices:
 * <li>Favor using Constructor Injection over Setter Injection</li>
 * <li>Use final properties for injected components</li>
 * <li>Whenever practical, code to an interface</li></p>
 * */
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("-----Profiles");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("-----Primary");
		System.out.println(myController.sayHello());

		System.out.println("----Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		//We can forget to set the greeting service so we have a null pointer -- Autowire the service
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----Setter");
		SetterInjectController setterInjectController = (SetterInjectController) ctx.getBean("setterInjectController");
		System.out.println(setterInjectController.getGreeting());

		System.out.println("----Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

	/*
	Profiles -- have beings in your configuration that will take on different characteristics: like h2 for development and Orcale for production environment.
	The profiles are for this kind of situations: we can set up different runing configuration environments
	 */

}
