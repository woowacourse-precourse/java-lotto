package lotto;

import java.util.List;

public class Validation {
    public static boolean isValidUnit(int amount) {
        return amount % 1000 == 0;
    }

    public static boolean isValidRange(int amount) {
        return amount > 0;
    }

    public static boolean existOnlyNumber(String amount) {
        try {
            Integer.parseInt(amount);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean checkWinningNumbersDuplication(List<String> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public static boolean checkBonusNumberDuplication(List<Integer> winningNumbers, String bonusNumberInput) {
        return winningNumbers.contains(Integer.parseInt(bonusNumberInput));
    }
}
