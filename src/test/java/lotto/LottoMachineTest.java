package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoMachine.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 로또_3개_구입(){
        //given
        int money = 3000;
        LottoMachine lottoMachine = new LottoMachine();
        //when
        List<Lotto> buyLotto = lottoMachine.buy(money);
        //then
        assertThat(buyLotto.size()).isEqualTo(money/LOTTO_PRICE);
    }
}
