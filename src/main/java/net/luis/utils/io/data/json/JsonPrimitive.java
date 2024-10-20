/*
 * LUtils
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.utils.io.data.json;

import net.luis.utils.io.reader.StringReader;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 *
 * @author Luis-St
 *
 */

public class JsonPrimitive implements JsonElement {
	
	private final Object value;
	
	public JsonPrimitive(boolean value) {
		this((Object) value);
	}
	
	public JsonPrimitive(@NotNull Number value) {
		this((Object) value);
	}
	
	public JsonPrimitive(@NotNull String value) {
		this((Object) value);
	}
	
	public JsonPrimitive(@NotNull Object value) {
		Objects.requireNonNull(value, "Value must not be null");
		switch (value) {
			case Boolean b -> this.value = value;
			case Number n -> this.value = value;
			case String s -> this.value = tryParse(s);
			default -> throw new IllegalArgumentException("Value must be a boolean, number or string");
		}
	}
	
	//region Static helper methods
	private static @NotNull Object tryParse(@NotNull String string) {
		if ("true".equalsIgnoreCase(string) || "false".equalsIgnoreCase(string)) {
			return Boolean.parseBoolean(string);
		}
		StringReader reader = new StringReader(string);
		try {
			Number number = reader.readNumber();
			reader.skipWhitespaces();
			if (reader.canRead()) {
				return string;
			}
			return number;
		} catch (Exception e) {
			return string;
		}
	}
	//endregion
	
	public @NotNull String getAsString() {
		return String.valueOf(this.value);
	}
	
	public boolean getAsBoolean() {
		return switch (this.value) {
			case Boolean b -> b;
			case Number n -> n.intValue() != 0;
			case String s -> Boolean.parseBoolean(s);
			default -> throw new IllegalStateException("Cannot convert value to boolean: " + this.value);
		};
	}
	
	public @NotNull Number getAsNumber() {
		return switch (this.value) {
			case Boolean b -> b ? 1 : 0;
			case Number n -> n;
			case String s -> new StringReader(s).readNumber();
			default -> throw new IllegalStateException("Cannot convert value to number: " + this.value);
		};
	}
	
	public byte getAsByte() {
		return this.getAsNumber().byteValue();
	}
	
	public short getAsShort() {
		return this.getAsNumber().shortValue();
	}
	
	public int getAsInteger() {
		return this.getAsNumber().intValue();
	}
	
	public long getAsLong() {
		return this.getAsNumber().longValue();
	}
	
	public float getAsFloat() {
		return this.getAsNumber().floatValue();
	}
	
	public double getAsDouble() {
		return this.getAsNumber().doubleValue();
	}
	
	//region Object overrides
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof JsonPrimitive that)) return false;
		
		return this.value.equals(that.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}
	
	@Override
	public String toString() {
		return this.toString(JsonConfig.DEFAULT);
	}
	
	@Override
	public @NotNull String toString(@NotNull JsonConfig config) {
		if (this.value instanceof String string) {
			return "\"" + string + "\"";
		}
		return this.getAsString();
	}
	//endregion
}
