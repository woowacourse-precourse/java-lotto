package lotto.service;

import lotto.config.LottoPrizeRules;
import lotto.model.Lotto;
import lotto.model.LottoRaffleRecord;
import lotto.model.LottoWinning;

import java.util.*;

import static lotto.config.Constants.LottoPrizeFilter.NOT_ALLOWED_RECORD_PRIZE;

public class LottoRaffleService {

    private LottoRaffleRecord lottoRaffleRecord;
    private LottoWinning lottoWinning;

    public LottoRaffleService(LottoWinning lottoWinning) {
        this.lottoRaffleRecord = new LottoRaffleRecord();
        this.lottoWinning = lottoWinning;
    }

    public LottoRaffleRecord raffle(List<Lotto> lottos) {
        lottos.forEach(lotto -> recordPrize(lotto.getNumbers()));
        return lottoRaffleRecord;
    }

    private void recordPrize(List<Integer> lottoNumbers) {
        int matchCount = checkLottoNumbers(lottoNumbers);
        boolean matchBonus = checkBonusNumber(lottoNumbers);

        String prize = LottoPrizeRules.findByMatchAndBonus(matchCount, matchBonus).name();

        if (checkRecordAllowed(prize)) {
            lottoRaffleRecord.updatePrizeRecord(prize);
        }
    }

    private int checkLottoNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(lottoWinning.getWinLotto().getNumbers()::contains).count();
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(lottoWinning.getWinBonus());
    }

    private boolean checkRecordAllowed(String prize) {
        if (NOT_ALLOWED_RECORD_PRIZE.contains(prize)) {
            return false;
        }
        return true;
    }
}
