package lotto.domain;

import lotto.Utils;
import lotto.exception.winningNums.BonusNumDuplicatedException;
import lotto.exception.winningNums.InputNumRangeException;
import lotto.exception.winningNums.InputNumsDuplicatedException;
import lotto.exception.winningNums.InputPatternWrongException;

import java.util.Comparator;
import java.util.List;

import static lotto.Utils.PATTERN;
import static lotto.Utils.separateNums;
import static lotto.Validator.*;

public class WinningNums {
    private final List<Integer> winningNums;
    private final int bonusNum;

    public WinningNums(String winNums, String bonusNum) {
        this.winningNums = validateWinNums(winNums);
        this.bonusNum = validateBonusNum(bonusNum);
    }

    public List<Integer> validateWinNums(String winNums) {
        if (!PATTERN.matcher(winNums).matches()) {
            throw new InputPatternWrongException();
        }
        List<Integer> nums = separateNums(winNums);
        nums.sort(Comparator.naturalOrder());

        if (!isNotDuplicate(nums)) {
            throw new InputNumsDuplicatedException();
        }
        if (!isInRangeAll(nums)) {
            throw new InputNumRangeException();
        }
        return nums;
    }

    public int validateBonusNum(String bonusNum) {
        int num = Utils.textToNumber(bonusNum);
        if (!isInRange(num)) {
            throw new InputNumRangeException();
        }
        if (!isNotContains(winningNums, num)) {
            throw new BonusNumDuplicatedException();
        }
        return num;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}

