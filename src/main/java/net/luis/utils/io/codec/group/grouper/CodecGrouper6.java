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

package net.luis.utils.io.codec.group.grouper;

import net.luis.utils.io.codec.Codec;
import net.luis.utils.io.codec.group.function.CodecGroupingFunction6;
import org.jetbrains.annotations.NotNull;

public record CodecGrouper6<CI1, CI2, CI3, CI4, CI5, CI6>(
	@NotNull Codec<CI1> codec1,
	@NotNull Codec<CI2> codec2,
	@NotNull Codec<CI3> codec3,
	@NotNull Codec<CI4> codec4,
	@NotNull Codec<CI5> codec5,
	@NotNull Codec<CI6> codec6
) {
	
	public <R> @NotNull Codec<R> create(@NotNull CodecGroupingFunction6<CI1, CI2, CI3, CI4, CI5, CI6, R> function) {
		return null;
	}
}
