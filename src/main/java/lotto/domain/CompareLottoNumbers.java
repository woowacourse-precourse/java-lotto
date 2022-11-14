package lotto.domain;

import java.util.List;

import static lotto.domain.LottoNumber.getBonusNumber;

public class CompareLottoNumbers {
    private static final int LOTTO_MAX = 6;
    private static final int FIT_FIVE = 5;
    private static final int FIT_FOUR = 4;
    private static final int FIT_THREE = 3;

    public static int compareNumbers(List<Integer> myLotto, List<Integer> randomLottoes, int bonus) {
        int fit = 0;
        for (int i = 0; i < myLotto.size(); i++) {
            if (isThisInList(myLotto, randomLottoes.get(i)))
                fit++;
        }
        return rankOfThisRound(fit, randomLottoes, bonus);
    }

    private static boolean isThisInList(List<Integer> myLotto, int randomLottoNum) {
        if (myLotto.contains(randomLottoNum))
            return true;
        return false;
    }

    private static int rankOfThisRound(int fit, List<Integer> randomLottoes, int bonus) {
        if (fit == LOTTO_MAX)
            return 1;
        if (fit == FIT_FIVE && randomLottoes.contains(bonus))
            return 2;
        if (fit == FIT_FIVE)
            return 3;
        if (fit == FIT_FOUR)
            return 4;
        if (fit == FIT_THREE)
            return 5;
        return 0;
    }
}
