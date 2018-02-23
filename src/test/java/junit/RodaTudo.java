package junit;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.caelum.mentoria.models.ItemDoMenuTest;

@Ignore
@SuiteClasses({JUnitTest.class, ItemDoMenuTest.class})
@RunWith(Suite.class)
public class RodaTudo {

}
