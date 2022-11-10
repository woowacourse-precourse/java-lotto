package lotto.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputExceptionTest {

    private final InputException inputException = new InputException();

    @Nested
    @DisplayName("숫자가 아니여서 예외 처리")
    class notDigit {
        @ParameterizedTest
        @CsvSource({
                "looo", "ㅇㅇㅇㅇ",
                "일공공공", "100o",
                "100공", "100ㅇ",
                "10!0", "1 00"
        })
        void case1(String inputData) {
            Assertions.assertThatThrownBy(() -> inputException.notDigitException(inputData))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구매 금액과 로또 번호는 숫자만 입력이 가능합니다.");
        }
    }

    @Nested
    @DisplayName("숫자여서 정상 실행")
    class digit {
        @ParameterizedTest
        @CsvSource({
                "1000", "2000", "10000"
        })
        void case1(String inputData) {
            Assertions.assertThatCode(() -> inputException.notDigitException(inputData))
                    .doesNotThrowAnyException();
        }
    }
}
