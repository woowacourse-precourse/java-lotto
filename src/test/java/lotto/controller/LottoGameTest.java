package lotto.controller;

import static lotto.utils.Constants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGameTest {
    @DisplayName("구매 금액 1,000원 당 한 장씩의 로또를 생성한다.")
    @Test
    void 구매금액에_맞는_개수의_로또_생성() {
        List<Lotto> lottos = LottoGame.generateLottoByPurchaseAmount(LOTTO_PRICE * 7);
        int lottoCount = lottos.size();

        assertThat(lottoCount).isEqualTo(7);
    }
}