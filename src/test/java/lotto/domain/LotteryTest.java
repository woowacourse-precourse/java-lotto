package lotto.domain;

import lotto.domain.ConstantCreateStrategy;
import lotto.domain.Lottery;
import lotto.domain.Lotto;
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

}
