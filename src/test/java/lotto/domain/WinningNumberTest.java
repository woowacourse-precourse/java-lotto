package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumberTest {
    @CsvSource(value = {"1,3,2,5,7,6:FIRST", "1,2,3,4,5,6:SECOND", "8,9,10,11,12,13:MISS"}, delimiter = ':')
    @ParameterizedTest
    void 구매한_로또와_비교해서_결과를_반환한다(String numbers, Ranking ranking) {
        WinningNumber winningNumber = new WinningNumber("1,2,3,5,6,7", 4);
        Lotto lotto = new Lotto(numbers);

        Assertions.assertThat(winningNumber.compare(lotto)).isEqualTo(ranking);
    }
}
