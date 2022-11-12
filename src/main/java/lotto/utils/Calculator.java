package lotto.utils;

import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.model.Rank.SECOND_PLACE;
import static lotto.model.Rank.THIRD_PLACE;
import static lotto.model.Rank.findRankWithcount;
import static lotto.model.Rank.findcountWithRank;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class Calculator {
    public static Rank calculateLottoRank(Lotto customerLotto, List<Integer> winningNumber, int bonusNumber) {
        int count = calculateDuplicateNumberCount(customerLotto, winningNumber);
        if (count == findcountWithRank(THIRD_PLACE) && isLottoContainBonusNumber(customerLotto, bonusNumber)) {
            return SECOND_PLACE;
        }
        return findRankWithcount(count);
    }

    private static int calculateDuplicateNumberCount(Lotto customerLotto, List<Integer> winningNumber) {
        int count = 0;
        for (int i = 0; i < VALID_LOTTERY_NUMBER_LENGTH; i++) {
            if (customerLotto.isContain(winningNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLottoContainBonusNumber(Lotto customerLotto, int bonusNumber) {
        return customerLotto.isContain(bonusNumber);
    }
}
