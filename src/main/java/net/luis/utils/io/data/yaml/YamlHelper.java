package net.luis.utils.io.data.yaml;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Luis-St
 *
 */

final class YamlHelper {
	
	private static final Pattern COLON_WHITESPACE_PATTERN = Pattern.compile(":\\s");
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s");
	
	private YamlHelper() {}
	
	static void validateYamlKey(@NotNull String key) {
		Objects.requireNonNull(key, "Key must not be null");
		if (key.isBlank()) {
			throw new IllegalArgumentException("Key must not be empty or blank");
		}
		if (StringUtils.startsWithAny(key, "*", "&", "!", ">", "|", "#", "@", "%", "[", "{")) {
			throw new IllegalArgumentException("Key must not start with a special character (*, &, !, >, |, #, @, %, [, {)");
		}
		if (COLON_WHITESPACE_PATTERN.matcher(key).find()) {
			throw new IllegalArgumentException("Key must not contain a colon followed by a space");
		}
	}
	
	static void validateYamlAnchor(@NotNull String anchor) {
		Objects.requireNonNull(anchor, "Anchor must not be null");
		if (anchor.isBlank()) {
			throw new IllegalArgumentException("Anchor must not be empty or blank");
		}
		if (StringUtils.startsWithAny(anchor, "[", "{")) {
			throw new IllegalArgumentException("Anchor must not start with a special character ([, {)");
		}
		if (WHITESPACE_PATTERN.matcher(anchor).find()) {
			throw new IllegalArgumentException("Anchor must not contain a whitespace");
		}
	}
}
