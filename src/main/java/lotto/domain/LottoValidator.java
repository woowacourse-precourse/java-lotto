package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {

    public static LottoValidator lottoValidator = new LottoValidator();

    public static LottoValidator getInstance() {
        return lottoValidator;
    }

    public static boolean isPositiveInteger(String numericString) {
        if (numericString.chars().allMatch(Character::isDigit)) return true;
        return false;
    }

    public static boolean isPositiveInteger(int number) {
        if (number > 0) return true;
        return false;
    }

    public static boolean isValidRange(int number) {
        if (number < LottoConstant.STARTFROM.getValue()
                || number > LottoConstant.ENDTO.getValue()) return false;
        return true;
    }

    public static boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) return true;
        return false;
    }

    public static boolean isValidSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.SIZE.getValue()) return false;
        return true;
    }

    public boolean isValidRangeNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (!isValidRange(number)) return false;
        }
        return true;
    }

}
