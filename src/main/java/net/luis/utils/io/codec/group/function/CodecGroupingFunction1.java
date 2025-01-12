/*
 * LUtils
 * Copyright (C) 2025 Luis Staudt
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

package net.luis.utils.io.codec.group.function;

import net.luis.utils.io.codec.Codec;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a codec grouping function that accepts one argument and produces a result.<br>
 * Manly used for decoding objects using a {@link Codec}.<br>
 *
 * @author Luis-St
 *
 * @param <CI1> The type of the input
 * @param <R> The result type
 */
@FunctionalInterface
public interface CodecGroupingFunction1<CI1, R> {
	
	/**
	 * Constructs a new object using the given input.<br>
	 * @param input1 The first input
	 * @return The constructed object
	 */
	@NotNull R create(
		@NotNull CI1 input1
	);
}
