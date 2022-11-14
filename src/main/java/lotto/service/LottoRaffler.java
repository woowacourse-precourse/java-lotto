package lotto.service;

import lotto.config.LottoPrize;
import lotto.model.Lotto;
import lotto.model.LottoWinning;

import java.util.*;

public class LottoRaffler {

    private final LottoRaffleRecord lottoRaffleRecord;
    private final LottoWinning lottoWinning;

    public LottoRaffler(LottoWinning lottoWinning) {
        this.lottoRaffleRecord = new LottoRaffleRecord();
        this.lottoWinning = lottoWinning;
    }

    public Map<String, Integer> raffle(List<Lotto> lottos) {
        lottos.forEach(lotto -> recordPrize(lotto.getNumbers()));
        return lottoRaffleRecord.getPrizeRecord();
    }

    private void recordPrize(List<Integer> lottoNumbers) {
        int matchCount = checkLottoNumbers(lottoNumbers);
        boolean matchBonus = checkBonusNumber(lottoNumbers);

        String prize = LottoPrize.findByMatchAndBonus(matchCount, matchBonus).name();
        lottoRaffleRecord.updatePrizeRecord(prize);
    }

    private int checkLottoNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(lottoWinning.getWinLotto().getNumbers()::contains).count();
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(lottoWinning.getWinBonus());
    }
}
