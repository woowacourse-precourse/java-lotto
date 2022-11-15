package lotto.domain;

public interface CanValidate<T> {
    void validate(T toValidate);
}
