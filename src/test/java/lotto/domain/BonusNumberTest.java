package lotto.domain;

import static lotto.io.Message.INPUT_FROM_1_TO_45;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("보너스 번호 입력")
    @Test
    void testInputBonusNumber() {
        String input = "1";
        assertThat(BonusNumber.saveBonusNumber(input)).isNotNull();
    }

    @DisplayName("보너스 번호 숫자 아닌 값 입력")
    @Test
    void testInputNotNumber() {
        String input = ",";

        assertThatThrownBy(() -> BonusNumber.saveBonusNumber(input))
            .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("보너스 번호 잘못된 범위 입력")
    @ValueSource(strings = { "0", "46" })
    @ParameterizedTest
    void testInputBonusNumberWrongRange(final String number) {
        assertThatThrownBy(() -> BonusNumber.saveBonusNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INPUT_FROM_1_TO_45);
    }

}
