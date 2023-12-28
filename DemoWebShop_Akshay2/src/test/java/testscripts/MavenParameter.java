package testscripts;

import org.testng.annotations.Test;

public class MavenParameter {
	
	@Test
	public void mavenParameter()
	{
		String url = System.getProperty("Url");
		String un= System.getProperty("Un");
		System.out.println(url);
		System.out.println(un);
		//mvn -Dtest=MavenParameter test -DUrl="https:www.google.co.in" -DUn="asdfghj"
		//mvn -Dtest=className test > to execute only one class
		//mvn test -P id > profiling
		
		//@FindAll({@FindBy(id="dfgh"),@FindBy(id="fghjk")})
		//@FIndBys({@FindBy(parent),@FindBy(child)})
		
	}
}