package lotto.game.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.game.domain.Lotto;
import lotto.game.domain.LottoGrade;
import lotto.game.domain.Money;
import lotto.game.domain.WinningLotto;

public class LottoService {
    public List<Lotto> buyLotto(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        long lottoCount = money.getValue() / 1000;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<LottoGrade> confirmAllLottos(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoGrade> winnings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoGrade lottoGrade = winningConfirm(winningLotto, lotto);
            if (lottoGrade != LottoGrade.NOTHING) {
                winnings.add(lottoGrade);
            }
        }
        return winnings;
    }

    public LottoGrade winningConfirm(WinningLotto winningLotto, Lotto lotto) {
        boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        int matchCount = 0;
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return LottoGrade.confirmWinning(matchCount, bonusMatch);
    }

    public String calculateProfitPercent(Money money, List<LottoGrade> totalWinnings) {
        Money profit = calculateTotalProfit(totalWinnings);
        return String.format("%,.1f%%", (double) profit.getValue() / money.getValue() * 100);
    }

    private Money calculateTotalProfit(List<LottoGrade> grades) {
        return grades.stream()
                .map(Money::of)
                .reduce(Money::add)
                .orElse(Money.NO_MONEY);
    }
}
