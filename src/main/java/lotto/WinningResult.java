package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private Map<LottoRating, Integer> totalResult;

    public WinningResult(WinningLotto winningNumber, List<Lotto> lottos) {
        this.totalResult = conversionLotto(winningNumber, lottos);
    }

    private Map<LottoRating, Integer> conversionLotto(WinningLotto winningNumber, List<Lotto> lottos) {
        Map<LottoRating, Integer> totalResult = new EnumMap<>(LottoRating.class);
        totalResult.put(LottoRating.FIFTH, 0);
        totalResult.put(LottoRating.FOURTH, 0);
        totalResult.put(LottoRating.THIRD, 0);
        totalResult.put(LottoRating.SECOND, 0);
        totalResult.put(LottoRating.FIRST, 0);

        List<LottoRating> lottoResult = checkAllLotto(winningNumber, lottos);
        for (LottoRating lottoGrade : lottoResult) {
            if (lottoGrade != LottoRating.NOTHING) {
                totalResult.put(lottoGrade, totalResult.get(lottoGrade) + 1);
            }
        }

        return totalResult;
    }

    private List<LottoRating> checkAllLotto(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoRating> winningResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoRating lottoRating = check(winningLotto, lotto);
            if (lottoRating != LottoRating.NOTHING) {
                winningResult.add(lottoRating);
            }
        }

        return winningResult;
    }

    private LottoRating check(WinningLotto winningLotto, Lotto lotto) {
        boolean bonusNumber = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        int prizeOfMatch = 0;

        for (Integer number : lotto.getNumbers()) {
            if (winningLotto.getNumber().getNumbers().contains(number)) {
                prizeOfMatch++;
            }
        }
        return LottoRating.find(prizeOfMatch, bonusNumber);
    }

    public Integer getCount(LottoRating lottoRating) {
        return totalResult.getOrDefault(lottoRating, 0);
    }

    public double createProfit(String purchaseAmount) {
        double money = Double.parseDouble(purchaseAmount);
        long sum = 0;
        for (LottoRating key : totalResult.keySet()) {
            sum += totalResult.get(key) * key.getWinningMoney();
        }

        return sum / money * 100;
    }
}
