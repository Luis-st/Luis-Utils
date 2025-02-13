package net.luis.utils.io.data.yaml.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link YamlAnchorException}.<br>
 *
 * @author Luis-St
 */
class YamlAnchorExceptionTest {
	
	@Test
	void constructor() {
		assertDoesNotThrow(() -> new YamlAnchorException((String) null));
		assertDoesNotThrow(() -> new YamlAnchorException((Throwable) null));
		assertDoesNotThrow(() -> new YamlAnchorException(null, null));
	}
}
