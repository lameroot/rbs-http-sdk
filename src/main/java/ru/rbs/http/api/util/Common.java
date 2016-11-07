package ru.rbs.http.api.util;


import java.util.Collection;
import java.util.Map;

public class Common {

    private Common() {
    }

    /**
     * Checks if value is {@code null}. Throws {@link NullPointerException} if value is {@code null}.
     *
     * @param value value to check
     * @param name name of the value
     * @param <T> type of the value
     * @return value, if check was successful
     */
    public static <T> T checkNotNull(T value, String name) {
        if (value == null) {
            throw new NullPointerException(name + " is null");
        }
        return value;
    }

    /**
     * Checks if value is {@code null} or empty. Throws {@link NullPointerException} if value is {@code null}. Throws
     * {@link IllegalArgumentException} if value is empty.
     *
     * @param value value to check
     * @param name name of the value
     * @return value, if check was successful
     */
    public static String checkNotEmpty(String value, String name) {
        if (checkNotNull(value, name).length() == 0) {
            throw new IllegalArgumentException(name + " is empty");
        }
        return value;
    }

    /**
     * Checks if collection is {@code null} or empty. Throws {@link NullPointerException} if value is {@code null}.
     * Throws {@link IllegalArgumentException} if value is empty.
     *
     * @param value collection
     * @param name name of the collection
     * @param <V> type of elements in the collection
     * @param <T> collection's type
     * @return collection, if check was successful
     */
    public static <V, T extends Collection<V>> T checkNotEmpty(T value, String name) {
        if (checkNotNull(value, name).isEmpty()) {
            throw new IllegalArgumentException(name + " is empty");
        }
        return value;
    }

    /**
     * Checks if map is {@code null} or empty. Throws {@link NullPointerException} if value is {@code null}. Throws
     * {@link IllegalArgumentException} if value is empty.
     *
     * @param value map
     * @param name name of the map
     * @param <V> type of elements in the map
     * @param <K> key of elements in the map
     * @param <T> map's type
     * @return map, if check was successful
     */
    public static <V, K, T extends Map<V, K>> T checkNotEmpty(T value, String name) {
        if (checkNotNull(value, name).isEmpty()) {
            throw new IllegalArgumentException(name + " is empty");
        }
        return value;
    }
}
