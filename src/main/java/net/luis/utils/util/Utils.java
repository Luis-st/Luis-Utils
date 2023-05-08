package net.luis.utils.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Luis-St
 *
 */

public class Utils {
	
	public static final UUID EMPTY_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
	
	public static boolean isEmpty(UUID uuid) {
		return uuid == EMPTY_UUID || EMPTY_UUID.equals(uuid);
	}
	
	public static <T> @NotNull T make(T object, @NotNull Consumer<T> action) {
		Objects.requireNonNull(action, "Action must not be null").accept(object);
		return Objects.requireNonNull(object, "Object must not be null");
	}
	
	public static <K, V, T> @NotNull List<T> mapToList(Map<K, V> map, BiFunction<K, V, T> mapper) {
		List<T> list = Lists.newArrayList();
		for (Map.Entry<K, V> entry : Objects.requireNonNull(map, "Map must not be null").entrySet()) {
			list.add(Objects.requireNonNull(mapper, "Mapper must not be null").apply(entry.getKey(), entry.getValue()));
		}
		return list;
	}
	
	public static <T, K, V> @NotNull Map<K, V> listToMap(List<T> list, Function<T, Entry<K, V>> mapper) {
		Map<K, V> map = Maps.newHashMap();
		for (T t : Objects.requireNonNull(list, "List must not be null")) {
			Entry<K, V> entry = Objects.requireNonNull(mapper, "Mapper must not be null").apply(t);
			map.put(entry.getKey(), entry.getValue());
		}
		return map;
	}
	
	//region List util methods
	public static <T, U> @NotNull List<U> mapList(List<T> list, Function<T, U> mapper) {
		Objects.requireNonNull(list, "List must not be null");
		Objects.requireNonNull(mapper, "Mapper must not be null");
		return list.stream().map(mapper).collect(Collectors.toList());
	}
	
	public static <T, U, V> @NotNull List<V> mapList(List<T> list, Function<T, U> firstMapper, Function<U, V> secondMapper) {
		Objects.requireNonNull(list, "List must not be null");
		Objects.requireNonNull(firstMapper, "First mapper must not be null");
		Objects.requireNonNull(secondMapper, "Second mapper must not be null");
		return list.stream().map(firstMapper).map(secondMapper).collect(Collectors.toList());
	}
	//endregion
	
	//region Duplicate checks
	public static boolean hasDuplicates(Object[] values) {
		Objects.requireNonNull(values, "Values must not be null");
		return values.length != Arrays.stream(values).distinct().count();
	}
	
	public static boolean hasDuplicates(List<?> values) {
		Objects.requireNonNull(values, "Values must not be null");
		return values.size() != values.stream().distinct().count();
	}
	
	public static boolean hasDuplicates(Object object, Object[] values) {
		Objects.requireNonNull(object, "Object must not be null");
		Objects.requireNonNull(values, "Values must not be null");
		return values.length != Arrays.stream(values).filter(object::equals).count();
	}
	
	public static boolean hasDuplicates(Object object, List<?> values) {
		Objects.requireNonNull(object, "Object must not be null");
		Objects.requireNonNull(values, "Values must not be null");
		return values.size() != values.stream().filter(object::equals).count();
	}
	//endregion
	
	//region Map util methods
	public static <K, T, V> @NotNull Map<T, V> mapKey(Map<K, V> map, Function<K, T> mapper) {
		Map<T, V> mapped = Maps.newHashMap();
		for (Entry<K, V> entry : Objects.requireNonNull(map, "Map must not be null").entrySet()) {
			mapped.put(Objects.requireNonNull(mapper, "Mapper must not be null").apply(entry.getKey()), entry.getValue());
		}
		return mapped;
	}
	
	public static <K, V, T> @NotNull Map<K, T> mapValue(Map<K, V> map, Function<V, T> mapper) {
		Map<K, T> mapped = Maps.newHashMap();
		for (Entry<K, V> entry : Objects.requireNonNull(map, "Map must not be null").entrySet()) {
			mapped.put(entry.getKey(), Objects.requireNonNull(mapper, "Mapper must not be null").apply(entry.getValue()));
		}
		return mapped;
	}
	//endregion
	
	//region Null helper methods
	public static <T, R> R mapIf(@Nullable T value, Predicate<T> condition, Function<T, R> mapper) {
		Objects.requireNonNull(condition, "Condition must not be null");
		if (value != null && condition.test(value)) {
			return Objects.requireNonNull(mapper, "Mapper must not be null").apply(value);
		}
		return null;
	}
	
	public static <T, R> R mapIfNot(@Nullable T value, Predicate<T> condition, Function<T, R> mapper) {
		Objects.requireNonNull(condition, "Condition must not be null");
		if (value != null && !condition.test(value)) {
			return Objects.requireNonNull(mapper, "Mapper must not be null").apply(value);
		}
		return null;
	}
	
	public static <T, R> R mapIfNotNull(T value, Function<T, R> mapper) {
		if (value != null) {
			return Objects.requireNonNull(mapper, "Mapper must not be null").apply(value);
		}
		return null;
	}
	
	public static <T> @NotNull T warpNullTo(T value, T nullFallback) {
		if (value == null) {
			return Objects.requireNonNull(nullFallback, "Fallback value must not be null");
		}
		return value;
	}
	//endregion
	
	//region Random util methods
	public static @NotNull Random systemRandom() {
		return new Random(System.currentTimeMillis());
	}
	
	public static <T> @NotNull T getRandom(T[] values, Random rng) {
		Objects.requireNonNull(values, "Values must not be null");
		Objects.requireNonNull(rng, "Random must not be null");
		return values[rng.nextInt(values.length)];
	}
	
	public static <T> @NotNull Optional<T> getRandomSafe(T[] values, Random rng) {
		Objects.requireNonNull(values, "Values must not be null");
		Objects.requireNonNull(rng, "Random must not be null");
		return values.length == 0 ? Optional.empty() : Optional.of(getRandom(values, rng));
	}
	
	public static <T> @NotNull T getRandom(List<T> values, Random rng) {
		Objects.requireNonNull(values, "Values must not be null");
		Objects.requireNonNull(rng, "Random must not be null");
		return values.get(rng.nextInt(values.size()));
	}
	
	public static <T> @NotNull Optional<T> getRandomSafe(List<T> values, Random rng) {
		Objects.requireNonNull(values, "Values must not be null");
		Objects.requireNonNull(rng, "Random must not be null");
		return values.isEmpty() ? Optional.empty() : Optional.of(getRandom(values, rng));
	}
	//endregion
}
