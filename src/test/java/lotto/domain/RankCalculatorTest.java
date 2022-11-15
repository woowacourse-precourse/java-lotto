package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RankCalculatorTest {
    private static final JackpotBonus jackpotBonus = new JackpotBonus(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("당첨 번호가 3개 미만으로 일치하면 꽝을 반환한다")
    @Test
    void rank6By2Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        assertThat(RankCalculator.getRankOf(jackpotBonus, lotto))
                .isEqualTo(Rank.NO_LUCK);
    }

    @DisplayName("당첨 번호가 3개 일치하면 5위를 반환한다")
    @Test
    void rank5By3Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        assertThat(RankCalculator.getRankOf(jackpotBonus, lotto))
                .isEqualTo(Rank.FIFTH);
    }

    @DisplayName("당첨 번호와 4개 일치하면 4위를 반환한다")
    @Test
    void rank4By4Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        assertThat(RankCalculator.getRankOf(jackpotBonus, lotto))
                .isEqualTo(Rank.FOURTH);
    }

    @DisplayName("당첨 번호가 5개 일치하면 3위을 반환한다")
    @Test
    void rank3By5Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        assertThat(RankCalculator.getRankOf(jackpotBonus, lotto))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨 번호가 5개 일치하고 보너스 번호가 일치하면 2위를 반환한다")
    @Test
    void rank2By5JackpotAndBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(RankCalculator.getRankOf(jackpotBonus, lotto))
                .isEqualTo(Rank.SECOND);
    }

    @DisplayName("당첨 번호가 6개 일치하면 1위를 반환한다")
    @Test
    void rank1By6Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(RankCalculator.getRankOf(jackpotBonus, lotto))
                .isEqualTo(Rank.FIRST);
    }
}
