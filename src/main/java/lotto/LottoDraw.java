package lotto;

import java.util.List;

public class LottoDraw {
    private static int getWinNumber(Lotto lotto, WinLotto winLotto) {
        int winNumber = 0;
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> winLottoNumbers = winLotto.getLottoNumbers();
        for (int number : lottoNumbers) {
            if (winLottoNumbers.contains(number)) {
                winNumber++;
            }
        }
        return winNumber;
    }
}
