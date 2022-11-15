package lotto.calculation;

import lotto.exception.IllegalArgument;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StatisticsTest {

    @Test
    void 총_수익_계산() {
        assertThat(new Statistics().getRevenue(Arrays.asList(Rank.RANK_FIVE))).isEqualTo(5000);
    }

    @Test
    void 등수별_당첨_개수_확인() {
        List<List<Integer>> totalWinningCount = List.of(
                List.of(3, 0),
                List.of(4, 0),
                List.of(5, 1)
        );
        assertThat(new Statistics().getRankCount(totalWinningCount))
                .isEqualTo(List.of(Rank.RANK_FIVE, Rank.RANK_FOUR, Rank.RANK_TWO));
    }

    @Test
    void 당첨_번호_일치_개수에_따른_등수_확인() {
        assertThat(new Statistics().getRankFromCount(List.of(5, 0))).isEqualTo(Rank.RANK_THREE);
    }

    @Test
    void 당첨_번호_개수_저장() {
        Winning winning = new Winning(Arrays.asList("1", "3", "13", "15", "23", "25"));
        winning.setBonusNumber(44);
        assertThat(new Statistics().getWinningCount(Arrays.asList(1, 3, 17, 19, 20, 30), winning))
                .isEqualTo(Arrays.asList(2, 0));
    }

    @Test
    void 발행된_로또의_보너스_번호_정하기() {
        int bonusNumber = new Statistics().getLottoBonusNumber(Arrays.asList(1, 3, 17, 19, 20, 30));
        assertThat(IllegalArgument.isRedundancyWithNumbers(bonusNumber, Arrays.asList(1, 3, 17, 19, 20, 30))).isFalse();
    }

    @Test
    void 보너스_번호_일치_확인() {
        Winning winning = new Winning(Arrays.asList("1", "3", "13", "15", "23", "25"));
        winning.setBonusNumber(44);
        assertThat(new Statistics().matchBonusNumber(44, winning)).isTrue();
    }

    @Test
    void 보너스_번호_불일치_확인() {
        Winning winning = new Winning(Arrays.asList("1", "3", "13", "15", "23", "25"));
        winning.setBonusNumber(44);
        assertThat(new Statistics().matchBonusNumber(43, winning)).isFalse();
    }
}
