package lotto.domain;

import lotto.exception.InputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StatisticsTest {

    @Nested
    @DisplayName("구입 금액 예외 처리 테스트")
    class Exception {

        @DisplayName("구입 금액이 숫자가 아닌 경우 예외를 터트린다.")
        @Test
        void hasDigitsOnly_함수_테스트() {
            String purchase = "3!@# A";
            System.setIn(generateUserInput(purchase));

            Assertions.assertThatThrownBy( () -> new Statistics(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.INPUT_NOT_DIGIT.message());
        }


        @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외를 터트린다.")
        @Test
        void isDividedByLottoAmount_함수_테스트() {
            String purchase = "11003";
            System.setIn(generateUserInput(purchase));

            Assertions.assertThatThrownBy( () -> new Statistics(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.INPUT_MUST_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
