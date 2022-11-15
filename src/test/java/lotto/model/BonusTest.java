package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void createDuplicateNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new Bonus(3, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교해 일치하는지 확인한다.")
    @Test
    void isMatch() {
        Bonus bonus = new Bonus(7, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        boolean actual = bonus.isMatch(List.of(7, 8, 9, 10, 11, 12));
        assertThat(actual).isTrue();
    }
}