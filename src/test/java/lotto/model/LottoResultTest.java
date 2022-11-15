package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 당첨번호_테스트(){
        String number = "1,2,3,4,5,6";
        LottoResult lottoResult = new LottoResult(number);
        assertThat(lottoResult.getWinningNumbers()).contains(1,2,3,4,5,6);
    }
}