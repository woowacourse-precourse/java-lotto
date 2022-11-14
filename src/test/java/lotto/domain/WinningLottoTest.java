package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {

    @DisplayName("보너스 번호를 맞췄는지")
    @Test
    void case2() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningNumber, 7);
        List<Integer> myNumber = List.of(1, 2, 3, 4, 5, 6);

        assertThat(winningLotto.containsBonus(myNumber)).isEqualTo(false);
    }

    @DisplayName("보너스가 중복일 경우")
    @Test
    void case3() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}