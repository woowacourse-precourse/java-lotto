package lotto.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckException {
    public static void checkAmount(int amount) throws IllegalArgumentException {
        if (amount <= 0 || (amount % 1000) > 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
    }

    public static void checkSixSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 6개가 아닙니다.");
        }
    }

    public static void checkDuplicatedNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public static void checkWinningNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        for (int winningNumber : winningNumbers) {
            checkValidBoundary(winningNumber);
        }
        checkSixSize(winningNumbers);
    }

    public static void checkBonusNumber(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
        checkValidBoundary(bonusNumber);
        List<Integer> totalNumbers = new ArrayList<>(winningNumbers);
        totalNumbers.add(bonusNumber);
        checkDuplicatedNumber(totalNumbers);
    }

    private static void checkValidBoundary(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 범위의 숫자여야 합니다.");
        }
    }
}
