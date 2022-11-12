package lotto;

import java.util.List;

public class LottoDraw {
    public static LottoRank getLottoRank(Lotto lotto, WinLotto winLotto) {
        int winNumber = getWinNumber(lotto, winLotto);
        boolean existBonusNumber = existBonusNumber(lotto, winLotto);

        if (winNumber == 6) {
            return LottoRank.FIRST;
        } else if (winNumber == 5 && existBonusNumber) {
            return LottoRank.SECOND;
        } else if (winNumber == 5) {
            return LottoRank.THIRD;
        } else if (winNumber == 4) {
            return LottoRank.FOURTH;
        } else if (winNumber == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.LOSE;
    }

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

    private static boolean existBonusNumber(Lotto lotto, WinLotto winLotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        int bonusNumber = winLotto.getBonusNumber();

        return lottoNumbers.contains(bonusNumber);
    }
}
