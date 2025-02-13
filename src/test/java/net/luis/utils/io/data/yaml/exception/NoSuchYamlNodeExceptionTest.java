package net.luis.utils.io.data.yaml.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link NoSuchYamlNodeException}.<br>
 *
 * @author Luis-St
 */
class NoSuchYamlNodeExceptionTest {
	
	@Test
	void constructor() {
		assertDoesNotThrow(() -> new NoSuchYamlNodeException((String) null));
		assertDoesNotThrow(() -> new NoSuchYamlNodeException((Throwable) null));
		assertDoesNotThrow(() -> new NoSuchYamlNodeException(null, null));
	}
}
