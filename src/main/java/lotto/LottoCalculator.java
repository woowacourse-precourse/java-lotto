package lotto;

import lotto.Lotto;
import lotto.print.*;
import java.util.List;
import java.util.Optional;

import java.util.List;

public class LottoCalculator  {

    private static final int LOTTO_WIN_SIZE = 6;

    public static long countMatchLottoNumber (Lotto userLottoNumbers,
                                             List<Integer> inputUserWinningNumber) {

        return userLottoNumbers.getNumbers().stream().filter(inputUserWinningNumber::contains).count();
    }

    public static int[] calculateRank(Lotto winningNumbers,
                                                    int winBonusNumber, List<Integer> inputUserWinningNumber, int[] countWinPrize) {
        long matchCount = countMatchLottoNumber(winningNumbers, inputUserWinningNumber);
        return LottoRank.getLottoRank((int) matchCount, winningNumbers.getNumbers().contains(winBonusNumber),countWinPrize);
    }

}
