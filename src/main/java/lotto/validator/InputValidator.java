package lotto.validator;

public interface InputValidator<T> {

    void validate(T target) throws IllegalArgumentException;
}
