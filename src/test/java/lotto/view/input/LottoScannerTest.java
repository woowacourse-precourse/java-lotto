package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoScannerTest {

    private final LottoScanner lottoScanner = new LottoScanner();

    @Nested
    class validateItContainsOnlyNumber {

        @ParameterizedTest(name = "숫자만 입력하면 예외를 던지지 않는다.")
        @ValueSource(strings = {"14000", "1300", "1000000"})
        void success(String inputValue) {
            lottoScanner.validateItContainsOnlyNumber(inputValue);
        }

        @ParameterizedTest(name = "숫자가 아닌 값을 입력하면 예외를 던진다")
        @ValueSource(strings = {"안녕하세요", "money", "백만원", ""})
        void fail(String inputValue) {
            assertThatThrownBy(
                    () -> lottoScanner.validateItContainsOnlyNumber(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력해 주세요");
        }
    }

    @Nested
    class validateWinningNumberFormat {

        @ParameterizedTest(name = "양식을 지키면 예외를 던지지 않는다.")
        @ValueSource(strings = {"1,2,3,4,5,6", "10,14,200,1000,4,5000000"})
        void success(String inputValue) {
            lottoScanner.validateWinningNumberFormat(inputValue);
        }

        @ParameterizedTest(name = "양식을 지키지 않으면 예외를 던진다.")
        @ValueSource(strings = {
                "1,2,3,",
                "123456",
                "1,2,3,4,5,6,",
                "1,2,3,4,5,6,7,8"})
        void fail(String inputValue) {
            assertThatThrownBy(
                    () -> lottoScanner.validateWinningNumberFormat(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("올바른 당첨 번호 포맷이 아닙니다.");
        }
    }
}