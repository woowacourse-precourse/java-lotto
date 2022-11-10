package domain;

import java.util.HashSet;
import java.util.Set;

public class WinningNumber {

    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(String input, int bonusNumber) {
        numbers = createNumberSet(input);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private Set<Integer> createNumberSet(String input) {
        Set<Integer> set = new HashSet<>();
        String[] num = input.split(",");
        for (String s : num) {
            set.add(Integer.valueOf(s));
        }
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 존재할 수 없습니다.");
        }
        return set;
    }
}
