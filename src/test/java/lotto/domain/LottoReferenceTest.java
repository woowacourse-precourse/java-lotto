package lotto.domain;

import static lotto.domain.LottoReference.NOPE;
import static lotto.domain.LottoReference.THREE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoReferenceTest {

    @DisplayName("Get Yield")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @CsvSource(value = {"7,1", "6,2", "5,3"})
    void getYield(int nope, int three) {
        Map<LottoReference, Integer> result = new HashMap<>();

        result.put(NOPE, nope);
        result.put(THREE, three);

        float yield = (float) THREE.getPrize() * three / 8000 * 100;

        assertThat(LottoReference.getYield(result)).isEqualTo(yield);
    }
}