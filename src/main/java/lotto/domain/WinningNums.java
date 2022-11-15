package lotto.domain;

import lotto.Utils;

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
            throw new IllegalArgumentException("[ERROR] 입력하신 문자열의 패턴이 올바르지 않습니다.");
        }
        List<Integer> nums = separateNums(winNums);
        nums.sort(Comparator.naturalOrder());

        if (!isNotDuplicate(nums)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
        if (!isInRangeAll(nums)) {
            throw new IllegalArgumentException("[ERROR] 1-45까지의 숫자만 입력해야 합니다.");
        }
        return nums;
    }

    public int validateBonusNum(String bonusNum) {
        int num = Utils.textToNumber(bonusNum);
        if (!isInRange(num)) {
            throw new IllegalArgumentException("[ERROR] 1-45까지의 숫자만 입력해야 합니다.");
        }
        if (!isNotContains(winningNums, num)) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자와 보너스 숫자가 중복됩니다.");
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

