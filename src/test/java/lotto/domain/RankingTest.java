package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {
    @CsvSource(value = {
            "6:true:FIRST", "6:false:FIRST",
            "5:true:SECOND", "5:false:THIRD",
            "4:true:FOURTH", "4:false:FOURTH",
            "3:true:FIFTH", "3:false:FIFTH",
            "2:true:MISS", "2:false:MISS",
            "1:true:MISS", "1:false:MISS",
            "0:true:MISS", "0:false:MISS"}, delimiter = ':')
    @ParameterizedTest
    void 일치하는_개수와_보너스_포함_여부로_순위를_반환한다(int count, boolean bonus, Ranking expected) {
        Ranking ranking = Ranking.from(count, bonus);

        assertThat(ranking).isEqualTo(expected);
    }
}
