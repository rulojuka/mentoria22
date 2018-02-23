package junit;

import java.util.concurrent.CountDownLatch;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.caelum.mentoria.models.ItemDoMenuTest;

public class JUnitTest {
	
	@Rule
	public Timeout timeoutDeCemMilis = Timeout.millis(1000);
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	public CountDownLatch latch = new CountDownLatch(1);
	
	@Test(timeout=1000)
	public void deveRodarEmMenosDeUmSegundo() throws InterruptedException {
		Thread.sleep(500);
		latch.countDown();
	}
	

	@Test(expected=Exception.class)
	public void deveLancarUmaExcecao() {
		throw new RuntimeException();
	}

	
	@Test
	public void deveLancarUmaExcecaoComTexto() {
		exception.expect(Exception.class);
		exception.expectMessage("Deu ruim");
		
		throw new RuntimeException("Deu ruim pra caramba");
	}
	
	
	//@Test
	//public void devePassarApenasDepoisDeUmOutroTestePassar() throws InterruptedException {
		//latch.await();
	//}
	

}
