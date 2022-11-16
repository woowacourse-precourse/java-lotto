package lotto.service;

import lotto.config.LottoPrize;
import lotto.model.Lotto;
import lotto.model.LottoRaffleRecord;
import lotto.model.LottoWinning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRaffleService {

    private final LottoRaffleRecord lottoRaffleRecord;
    private final LottoWinning lottoWinning;

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

        List<LottoPrize> result = findPrize(matchCount, matchBonus);
        if (!result.isEmpty()) {
            lottoRaffleRecord.updatePrizeRecord(result.get(0));
        }
    }

    public List<LottoPrize> findPrize(int count, boolean bonus) {
        List<LottoPrize> result = findCountAndBonusMatch(count, bonus);
        if (!result.isEmpty()) {
            return result;
        }
        return findCountMatch(count);
    }

    private List<LottoPrize> findCountMatch(int count) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.getMatchCount() == count)
                .collect(Collectors.toList());
    }

    private List<LottoPrize> findCountAndBonusMatch(int count, boolean bonus) {
        return Arrays.stream(LottoPrize.values())
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
