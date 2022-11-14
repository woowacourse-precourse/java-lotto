package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(name = "로또 숫자 값을 반환한다.")
    @ValueSource(ints = {1, 4, 16, 25, 35, 43, 45})
    void number(int number) {
        assertThat(LottoBonusNumber.of(number).number()).isEqualTo(number);
    }
}
