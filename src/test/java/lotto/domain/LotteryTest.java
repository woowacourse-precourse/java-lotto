package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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
    @DisplayName("랭크의 종류와 나온 수를 Map으로 반환한다.")
    void rankResult() {

        List<LottoNumber> lottoNumbers2 = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                , new LottoNumber(4), new LottoNumber(41), new LottoNumber(43));
        WinningLotto winningLotto = new WinningLotto(new Lotto(lottoNumbers2), new LottoNumber(41));


        int buyLottos = 2;
        ConstantCreateStrategy lottoCreateStrategy = new ConstantCreateStrategy();
        List<Lotto> lottos = new Lottery().createLottery(buyLottos, lottoCreateStrategy);

        Lottery lottery = new Lottery();
        Map<Rank, Integer> rankResult = lottery.RankResult(winningLotto, lottos);

        assertThat(rankResult.getOrDefault(Rank.FOURTH, 0)).isEqualTo(2);
    }

}
