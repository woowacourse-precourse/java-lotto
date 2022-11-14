package lotto.util;

@FunctionalInterface
public interface Validator<T> {
    void validate(T input);
}
