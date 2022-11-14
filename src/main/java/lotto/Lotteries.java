package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    public static final String ENTER = "\n";
    private List<Lotto> lotteries = new ArrayList<>();

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries.addAll(lotteries);
    }

    public String getLottoNumbers() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lotteries) {
            stringBuilder.append(lotto.getNumbersToString() + ENTER);
        }

        return stringBuilder.toString();
    }

    public LottoResult countMatchNumbers(WinNumbers winNumbers) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lotteries) {
            int countOfWinningNumbers = lotto.matchCountOfWinningNumbers(winNumbers.getWinNumbers());
            boolean matchBonusNumber = lotto.isMatchBonusNumber(winNumbers.getBonusNumber());

            Match match = Match.getMatch(countOfWinningNumbers, matchBonusNumber);
            lottoResult.plusLottoResult(match);
        }

        return lottoResult;
    }
}
