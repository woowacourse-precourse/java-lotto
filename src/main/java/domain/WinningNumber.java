package domain;

import java.util.HashSet;
import java.util.Set;

public class WinningNumber {

    private static final String COMMON_ERROR_MESSAGE = "[ERROR] 입력이 올바르지 않습니다.";
    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(String input, int bonusNumber) {
        numbers = createNumberSet(input);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean containNumberSet(int num) {
        return numbers.contains(num);
    }

    public boolean equalBonusNumber(int num) {
        return num == bonusNumber;
    }

    private Set<Integer> createNumberSet(String input) {
        Set<Integer> set = new HashSet<>();
        String[] num = input.split(",");
        if (num.length != 6) {
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE);
        }
        for (String s : num) {
            validateNumberBetweenRange(s, 1, 45);
            set.add(Integer.valueOf(s));
        }
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 존재할 수 없습니다.");
        }
        return set;
    }

    private void validateNumberBetweenRange(String s, int min, int max) {
        if (s.length() != 1 && s.length() != 2) {
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 숫자여야 합니다.");
            }
        }
        if (Integer.valueOf(s) < min || Integer.valueOf(s) > max) {
            throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 " + min + "부터 " + max + " 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
