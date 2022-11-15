package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @ParameterizedTest
    @DisplayName("로또 당첨 등수 확인")
    @CsvSource(value = {
            "1,NOTHING",
            "2,NOTHING",
            "3,THREE",
            "4,FOUR",
            "5,FIVE",
            "6,SIX"
    })
    void matchLottoRank(int count, Numbers findRank) {
        assertThat(Numbers.findRank(count)).isEqualTo(findRank);
    }
}
