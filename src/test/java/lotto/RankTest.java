package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("랭크 클래스에서 원하는 값을 찾아서 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0,false,NOTHING", "0,true,NOTHING", "1,false,NOTHING", "1,true,NOTHING",
            "2,false,NOTHING", "2,true,NOTHING", "3,false,FIFTH", "3,true,FIFTH",
            "4,false,FOURTH", "4,true,FOURTH", "5,false,THIRD", "5,true,SECOND",
            "6,false,FIRST"})
    void createRank(int matchNumber, boolean hasBonusNumber, String result) {
        Rank rank = Rank.findRank(matchNumber, hasBonusNumber);
        assertThat(rank.toString()).isEqualTo(result);
    }
}
