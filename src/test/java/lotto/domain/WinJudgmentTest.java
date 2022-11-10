package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinJudgmentTest {
    WinJudgment winJudgment = new WinJudgment();

    @Test
    void 몇_개의_숫자가_맞았는지_판단() {
        int matchNum = winJudgment.matchNumbers(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7));
        assertThat(matchNum).isEqualTo(5);
    }

    @Test
    void 보너스_번호를_맞추었는지_판단() {
        boolean bonusNum = winJudgment.matchBonusNumber(7,7);
        assertThat(bonusNum).isTrue();
        bonusNum = winJudgment.matchBonusNumber(6,7);
        assertThat(bonusNum).isFalse();
    }

    @Test
    void 몇_등인지_판단하는_기능() {
        LottoRanking ranking = winJudgment.rankingJudgment(6, true);
        assertThat(ranking).isEqualTo(LottoRanking.FIRST_PLACE);
        ranking = winJudgment.rankingJudgment(5, true);
        assertThat(ranking).isEqualTo(LottoRanking.SECOND_PLACE);
        ranking = winJudgment.rankingJudgment(5, false);
        assertThat(ranking).isEqualTo(LottoRanking.THIRD_PLACE);
    }
}