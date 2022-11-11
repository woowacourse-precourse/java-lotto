package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {

    @Test
    void 수익률_테스트(){
        LottoChecker lottoChecker = new LottoChecker();
        assertThat(lottoChecker.profitRate(8000,5000)).isEqualTo(62.5);
    }
}