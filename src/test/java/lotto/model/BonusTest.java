package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @ParameterizedTest(name = "보너스 번호가 1 ~ 45 중 하나가 아니라면 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    void createLottoByOverSize(int number) {
        assertThatThrownBy(() -> new Bonus(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("int 로 반환하기")
    @Test
    void toInt() {
        Bonus bonus = new Bonus(5);
        assertThat(bonus.toInt()).isEqualTo(5);
    }
}