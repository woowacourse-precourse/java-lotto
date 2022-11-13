package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class InputServiceTest {
    InputService inputService = new InputService();

    @Nested
    @DisplayName("구매 금액, 예외 발생")
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
    @DisplayName("구매 금액, 정상 실행")
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

    @Nested
    @DisplayName("당첨 번호, 정상 실행")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class notNumbersExceptionTest {
        @ParameterizedTest
        @MethodSource("data")
        void case1(String inputNumbers, List<Integer> checkNumbers) {
            inputService.setMoneyToUser("1000");
            Assertions.assertThatCode(() -> inputService.setNumbersToUser(inputNumbers))
                    .doesNotThrowAnyException();
            Assertions.assertThat(inputService.getUser().getNumbers()).isEqualTo(checkNumbers);
        }

        Stream<Arguments> data() {
            return Stream.of(
                    Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                    Arguments.of("1, 2, 3, 4, 5, 6", List.of(1, 2, 3, 4, 5, 6))
            );
        }
    }
}
