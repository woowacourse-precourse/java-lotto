package lotto.game.service;

import static lotto.game.LottoConst.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.game.domain.Lotto;
import lotto.game.domain.LottoGrade;
import lotto.game.domain.Money;
import lotto.game.domain.WinningLotto;

public class LottoService {
    public List<Lotto> buyLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        long lottoCount = money.getValue() / 1000;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<LottoGrade> confirmAllLottos(WinningLotto winningLotto, List<Lotto> lottos) {
        List<LottoGrade> winnings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoGrade lottoGrade = confirmWinning(winningLotto, lotto);
            if (lottoGrade != LottoGrade.NOTHING) {
                winnings.add(lottoGrade);
            }
        }
        return winnings;
    }

    public LottoGrade confirmWinning(WinningLotto winningLotto, Lotto lotto) {
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

    public String calculateProfitPercent(Money spentMoney, Money profit) {
        return String.format("%,.1f%%", (double) profit.getValue() / spentMoney.getValue() * 100);
    }

    public Money calculateTotalProfit(List<LottoGrade> grades) {
        return grades.stream()
                .map(LottoGrade::getPrize)
                .reduce(Money::add)
                .orElse(Money.ZERO);
    }
}
