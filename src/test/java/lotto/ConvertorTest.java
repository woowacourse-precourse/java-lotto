package lotto;

import static lotto.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.Convertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConvertorTest {
    @DisplayName("가격 입력 시 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1300k", "이만원", "1ooo", "twentythousand", "!7000"})
    void nonNumeric(String input) {
        assertThatThrownBy(() -> Convertor.toPurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_TITLE + NON_NUMERIC);
    }

    @DisplayName("가격 입력 시 천 원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10005", "50010", "2080332900", "1300"})
    void nonDividedByThousand(String input) {
        assertThatThrownBy(() -> Convertor.toPurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_TITLE + NOT_IN_THOUSANDS);
    }

    @DisplayName("당첨 번호 입력 시 6개의 쉼표를 사용하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "12345,6", "1&2&3&4&5&6", "1+2+3+4+5+6", "12345and6", "1,2,3,4,5,6,7"})
    void winningNumbersWithoutComma(String input) {
        assertThatThrownBy(() -> Convertor.separate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_TITLE + NON_PROPER_COMMA);
    }

    @DisplayName("당첨 번호 입력 시 숫자를 올바르게 쓰지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5, 6:45", "1,!!,3,4,5,6:45", "하나,2,3,4,5,6:45", "one,2,3,4,5,6:45"})
    void winningNumbersWithoutProperNumbers(String input) {
        assertThatThrownBy(() -> Convertor.separate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_TITLE + NON_NUMERIC);
    }
}