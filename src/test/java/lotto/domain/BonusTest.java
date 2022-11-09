package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {

    @DisplayName("보너스 숫자가 로또 번호에 있으면 예외가 발생한다.")
    @Test
    void choiceBonusNumberByLottoNumbers() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 45보다 클 때 예외가 발생한다.")
    @Test
    void choiceBonusNumberOver45() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 56))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 1보다 작을 때 예외가 발생한다.")
    @Test
    void choiceBonusNumberUnder1() {
        assertThatThrownBy(() -> new Bonus(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 로또에 보너스점수가 포함돼있으면 true를 반환한다")
    @Test
    void isUserNumberIncludeBonusNumber() {
        Bonus bonus = new Bonus(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(bonus.checkBonus(Arrays.asList(7, 8, 9, 10, 11, 12))).isTrue();
    }
}
