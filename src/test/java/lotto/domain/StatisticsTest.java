package lotto.domain;

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
            String expected = "[ERROR] 금액은 0-9까지의 숫자로만 이루어저야 합니다.";
            System.setIn(generateUserInput(expected));

            Assertions.assertThatThrownBy( () -> new Statistics(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(expected);
        }


        @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외를 터트린다.")
        @Test
        void isDividedByLottoAmount_함수_테스트() {
            String purchase = "11003";
            String expected = "[ERROR] 금액은 로또 한장의 가격인 1000원 단위로만 입력 가능합니다.";
            System.setIn(generateUserInput(expected));

            Assertions.assertThatThrownBy( () -> new Statistics(purchase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(expected);
        }
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
