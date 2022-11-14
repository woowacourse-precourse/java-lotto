package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(String winningNumberStr, String bonusNumberStr) {
        winningNumbers = parseWinningNumberStr(winningNumberStr);
        bonusNumber = bonusNumberStrToInt(bonusNumberStr);
        validateBoundary();
        validateDuplicateWinningNumbersAndBonusNumber();
        validateWinningNumberSize();
    }

    private void validateBoundary() {
        for (Integer number : winningNumbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_BOUNDARY.getExceptionMessage());
            }
        }
    }

    private void validateDuplicateWinningNumbersAndBonusNumber() {
        Set<Integer> checkNumber = new HashSet<>();
        for (Integer number : winningNumbers) {
            if(checkNumber.contains(number)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.getExceptionMessage());
            }
            checkNumber.add(number);
        }
        if(checkNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.getExceptionMessage());
        }
    }

    private List<Integer> parseWinningNumberStr(String winningNumberStr) {
        List<Integer> newWinningNumbers = new ArrayList<>();
        String[] numbers = winningNumberStr.split(",");
        try {
            for(String number : numbers) {
                newWinningNumbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_INPUT.getExceptionMessage());
        }
        return newWinningNumbers;
    }

    private void validateWinningNumberSize() {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_INPUT.getExceptionMessage());
        }
    }

    private int bonusNumberStrToInt(String bonusNumberStr) {
        try {
            return Integer.parseInt(bonusNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_INPUT.getExceptionMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
