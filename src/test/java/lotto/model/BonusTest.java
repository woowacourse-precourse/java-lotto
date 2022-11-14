package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BonusTest {
    @ParameterizedTest(name = "규칙을 준수한 문자열을 통해 보너스 번호를 생성한다.")
    @ValueSource(strings = {
            "1",
            "40"
    })
    void createLottoByValidString(String input) {
        assertDoesNotThrow(() -> Bonus.from(input));
    }

    @ParameterizedTest(name = "규칙을 준수하지 않은 문자열을 통해 보너스 번호를 생성한다.")
    @ValueSource(strings = {
            "46",
            "-1",
            "가"
    })
    void createLottoByInvalidString(String input) {
        assertThatThrownBy(() -> Bonus.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

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