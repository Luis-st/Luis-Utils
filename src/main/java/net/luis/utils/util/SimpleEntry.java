package net.luis.utils.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Luis-st
 *
 */

public class SimpleEntry<K, V> implements Map.Entry<K, V> {
	
	private final K key;
	protected V value;
	
	public SimpleEntry(K key, V value) {
		this.key = Objects.requireNonNull(key);
		this.value = value;
	}
	
	@Override
	public @NotNull K getKey() {
		return this.key;
	}
	
	@Override
	public @Nullable V getValue() {
		return this.value;
	}
	
	@Override
	public @Nullable V setValue(@Nullable V value) {
		throw new ConcurrentModificationException("Value of the entry cannot be set to " + value + ", because the entry is muted");
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
	
	
	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) return true;
		if (!(o instanceof SimpleEntry<?, ?> that)) return false;
		
		if (!this.key.equals(that.key)) return false;
		return Objects.equals(this.value, that.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.key, this.value);
	}
	
}
