package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static List<Integer> numbers;
    private static int bonusNumber;
    private static final String regexWinningNumber = "^\\d,\\d,\\d,\\d,\\d,\\d$";
    private static final String regexBonusNumber = "^\\d$";

    public NumberGenerator() {
    }
    
    public NumberGenerator(int start, int end, int count) {
        numbers = Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setWinningNumber() {
        String input = inputWinningNumber();
        validateWinningNumber(input);
        numbers.clear();
        Set<Integer> set = remainUniqueNumber(input);
        numbers.addAll(set);
    }

    private String inputWinningNumber() {
        return Console.readLine();
    }

    private void validateWinningNumber(String str) {
        if (!str.matches(regexWinningNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }
        Set<Integer> set = remainUniqueNumber(str);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
        for (Integer i : set) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private Set<Integer> remainUniqueNumber(String str) {
        String[] inputNumber = splitStr(str);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < inputNumber.length; i++) {
            set.add(Integer.parseInt(inputNumber[i]));
        }
        return set;
    }

    private String[] splitStr(String str) {
        String[] inputNumber = str.split(",");
        return inputNumber;
    }

    public void setBonusNumber() {
        String str = Console.readLine();
        validateBonusNumber(str);
        bonusNumber = Integer.parseInt(str);
    }

    private void validateBonusNumber(String str) {
        if (!str.matches(regexBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        int bonusNum = Integer.parseInt(str);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
