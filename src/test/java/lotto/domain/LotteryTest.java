package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    void createLottos() {
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3)
                , LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(5),LottoNumber.lottoNumber(6));
        List<Lotto> expected = List.of(new Lotto(lottoNumbers), new Lotto(lottoNumbers));
        ConstantCreateStrategy testStrategy = new ConstantCreateStrategy();
        int buyLottos = 2;

        Lottery lottery = new Lottery();
        lottery.createLottery(buyLottos, testStrategy);

        assertThat(lottery.getLottery()).isEqualTo(expected);
    }

    @Test
    @DisplayName("랭크의 종류와 나온 수를 Map으로 반환한다.")
    void rankResult() {

        List<LottoNumber> lottoNumbers2 = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3)
                , LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(41), LottoNumber.lottoNumber(43));
        WinningLotto winningLotto = new WinningLotto(lottoNumbers2, LottoNumber.lottoNumber(41));


        int buyLottos = 2;
        ConstantCreateStrategy lottoCreateStrategy = new ConstantCreateStrategy();
        Lottery lottery = new Lottery();
        lottery.createLottery(buyLottos, lottoCreateStrategy);
        Map<Rank, Integer> rankResult = lottery.RankResult(winningLotto);

        assertThat(rankResult.getOrDefault(Rank.FOURTH, 0)).isEqualTo(2);
    }

}
