package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    @DisplayName("로또 금액에 맞는 로또 개수가 출력된다.")
    @Test
    void lottoCountTest() {
        assertThat(new LottoGame()
                .countLotto(100000))
                .isEqualTo(100);
    }

    @DisplayName("당첨된 로또의 수익이 맞게 계산된다.")
    @Test
    void calculateProfitTest() {
        List<Integer> lottoResults = Arrays.asList(0, 0, 0, 2, 1, 0, 1);
        LottoGame lottoGame = new LottoGame(lottoResults, 3);
        lottoGame.setRateOfReturn();

        assertThat(lottoGame.profitRateResult()).isEqualTo("총 수익률은 66668666.7%입니다.");

    }
}