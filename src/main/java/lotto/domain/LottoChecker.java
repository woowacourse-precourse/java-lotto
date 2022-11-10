package lotto.domain;

import lotto.Lotto;
import lotto.WinningLotto;

import java.util.List;

public class LottoChecker {
    public String compare(Lotto userLotto, WinningLotto winningLotto){
        List<Integer> lotto = userLotto.getNumbers();
        Lotto winningNumbers = winningLotto.getWinningNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        int sameCount = 0;

        for (Integer number : lotto) {
            if(winningNumbers.getNumbers().contains(number)){
                sameCount++;
            }
        }

        if(isCorrectBonusNumber(lotto, bonusNumber, sameCount)){
            return "5개 일치, 보너스 볼 일치 (30,000,000원)";
        }
        return Integer.toString(sameCount) + "개 일치";
    }

    private boolean isCorrectBonusNumber(List<Integer> lotto, int bonusNumber, int sameCount) {
        return sameCount == 5 && lotto.contains(bonusNumber);
    }
}
