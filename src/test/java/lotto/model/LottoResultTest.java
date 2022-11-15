package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    void 당첨_갯수_테스트(){
        LottoResult lottoResult = new LottoResult();
        int count = lottoResult.compareLottoWinningNumber(Arrays.asList(1,2,3,4,5,6), Set.of(1,2,3,4,5,7));
        assertThat(count).isEqualTo(5);
    }
}