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
    Long money = 10000L;
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


    @DisplayName("번호 일치, 보너스 일치는 당첨이다")
    @Test
    void winNumberWinBonus(){
        LottoRaffleService lottoRaffleService = new LottoRaffleService(lottoWinning);
        Assertions.assertThat(lottoRaffleService.findPrize(3, true)).isNotEmpty();
    }

    @DisplayName("번호 일치, 보너스 불일치 당첨이다")
    @Test
    void winNumberLostBonus(){
        LottoRaffleService lottoRaffleService = new LottoRaffleService(lottoWinning);
        Assertions.assertThat(lottoRaffleService.findPrize(3, false)).isNotEmpty();
    }

    @DisplayName("번호 불일치, 보너스 일치 낙첨이다")
    @Test
    void LostNumberWinBonus(){
        LottoRaffleService lottoRaffleService = new LottoRaffleService(lottoWinning);
        Assertions.assertThat(lottoRaffleService.findPrize(1, true)).isEmpty();
    }

    @DisplayName("번호 불일치, 보너스 불일치 낙첨이다")
    @Test
    void LostNumberLostBonus(){
        LottoRaffleService lottoRaffleService = new LottoRaffleService(lottoWinning);
        Assertions.assertThat(lottoRaffleService.findPrize(2, false)).isEmpty();
    }


}