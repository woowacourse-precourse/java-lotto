import lotto.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @DisplayName("생성한 로또들과 당첨 번호 비교하여 얻은 등수 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "0, false, NOTHING",
            "0, true, NOTHING",
            "1, false, NOTHING",
            "1, true, NOTHING",
            "2, false, NOTHING",
            "2, true, NOTHING",
            "3, false, FIFTH",
            "3, true, FIFTH",
            "4, false, FOURTH",
            "4, true, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND",
            "6, false, FIRST",
    })
    void compareRanking(int count, boolean hasBonusNumber, Ranking rank) {
        assertThat(Ranking.findRanking(count, hasBonusNumber)).isEqualTo(rank);
    }
}
