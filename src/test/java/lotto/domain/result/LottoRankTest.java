package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {
    @CsvSource(value = {
            "0 : False : FAIL",
            "6 : False : FIRST",
            "2 : True : FAIL",
            "4 : True : FOURTH",
            "5 : True : SECOND",
            "5 : False : THIRD",
            "3 : False : FIFTH",
            "0 : True : FAIL",
            "4 : False : FOURTH"
    }, delimiter = ':')
    @ParameterizedTest
    void 로또_매칭_개수를_이용하여_등수를_확인한다(int matchingCount, boolean bonusNumberMatching, LottoRank expected) {
        LottoRank result = LottoRank.getLottoRankResult(matchingCount, bonusNumberMatching);

        assertThat(result).isEqualTo(expected);
    }
}