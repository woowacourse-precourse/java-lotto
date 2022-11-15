package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBonusNumberTest {

    @DisplayName("번호가 1부터 45를 벗어나면 에러를 반환한다.")
    @Test
    void createLottoBonusNumberOutOfRange() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> LottoBonusNumber.of(0)).isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertDoesNotThrow(() -> LottoBonusNumber.of(1)),
                () -> Assertions.assertDoesNotThrow(() -> LottoBonusNumber.of(45)),
                () -> assertThatThrownBy(() -> LottoBonusNumber.of(46)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자와 값이 같은지 반환한다.")
    @Test
    void equalNumber() {
        LottoBonusNumber bonusNumber = LottoBonusNumber.of(3);

        Assertions.assertAll(
                () -> assertThat(bonusNumber.equalNumber(2)).isFalse(),
                () -> assertThat(bonusNumber.equalNumber(3)).isTrue(),
                () -> assertThat(bonusNumber.equalNumber(4)).isFalse()
        );
    }
}
