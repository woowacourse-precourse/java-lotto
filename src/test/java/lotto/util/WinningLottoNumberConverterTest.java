package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoNumberConverterTest {
    private static final String EXCEPTION_MESSAGE_INVALID_FORMAT = "[ERROR] 잘못된 형식의 입력입니다.";

    @DisplayName("당첨로또번호 입력값형식이 잘못된 경우 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5,6", "1,2,,3,4,5,6", "a1,2,3,4,5,6"})
    void WinningLottoNumberInvalidFormat(String WinningLottoNumber) {
        assertThatThrownBy(() -> WinningLottoNumberConverter.convert(WinningLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_INVALID_FORMAT);
    }
}
