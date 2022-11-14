package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {


    public void checkPurchaseInput(String str) {
        checkNumberFormat(str);
        checkValidPurchaseCost(str);
    }
    public void checkWinningNumberInput(String numbers) {
        String[] winningNumbers = numbers.split(",");

        checkValidLength(winningNumbers);
        checkDuplicatedNumber(winningNumbers);

        for (String winningNumber : winningNumbers) {
            checkNumberFormat(winningNumber);
            checkValidNumberRange(winningNumber);
        }
    }

    public void checkBonusNumberInput(String str) {
        checkNumberFormat(str);
        checkValidNumberRange(str);
    }

    public void checkLottoNumbers(List<Integer> numbers) {
        String[] lottoNumbers = changeToStrArr(numbers);

        checkValidLength(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);

        for (String lottoNumber : lottoNumbers) {
            checkValidNumberRange(lottoNumber);
        }
    }

    private void checkNumberFormat(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                System.out.println(ExceptionType.INVALID_FORMAT.getErrorMsg());
                throw new IllegalArgumentException(ExceptionType.INVALID_FORMAT.getErrorMsg());
            }
        }
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private void checkValidPurchaseCost(String str) {
        int cost = Integer.parseInt(str);

        if ((cost % Lotto.LOTTO_PRICE) != 0) {
            System.out.println(ExceptionType.INVALID_PURCHASE_COST.getErrorMsg());
            throw new IllegalArgumentException(ExceptionType.INVALID_PURCHASE_COST.getErrorMsg());
        }
    }

    private void checkValidLength(String[] str) {
        if (str.length != Lotto.LOTTO_NUMBER_SIZE) {
            System.out.println(ExceptionType.INVALID_LENGTH.getErrorMsg());
            throw new IllegalArgumentException(ExceptionType.INVALID_LENGTH.getErrorMsg());
        }
    }

    private void checkDuplicatedNumber(String[] numbers) {
        Set<String> storedNumbers = new HashSet<>();

        for (String winningNumber : numbers) {
            if (storedNumbers.contains(winningNumber)) {
                System.out.println(ExceptionType.DUPLICATED_NUMBER.getErrorMsg());
                throw new IllegalArgumentException(ExceptionType.DUPLICATED_NUMBER.getErrorMsg());
            }

            storedNumbers.add(winningNumber);
        }
    }

    private void checkValidNumberRange(String str) {
        int number = Integer.parseInt(str);

        if (!isValidRange(number)) {
            System.out.println(ExceptionType.INVALID_RANGE.getErrorMsg());
            throw new IllegalArgumentException(ExceptionType.INVALID_RANGE.getErrorMsg());
        }
    }

    private String[] changeToStrArr(List<Integer> numbers) {
        String[] strNumbers = new String[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            strNumbers[i] = String.valueOf(numbers.get(i));
        }

        return strNumbers;
    }

    private static boolean isValidRange(int number) {
        return Lotto.MIN_LOTTO_NUMBER <= number && number <= Lotto.MAX_LOTTO_NUMBER;
    }
}
