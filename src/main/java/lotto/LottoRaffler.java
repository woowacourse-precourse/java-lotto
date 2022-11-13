package lotto;

import lotto.config.LottoRules;

import java.util.*;

public class LottoRaffler {

    private final LottoRaffleRecorder lottoRaffleRecorder;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoRaffler(List<Integer> winningNumbers, int bonusNumber) {
        this.lottoRaffleRecorder = new LottoRaffleRecorder();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> raffle(List<Lotto> lottos) {
        lottos.forEach(lotto -> recordPrize(lotto.getNumbers()));
        return lottoRaffleRecorder.getPrizeRecord();
    }

    private void recordPrize(List<Integer> lottoNumbers) {
        int matchCount = checkWinningNumbers(lottoNumbers);
        boolean matchBonus = checkBonusNumber(lottoNumbers);

        String prize = LottoRules.findByMatchAndBonus(matchCount, matchBonus).name();
        lottoRaffleRecorder.updatePrizeRecord(prize);
    }

    private int checkWinningNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
