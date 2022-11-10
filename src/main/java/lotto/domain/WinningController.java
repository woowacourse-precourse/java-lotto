package lotto.domain;

import lotto.Lotto;
import lotto.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningController {
    static final int BonusNumberIndex = 7;
    private Map<WinningStandard, Integer> lottoWinningResultMap = new HashMap<>();

    public void compare(Lotto lotto, WinningLotto winningLotto){
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        final int bonusNumber = winningLottoNumbers.get(BonusNumberIndex);
        int correctNumbers = 0;
        boolean isCorrectBonusNumber = false;
        for(int number : lotto.getNumbers()){
            if(number == bonusNumber){
                isCorrectBonusNumber = true;
                continue;
            }
            if(winningLottoNumbers.contains(number)){
                correctNumbers++;
            }
        }
    }
}
