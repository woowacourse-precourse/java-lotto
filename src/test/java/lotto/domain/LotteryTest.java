package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    void createLottos() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        List<Lotto> expected = List.of(new Lotto(lottoNumbers), new Lotto(lottoNumbers));
        ConstantCreateStrategy testStrategy = new ConstantCreateStrategy();
        int buyLottos = 2;

        List<Lotto> lottos = new Lottery().createLottery(buyLottos, testStrategy);

        assertThat(lottos).isEqualTo(expected);
    }

    @Test
    @DisplayName("일치하는 수에 따라 랭크를 반환한다.")
    void ranks() {

        List<LottoNumber> lottoNumbers2 = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(41), new LottoNumber(43));
        Lotto winningLotto = new Lotto(lottoNumbers2);

        int buyLottos = 2;
        ConstantCreateStrategy lottoCreateStrategy = new ConstantCreateStrategy();
        List<Lotto> lottos = new Lottery().createLottery(buyLottos, lottoCreateStrategy);

        Lottery lottery = new Lottery();
        List<Rank> ranks = lottery.ranks(winningLotto,lottos);

        assertThat(ranks).contains(Rank.FOURTH);
    }

}
