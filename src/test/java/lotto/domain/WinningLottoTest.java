package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    int bonus = 7;
    WinningLotto winningLotto = new WinningLotto(lotto, bonus);

    @Test
    @DisplayName("일치하는 숫자 개수 세기")
    void countMatchNum1() {
        Lotto myLotto = new Lotto(List.of(16, 3, 14, 45, 31, 7));
        int matchNumbers = winningLotto.countMatchNumber(myLotto);
        boolean bonus = winningLotto.checkBonusNumber(myLotto);

        assertThat(matchNumbers)
                .isEqualTo(1);

        assertThat(bonus)
                .isTrue();
    }

    @Test
    @DisplayName("일치하는 숫자 개수 세기")
    void countMatchNum2() {
        Lotto myLotto = new Lotto(List.of(2,4,6,8,10,12));
        int matchNumbers =  winningLotto.countMatchNumber(myLotto);
        boolean bonus = winningLotto.checkBonusNumber(myLotto);

        assertThat(matchNumbers)
                .isEqualTo(3);

        assertThat(bonus)
                .isFalse();
    }
}