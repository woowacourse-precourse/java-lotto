package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Validaor {

    public static Integer validatePurchaseAmount(String inputVal) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(inputVal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000의 배수여야 합니다.");
        }
        return purchaseAmount;
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        if (!hasSixNumbers(numbers)) throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        List<Integer> winningNumbers;
        try {
            winningNumbers = parseListToInt(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        if (hasDuplication(winningNumbers)) throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        if (!inRange(winningNumbers)) throw new IllegalArgumentException("[ERROR] 범위 내의 숫자를 입력해주세요.");

        return winningNumbers;
    }

    public static Integer validateBonusNumber(String number, List<Integer> winningNumbers) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        if (!inRange(List.of(bonusNumber))) throw new IllegalArgumentException("[ERROR] 범위 내의 숫자를 입력해주세요.");
        if (winningNumbers.contains(bonusNumber)) throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 숫자입니다.");

        return bonusNumber;
    }

    public static boolean hasDuplication(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    public static boolean hasSixNumbers(String[] numbers) {
        return numbers.length == 6;
    }

    public static List<Integer> parseListToInt(String[] numbers) throws IllegalArgumentException {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            try {
                winningNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
            }
        }

        return winningNumbers;
    }

    public static boolean inRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                return false;
            }
        }
        return true;
    }
}
