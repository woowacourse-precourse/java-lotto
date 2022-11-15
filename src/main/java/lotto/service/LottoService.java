package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.List;
import java.util.Map;

import static lotto.constants.Constants.DEFAULT_VALUE;
import static lotto.constants.Constants.WIN_AMOUNT;

public class LottoService {

    public void buyLotto(Buyer buyer) {
        buyer.buyLotto(buyer.getMoney());
    }

    public void checkLottos(Buyer buyer, WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = buyer.getResult();
        for (Lotto lotto : buyer.getLottos()) {
            Rank rank = checkRank(winningNumbers, lotto);
            result.put(rank, result.getOrDefault(rank, DEFAULT_VALUE) + WIN_AMOUNT);
        }
    }

    private Rank checkRank(WinningNumbers winningNumbers, Lotto lotto) {
        int count = countSameNumber(winningNumbers.getWinningLotto(), lotto.getLotto());
        boolean bonusNumber = containsBonusNumber(winningNumbers, lotto);
        Rank rank = Rank.values()[count];
        if (rank == Rank.THIRD && bonusNumber) {
            return Rank.SECOND;
        }
        return rank;
    }

    private int containsNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            return WIN_AMOUNT;
        }
        return DEFAULT_VALUE;
    }

    private int countSameNumber(List<Integer> userLotto, List<Integer> winningLotto) {
        int count = DEFAULT_VALUE;
        for (int number : winningLotto) {
            count += containsNumber(userLotto, number);
        }
        return count;
    }

    private boolean containsBonusNumber(WinningNumbers winningNumbers, Lotto lotto) {
        return lotto.getLotto().contains(winningNumbers.getBonusNumber());
    }
}
