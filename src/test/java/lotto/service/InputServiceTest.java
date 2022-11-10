package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputServiceTest {
    InputService inputService = new InputService();

    @Nested
    @DisplayName("예외 발생")
    class exceptionTest {
        @ParameterizedTest
        @CsvSource({
                "looo", "ㅇㅇㅇㅇ",
                "일공공공", "100o",
                "100공", "100ㅇ",
                "10!0", "1 00"
        })
        void case1(String inputMoney) {
            Assertions.assertThatThrownBy(() -> inputService.inputMoneyToInteger(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구매 금액과 로또 번호는 숫자만 입력이 가능합니다.");
        }

        @ParameterizedTest
        @CsvSource({
            "1234", "1001", "11111001"
        })
        void case2(String inputMoney) {
            Assertions.assertThatThrownBy(() -> inputService.inputMoneyToInteger(inputMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구매 금액은 1,000원 단위로 입력이 가능합니다.");
        }
    }

    @Nested
    @DisplayName("정상 실행")
    class notExceptionTest {
        @ParameterizedTest
        @CsvSource({
            "1000", "1234000"
        })
        void case1(String inputMoney) {
            Assertions.assertThatCode(() -> inputService.inputMoneyToInteger(inputMoney))
                    .doesNotThrowAnyException();
        }
    }
}
