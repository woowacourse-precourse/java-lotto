package lotto.validation;


import lotto.message.NumberType;

import java.util.HashSet;

public class Validator {
    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isCorrectUnit(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        if (money % 1000 != 0) {
            return false;
        }
        return true;
    }

    public boolean isCorrectDigitAtComma(String winningNumbersInput) {
        int digit = winningNumbersInput.split(",").length;
        if (digit == NumberType.SIX.getNumberType()) {
            return true;
        }
        return false;
    }

    public boolean isNumericAtComma(String winningNumbersInput) {
        String[] numbers = winningNumbersInput.split(",");
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public boolean isExistInBoundaryAtComma(String winningNumbersInput) {
        String[] numbers = winningNumbersInput.split(",");
        for (String numberInput : numbers) {
            int number = Integer.parseInt(numberInput);
            if (number < NumberType.ONE.getNumberType() || number > NumberType.FORTY_FIVE.getNumberType()) {
                return false;
            }
        }
        return true;
    }

    public boolean isUniqueNumberAtComma(String winningNumbersInput) {
        String[] numbers = winningNumbersInput.split(",");
        HashSet<String> uniqueNumber = new HashSet<>();
        for (String number : numbers) {
            uniqueNumber.add(number);
        }
        if (uniqueNumber.size() == NumberType.SIX.getNumberType()) {
            return true;
        }
        return false;
    }

    public boolean isExistInBoundary(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (bonusNumber < NumberType.ONE.getNumberType() || bonusNumber > NumberType.FORTY_FIVE.getNumberType()) {
            return false;
        }
        return true;
    }

    public boolean isUniqueNumber(String bonusNumberInput, HashSet<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (winningNumbers.contains(bonusNumber)) {
            return false;
        }
        return true;
    }
}
