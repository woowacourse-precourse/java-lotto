package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoOperatorTest {

    @ParameterizedTest
    @DisplayName("발행 로또와 당첨 번호 비교 카운트 등수 확인")
    @CsvSource(value = {
            "1,false,NO_LUCK",
            "1,true,NO_LUCK",
            "2,false,NO_LUCK",
            "2,true,NO_LUCK",
            "3,false,THREE",
            "3,true,THREE",
            "4,false,FOUR",
            "4,true,FOUR",
            "5,false,FIVE",
            "5,true,FIVE_BONUS",
            "6,false,SIX",
            "6,true,SIX"
    })
    void matchLottoRank(int count, boolean bonus, LottoOperator findRank) {
        assertThat(LottoOperator.find(count, bonus)).isEqualTo(findRank);
    }
}
