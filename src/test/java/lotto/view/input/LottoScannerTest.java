package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoScannerTest {

    private final LottoScanner lottoScanner = new LottoScanner();

    @Nested
    class validateItContainsOnlyNumber {
        @ParameterizedTest(name = "숫자만 입력하면 예외를 던지지 않는다.(입력: {0})")
        @ValueSource(strings = {"14000", "1300", "1000000"})
        void success(String inputValue) {
            lottoScanner.validateItContainsOnlyNumber(inputValue);
        }

        @ParameterizedTest(name = "숫자가 아닌 값을 입력하면 예외를 던진다.(입력: {0})")
        @ValueSource(strings = {"안녕하세요", "money", "백만원", ""})
        void fail(String inputValue) {
            assertThatThrownBy(
                    () -> lottoScanner.validateItContainsOnlyNumber(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력해 주세요");
        }
    }
}