package lotto.domain.exception;

import java.util.List;

public interface LottoExceptionHandler {

    default void handleException(String input) {

    }

    default void handleException(int number) {

    }

    default void handleException(List<Integer> numbers) {

    }
}
