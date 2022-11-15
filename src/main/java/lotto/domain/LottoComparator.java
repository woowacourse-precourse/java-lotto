package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoComparator {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

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
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer lottoNumber : lottoNumbers) {
                if (winningNumbers.contains(lottoNumber)) {
                    matches++;
                }
            }
            if (includeBonus) {
                if (numberMatchesCount == matches && lottoNumbers.contains(bonusNumber)) {
                    result++;
                }
                continue;
            }
            if (numberMatchesCount == matches) {
                result++;
            }
        }
        return result;
    }
}
