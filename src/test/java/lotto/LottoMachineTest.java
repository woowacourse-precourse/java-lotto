package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.LottoMachine.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("로또는 1000원 당 1개를 구매해야 한다.")
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

    @DisplayName("1등이 3번이면 map에 해당 키 값의 밸류가 3이어야한다.")
    @Test
    void 몇_등이_몇_번_나오는지_테스트(){
        //given
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        LottoMachine lottoMachine = new LottoMachine();
        //when
        Map<Rank, Integer> rankResult = lottoMachine.makeRankResult(lottos,winningNumber, bonusNumber);
        //then
        assertThat(rankResult.get(Rank.FIRST)).isEqualTo(3);
    }
}
