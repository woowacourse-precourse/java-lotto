package lotto.validator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void checkPurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) { // 1000으로 나누어 떨어지지 않을 경우
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 수를 입력하세요.");
        }
    }

    public static void checkWinningNumberInputForm(String winningNumberInput) {
        if (winningNumberInput.contains(",") == false) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표로 구분해주세요.");
        } else if (winningNumberInput.contains(" ") == true) {
            throw new IllegalArgumentException("[ERROR] 공백을 포함할 수 없습니다.");
        }
    }

    public static void checkLottoNumbers(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkUniqueNumber(numbers);
        checkNumberRange(numbers);
    }

    public static void checkNumberCount(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 수를 입력하세요.");
        }
    }

    public static void checkUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size()!= numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 6개의 수를 입력하세요.");
        }
    }

    public static void checkNumberRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num<1 || num>45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
