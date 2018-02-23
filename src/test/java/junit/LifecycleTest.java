package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifecycleTest {
	
	@Test
	public void teste() {
		System.out.println("Teste");
	}
	
	@Test
	public void testeDois() {
		System.out.println("Teste 2");
	}
	
	@Before
	public void antes() {
		System.out.println("antes do teste");
	}
	
	@After
	public void depois() {
		System.out.println("depois do teste");
	}
	
	@BeforeClass
	public static void antesDeTodos() {
		System.out.println("Antes de todos");
	}
	
	@AfterClass
	public static void depoisDeTodos() {
		System.out.println("Depois de todos");
	}

}
