package lotto.domain;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_NUMS_SIZE;
import static lotto.domain.Utils.PATTERN;
import static lotto.domain.Utils.separateNums;

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
        if (!isNotDuplicate(nums)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
        return separateNums(winNums);
    }

    public int validateBonusNum(String bonusNum) {
        int num = Integer.parseInt(bonusNum);
        if (!isInRange(num)) {
            throw new IllegalArgumentException("[ERROR] 1-45까지의 숫자만 입력해야 합니다.");
        }
        if (!isNotContains(winningNums, num)) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자와 보너스 숫자가 중복됩니다.");
        }
        return num;
    }

    public boolean isInRange(int number) {
        return 1 <= number && number <= 45;
    }

    public boolean isNotContains(List<Integer> nums, int num) {
        return !nums.contains(num);
    }

    public boolean isNotDuplicate(List<Integer> nums) {
        return nums.stream()
                .distinct()
                .count() == LOTTO_NUMS_SIZE;
    }
}

