package lotto.controller.validator;

import java.util.function.Predicate;

public interface Validator {
    Predicate<String> getPredicate();
    String getErrorMessage();
}
