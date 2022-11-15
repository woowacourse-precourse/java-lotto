package lotto.domain;

import lotto.Lotto;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoComparator {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Integer> lottoNumbers;

    public LottoComparator(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getNumberMatchesLottoNumber(int numberMatchesCount) {
        return getNumberMatchesLottoNumber(numberMatchesCount, false);
    }

    public int getNumberMatchesLottoNumber(int numberMatchesCount, boolean includeBonus) {
        int result = 0;
        for (Lotto lotto : lottos) {
            int matches = 0;
            lottoNumbers = lotto.getNumbers();
            matches = countMatches(lottoNumbers);
            result += countResult(numberMatchesCount, includeBonus, matches);
        }
        return result;
    }

    private int countMatches(List<Integer> lottoNumbers) {
        int matches = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matches++;
            }
        }
        return matches;
    }

    private int countResult(int numberMatchesCount, boolean includeBonus, int matches) {
        int result = 0;
        if (includeBonus) {
            if (numberMatchesCount == matches && lottoNumbers.contains(bonusNumber)) {
                return ++result;
            }
        }
        if (numberMatchesCount == matches) {
            return ++result;
        }
        return result;
    }

    public double calculateMargin(AtomicInteger totalWinningAmount) {
        int purchaseAmount = lottos.size() * 1000;
        double margin = (double) totalWinningAmount.intValue() / (double) purchaseAmount * 100;
        double roundedMargin = Math.round(margin * 10) / 10.0;
        return roundedMargin;
    }
}
