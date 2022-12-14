package lotto.domain;

import lotto.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    @DisplayName("잘못된 보너스 번호 범위에 대한 예외 테스트")
    @ParameterizedTest
    @CsvSource({"0", "-1", "46", "100"})
    void outBoundOfBonusNumber_exception(int bonusNumber) {
        // then
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_BOUNDS_LOTTO_NUMBER_ERROR);
    }
}