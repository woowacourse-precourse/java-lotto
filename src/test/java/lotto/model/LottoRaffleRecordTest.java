package lotto.model;

import lotto.config.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRaffleRecordTest {

    @DisplayName("LottoPrize를 기준으로 생성한 prizeRecord의 키값은 LottoPrize.values() 값과 같다.")
    @Test
    void initWithLottoPrize() {
        LottoRaffleRecord lottoRaffleRecord = new LottoRaffleRecord();

        LottoPrize[] lottoPrizes = LottoPrize.values();
        LottoPrize[] recordPrizes = lottoRaffleRecord.getPrizeRecord().keySet().toArray(new LottoPrize[0]);

        Assertions.assertThat(lottoPrizes).isEqualTo(recordPrizes);
    }

    @DisplayName("로또에 당첨되면, 해당 등수 기록에 1을 추가한다.")
    @Test
    void updatePrizeRecord() {
        LottoRaffleRecord lottoRaffleRecord = new LottoRaffleRecord();

        int before = lottoRaffleRecord.getPrizeRecord().get(LottoPrize.FIRST_PLACE);
        lottoRaffleRecord.updatePrizeRecord(LottoPrize.FIRST_PLACE);
        int after = lottoRaffleRecord.getPrizeRecord().get(LottoPrize.FIRST_PLACE);

        Assertions.assertThat(after).isEqualTo(before + 1);
    }
}