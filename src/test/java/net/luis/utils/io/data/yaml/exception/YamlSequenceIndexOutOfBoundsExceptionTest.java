package net.luis.utils.io.data.yaml.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link YamlSequenceIndexOutOfBoundsException}.<br>
 *
 * @author Luis-St
 */
class YamlSequenceIndexOutOfBoundsExceptionTest {
	
	@Test
	void constructor() {
		assertDoesNotThrow(() -> new YamlSequenceIndexOutOfBoundsException((String) null));
	}
}
