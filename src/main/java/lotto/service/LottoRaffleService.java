package lotto.service;

import lotto.config.LottoPrizeRules;
import lotto.model.Lotto;
import lotto.model.LottoRaffleRecord;
import lotto.model.LottoWinning;

import java.util.*;
import java.util.stream.Collectors;

public class LottoRaffleService {

    private LottoRaffleRecord lottoRaffleRecord;
    private LottoWinning lottoWinning;

    public LottoRaffleService(LottoWinning lottoWinning) {
        this.lottoRaffleRecord = new LottoRaffleRecord();
        this.lottoWinning = lottoWinning;
    }

    public LottoRaffleRecord raffle(List<Lotto> lottos) {
        lottos.forEach(lotto -> recordMatchPrize(lotto.getNumbers()));
        return lottoRaffleRecord;
    }

    private void recordMatchPrize(List<Integer> lottoNumbers) {
        int matchCount = checkMatchedNumbers(lottoNumbers);
        boolean matchBonus = checkBonusNumber(lottoNumbers);

        List<LottoPrizeRules> result = findPrize(matchCount, matchBonus);
        if (!result.isEmpty()) {
            lottoRaffleRecord.updatePrizeRecord(result.get(0));
        }
    }

    public List<LottoPrizeRules> findPrize(int count, boolean bonus) {
        List<LottoPrizeRules> result = findCountAndBonusMatch(count, bonus);
        if (!result.isEmpty()) {
            return result;
        }
        return findCountMatch(count);
    }

    private List<LottoPrizeRules> findCountMatch(int count) {
        return Arrays.stream(LottoPrizeRules.values())
                .filter(prize -> prize.getMatchCount() == count)
                .collect(Collectors.toList());
    }

    private List<LottoPrizeRules> findCountAndBonusMatch(int count, boolean bonus) {
        return Arrays.stream(LottoPrizeRules.values())
                .filter(prize -> prize.getMatchCount() == count && prize.getBonus() == bonus)
                .collect(Collectors.toList());
    }

    private int checkMatchedNumbers(List<Integer> lottoNumbers) {
        List<Integer> winningNumbers = lottoWinning.getWinLotto().getNumbers();
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(lottoWinning.getWinBonus());
    }
}
