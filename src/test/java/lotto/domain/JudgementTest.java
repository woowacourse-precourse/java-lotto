package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {
    private Judgement judgement;
    private WinningLotto winningLotto;

    @BeforeEach
    void init() {
        judgement = new Judgement();
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Bonus(7));
    }

    @DisplayName("로또 1등 판정")
    @Test
    void judgeFirstPlace() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Rank rank = judgement.getLottoRank(lotto, winningLotto);
        assertThat(rank).isEqualTo(FIRST_PLACE);
    }

    @DisplayName("로또 2등 판정")
    @Test
    void judgeSecondPlace() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Rank rank = judgement.getLottoRank(lotto, winningLotto);
        assertThat(rank).isEqualTo(SECOND_PLACE);
    }

    @DisplayName("로또 3등 판정")
    @Test
    void judgeThirdPlace() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Rank rank = judgement.getLottoRank(lotto, winningLotto);
        assertThat(rank).isEqualTo(THIRD_PLACE);
    }

    @DisplayName("로또 4등 판정")
    @Test
    void judgeFourthPlace() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        Rank rank = judgement.getLottoRank(lotto, winningLotto);
        assertThat(rank).isEqualTo(FOURTH_PLACE);
    }

    @DisplayName("로또 5등 판정")
    @Test
    void judgeFifthPlace() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Rank rank = judgement.getLottoRank(lotto, winningLotto);
        assertThat(rank).isEqualTo(FIFTH_PLACE);
    }

    @DisplayName("등수 미달")
    @Test
    void judgeUnrank() {
        Lotto lotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
        Rank rank = judgement.getLottoRank(lotto, winningLotto);
        assertThat(rank).isEqualTo(UNRANK);
    }
}
