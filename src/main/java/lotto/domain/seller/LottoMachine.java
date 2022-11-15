package lotto.domain.seller;

import java.util.List;
import lotto.domain.lotto.LottoRanking;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.LottoCount;

public class LottoMachine implements Seller {

    private final WinningLotto winningLotto;

    public LottoMachine(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public int compareNumbers(List<Integer> numbers) {
        List<Integer> winningLottoNumbers = winningLotto.getLotto().getNumbers();
        int count = 0;
        for (int number : numbers) {
            if (winningLottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean compareBonusNumber(List<Integer> numbers) {
        return numbers.contains(winningLotto.getBonus());
    }

    @Override
    public LottoRanking findLottoRanking(LottoCount lottoCount) {
        return LottoRanking.of(lottoCount);
    }

    @Override
    public int calculateTotalWinningAmount(List<LottoRanking> lottoRankings) {
        int amount = 0;
        for (LottoRanking lottoRanking : lottoRankings) {
            amount += lottoRanking.getWinningAmount();
        }
        return amount;

    }
}
