package junit;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JUnitParameterizedTest {
	@Parameter
	public int entrada;
	@Parameter(1)
	public int saida;

	@Parameters(name="{index}:Somador({0})= {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 2 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }

		});
	}

	@Test
	public void deveFuncionarOSomaUm() {
		Numero numero = new Numero(entrada);
		Assert.assertThat(numero,MeuMatcher.maisUmEh(saida));
	}

}

class MeuMatcher{
	public static Matcher<Numero> maisUmEh (int esperado){
		return new TypeSafeMatcher<Numero>() {

			@Override
			public void describeTo(Description descricao) {
				descricao.appendText("SomaUm deveria ser ").appendValue(esperado);
			}

			@Override
			protected boolean matchesSafely(Numero recebido) {
				return esperado == recebido.somaUm();
			}
			
			@Override
			protected void describeMismatchSafely(Numero item, Description mismatchDescription) {
				mismatchDescription.appendText("é ").appendValue(item.getNumero());
			}
		};
	}
}

class Numero {
	private int numero;

	public Numero(int x) {
		this.numero = x;
	}

	public int getNumero() {
		return this.numero;
	}

	public int somaUm() {
		return this.numero + 1;
	}
}
