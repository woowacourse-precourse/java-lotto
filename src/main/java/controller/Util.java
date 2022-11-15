package controller;

import view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Util {

    public static void validateInteger(String inputValue) {
        String pattern = "[0-9]+";
        if (!inputValue.matches(pattern))
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getErrorMessage());
    }

    public static void validateComma(String lottoWinningNumbers) {
        if (!lottoWinningNumbers.contains(","))
            throw new IllegalArgumentException(ErrorMessage.NOT_COMMA.getErrorMessage());
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(ErrorMessage.NOT_SIZE.getErrorMessage());
    }

    public static void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numbersOverlap = new HashSet<>(numbers);
        if (numbers.size() != numbersOverlap.size())
            throw new IllegalArgumentException(ErrorMessage.HAVE_DUPLICATION.getErrorMessage());
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++)
            validateRange(numbers.get(i));
    }

    public static void validateRange(int lottoWinningBonus) {
        if (lottoWinningBonus < 1 || lottoWinningBonus > 45)
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getErrorMessage());
    }

    public static void validateInputMoney(int inputMoney) {
        if (inputMoney % 1000 != 0) throw new IllegalArgumentException(ErrorMessage.NOT_UNIT.getErrorMessage());
    }

}
