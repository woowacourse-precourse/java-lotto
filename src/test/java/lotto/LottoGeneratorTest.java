package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Cashier;
import lotto.model.LottoGenerator;

class LottoGeneratorTest {

    @DisplayName("받은 금액을 1000으로 나눈 값과 로또의 수량이 일치하면 통과한다.")
    @Test
    void createLottos_받은금액나누기1000과로또수량이일치() {
        int ReceivedMoney = 10000;
        List<List<Integer>> newLottoNumber = new LottoGenerator().createLottos(ReceivedMoney);
        assertThat(newLottoNumber.size()).isEqualTo(ReceivedMoney / 1000);
    }

    @DisplayName("첫번째로 생성된 로또 배열이 6자리로 이뤄져있는지 확인")
    @Test
    void createLottos_로또한장이6자리인지() {
        int ReceivedMoney = 10000;
        int 로또한장은6개의숫자 = 6;
        List<List<Integer>> newLottoNumber = new LottoGenerator().createLottos(ReceivedMoney);
        assertThat(newLottoNumber.get(0).size()).isEqualTo(로또한장은6개의숫자);
    }

    @DisplayName("받은 금액이 음수의 금액이라면 에러를 발생한다.")
    @Test
    void createLottos_받은금액이음수() {
        assertThatThrownBy(() -> new Cashier().inputPlayerMoney("-1000"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
