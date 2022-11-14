package lotto;

import lotto.config.LottoPrize;

import java.util.*;

public class LottoRaffler {

    private final LottoRaffleRecord lottoRaffleRecord;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoRaffler(List<Integer> winningNumbers, int bonusNumber) {
        this.lottoRaffleRecord = new LottoRaffleRecord();

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
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
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
