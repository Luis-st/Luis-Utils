package net.luis.utils.data.tag.tags.collection;

import net.luis.utils.data.tag.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractList;

/**
 *
 * @author Luis-St
 *
 */

public abstract class CollectionTag<T extends Tag> extends AbstractList<T> implements Tag {
	
	
	public abstract @NotNull T set(int index, @NotNull T tag);
	
	public abstract void add(int index, @NotNull T tag);
	
	public abstract @Nullable T remove(int index);
	
	public abstract boolean setTag(int index, @NotNull Tag tag);
	
	public abstract boolean addTag(int index, @NotNull Tag tag);
	
	public abstract byte getElementType();
	
	@Override
	public @NotNull String toString() {
		return this.getAsString();
	}
	
}
