package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @ParameterizedTest
    @DisplayName("로또 당첨 등수 확인")
    @CsvSource(value = {
            "1,false,NOTHING",
            "1,true,NOTHING",
            "2,false,NOTHING",
            "2,true,NOTHING",
            "3,false,THREE",
            "3,true,THREE",
            "4,false,FOUR",
            "4,true,FOUR",
            "5,false,FIVE",
            "5,true,FIVE_WITH_BONUS",
            "6,false,SIX",
            "6,true,SIX"
    })
    void matchLottoRank(int count, boolean bonus, Numbers findRank) {
        assertThat(Numbers.findRank(count, bonus)).isEqualTo(findRank);
    }
}
