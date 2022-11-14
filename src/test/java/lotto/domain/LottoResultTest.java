package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("주어진 매개변수로 올바른 LottoResult enum을 반환하는지 확인")
    @Test
    void createLottoResult() {
        LottoResult secondResult = LottoResult.of(5, true);
        LottoResult elseResult = LottoResult.of(0, false);
        assertThat(secondResult.isSecond()).isTrue();
        assertThat(elseResult.isElse()).isTrue();
    }

    @DisplayName("주어진 로또 결과를 토대로 상금을 계산")
    @Test
    void sumWinnerPrice() {
        List<LottoResult> lottoResults = List.of(
                LottoResult.SECOND,
                LottoResult.ELSE,
                LottoResult.THIRD,
                LottoResult.SECOND);
        assertThat(LottoResult.sumWinnerPrice(lottoResults)).isEqualTo(61500000);
    }
}