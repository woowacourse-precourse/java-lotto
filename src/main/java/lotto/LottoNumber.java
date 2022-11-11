package lotto;

import java.util.ArrayList;
import java.util.List;

import static constant.ErrorMessage.*;
import static constant.Constant.*;

public class LottoNumber {
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static int bonusNumber;

    public LottoNumber(String winningNumbers, String bonusNumber) {
        for (String num : winningNumbers.split(",")) {
            this.winningNumbers.add(validLottoNumber(num));
        }
        this.bonusNumber = validLottoNumber(bonusNumber);
    }

    private int validLottoNumber(String num) {
        try {
            return validNumberRange(Integer.parseInt(num));
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private int validNumberRange(int num) {
        if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
            System.out.println(NOT_LOTTO_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
        return num;
    }

    public static MatchCount getMatchResult(Lotto lotto) {
        int match = 0;
        int bonusMatch = 0;
        for (int idx=INITIAL_NUMBER; idx<LOTTO_SIZE; idx++) {
            if (lotto.getNumbers().contains(winningNumbers.get(idx))) {
                match++;
            }
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            bonusMatch++;
        }
        return new MatchCount(match, bonusMatch);
    }
}
