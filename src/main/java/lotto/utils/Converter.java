package lotto.utils;

public interface Converter<T, R> {
    R convert(T target);
}
