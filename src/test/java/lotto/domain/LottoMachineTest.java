package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    int purchaseMoney;
    LottoMachine lottoMachine;

    @BeforeEach
    void setup() {
        purchaseMoney = 2000;
        lottoMachine = new LottoMachine(purchaseMoney);
    }

    @Test
    @DisplayName("발급된 로또의 수는 구입 수량과 같다.")
    void 로또의_수는_구입_수량과_동일() {
        List<Lotto> lottos = lottoMachine.getLottos();

        assertThat(lottos.size()).isEqualTo(purchaseMoney / Lotto.LOTTO_TICKET_PRICE);
    }

    @Test
    @DisplayName("발급된 로또는 6개의 수로 이루어진다.")
    void 로또는_6개의_숫자() {
        List<Lotto> lottos = lottoMachine.getLottos();

        assertThat(lottos.get(0).getLottoNumbers().size()).isEqualTo(Lotto.LOTTO_SIZE);
    }
}