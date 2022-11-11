package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusLottoTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호랑 중복일 때 예외")
    void checkBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 6;

        assertThatThrownBy(() -> new BonusLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 1 ~ 45 범위를 벗어났을 때")
    @ValueSource(ints = {-1, 0, 46})
    void checkLottoRange(int bonus) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("발행한 로또와 비교")
    void match() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        BonusLotto bonusLotto = new BonusLotto(winningNumber, bonus);

        Lotto user = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        assertThat(bonusLotto.match(user)).isEqualTo(0);
    }
}
