package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRaffleRecord;
import lotto.model.LottoWinning;
import lotto.service.LottoPublishService;
import lotto.service.LottoRaffleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoRaffleServiceTest {
    /**
     * init Test
     * */
    int money = 10000;
    LottoPublishService lottoPublishService = new LottoPublishService();
    List<Lotto> lottos = lottoPublishService.publish(money);

    Lotto Lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
    int bonus = 9;

    LottoWinning lottoWinning = new LottoWinning.Builder()
            .winLotto(Lotto)
            .winBonus(bonus)
            .build();

    @DisplayName("로또 추첨 결과를 5개 반환한다.")
    @Test
    void lottoRaffleTest() {
        LottoRaffleService lottoRaffleService = new LottoRaffleService(lottoWinning);
        LottoRaffleRecord lottoRaffleRecord = lottoRaffleService.raffle(lottos);
        Assertions.assertThat(lottoRaffleRecord.getPrizeRecord().size()).isEqualTo(5);
    }

}