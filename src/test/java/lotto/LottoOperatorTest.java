package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoOperatorTest {

    @ParameterizedTest
    @DisplayName("발행 로또와 당첨 번호 비교 카운트 등수 확인")
    @CsvSource(value = {
            "1,NO_LUCK",
            "2,NO_LUCK",
            "3,THREE",
            "4,FOUR",
            "5,FIVE",
            "6,SIX"
    })
    void matchLottoRank(int count, LottoOperator findRank) {
        assertThat(LottoOperator.find(count)).isEqualTo(findRank);
    }
}
