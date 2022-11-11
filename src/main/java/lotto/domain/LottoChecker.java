package lotto.domain;

import lotto.Lotto;
import lotto.WinningLotto;

import java.util.List;

public class LottoChecker {
    public int lottoCompare(Lotto userLotto, WinningLotto winningLotto){
        List<Integer> lotto = userLotto.getNumbers();
        Lotto winningNumbers = winningLotto.getWinningNumbers();
        int sameCount = 0;

        for (Integer number : lotto) {
            if(winningNumbers.getNumbers().contains(number)){
                sameCount++;
            }
        }
        return sameCount;
    }

    public boolean bonusCompare(Lotto userLotto, WinningLotto winningLotto){
        return userLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
}
