package lotto.controller;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CompareTest {
    private static final List<List<Integer>> userLotto = List.of(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("같은 숫자 3개 비교")
    @Test
    public void Same3Number() {
        Lotto winLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        Compare testCompare = new Compare(userLotto, winLotto, 11);
        assertThat(testCompare.count == 3 );
    }

    @DisplayName("같은 숫자 5개, 보너스 true 비교")
    @Test
    public void Same5NumberBonus() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Compare testCompare = new Compare(userLotto, winLotto, 6);
        assertThat((testCompare.count == 5 && testCompare.bonusHit == true));
    }

    @DisplayName("같은 숫자 5개, 보너스 false 비교")
    @Test
    public void Same5NumberNotBonus() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Compare testCompare = new Compare(userLotto, winLotto, 8);
        assertThat((testCompare.count == 5 && testCompare.bonusHit == false));
    }
}