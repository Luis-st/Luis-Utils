package net.luis.utils.io.data.yaml.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link YamlTypeException}.<br>
 *
 * @author Luis-St
 */
class YamlTypeExceptionTest {
	
	@Test
	void constructor() {
		assertDoesNotThrow(() -> new YamlTypeException((String) null));
		assertDoesNotThrow(() -> new YamlTypeException((Throwable) null));
		assertDoesNotThrow(() -> new YamlTypeException(null, null));
	}
}
