package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("발급된 로또의 수는 구입 수량과 같다.")
    void 로또의_수는_구입_수량과_동일() {
        int purchaseMoney = 5000;
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney);
        List<Lotto> lottos = lottoMachine.getLottos();

        assertThat(lottos.size()).isEqualTo(purchaseMoney / Lotto.LOTTO_TICKET_PRICE);
    }

    @Test
    @DisplayName("발급된 로또는 6개의 수로 이루어진다.")
    void 로또는_6개의_숫자() {
        int purchaseMoney = 1000;
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney);
        List<Lotto> lottos = lottoMachine.getLottos();

        assertThat(lottos.get(0).getLottoNumbers().size()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또 기계는 구입 개수와 보유 로또 번호를 출력할 수 있다.")
    void 로또_출력() {
        int purchaseMoney = 1000;
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney);
        assertThat(lottoMachine.toString())
                .isEqualTo("1개를 구매했습니다.\n" + lottoMachine.getLottos().get(0).toString());
    }
}