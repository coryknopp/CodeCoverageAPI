import org.junit.Test;
import static org.junit.Assert.*;

import analyzer.*;

public class CoverageAnalyzerTests {

	String serFilepath = "../../cobertura.ser";

	@Test
	public void testConstructor() {
		CoverageAnalyzer analyzer = new CoverageAnalyzer(serFilepath);
	}

}