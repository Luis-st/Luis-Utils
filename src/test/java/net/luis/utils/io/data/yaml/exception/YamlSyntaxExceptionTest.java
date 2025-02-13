package net.luis.utils.io.data.yaml.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link YamlSyntaxException}.<br>
 *
 * @author Luis-St
 */
class YamlSyntaxExceptionTest {
	
	@Test
	void constructor() {
		assertDoesNotThrow(() -> new YamlSyntaxException((String) null));
		assertDoesNotThrow(() -> new YamlSyntaxException((Throwable) null));
		assertDoesNotThrow(() -> new YamlSyntaxException(null, null));
	}
}
