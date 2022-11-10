package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    public void 구입_금액에_알맞는_개수의_로또_생성() {
        //given
        int lottoPurchasedAmount = 10_000;

        //when
        Lottos lottos = Lottos.from(lottoPurchasedAmount);

        //then
        Assertions.assertThat(lottos.size()).isEqualTo(10);
    }


}