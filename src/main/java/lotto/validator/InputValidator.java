package lotto.validator;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.status.BoundaryStatus;
import lotto.status.ExceptionStatus;
import lotto.status.NumberStatus;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static Money checkUserInputMoney(String userInputMoney) {
        if (checkIsNumber(userInputMoney)) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_NUMBER.getText());
        }
        if (checkZeroInHead(userInputMoney)) {
            throw new IllegalArgumentException(ExceptionStatus.ZERO_IN_HEAD.getText());
        }
        if (checkOnlyNumberInMoney(userInputMoney)) {
            throw new IllegalArgumentException(ExceptionStatus.ZERO_IN_HEAD.getText());
        }
        if (checkDivideByBasePrice(userInputMoney)) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_DIVIDE_BASE_PRICE.getText());
        }
        return new Money(Integer.parseInt(userInputMoney));
    }

    private static boolean checkZeroInHead(String userInputMoney) {
        if (userInputMoney.charAt(NumberStatus.ZERO.getNumber()) == '0') {
            return true;
        }
        return false;
    }

    private static boolean checkOnlyNumberInMoney(String userInputMoney) {
        char[] inputMoneyPiece = userInputMoney.toCharArray();
        for (int i = 0; i < userInputMoney.length(); i++) {
            if (inputMoneyPiece[i] < BoundaryStatus.ZERO_ASCII.getNumber() ||
                    inputMoneyPiece[i] > BoundaryStatus.NINE_ASCII.getNumber()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDivideByBasePrice(String userInputMoney) {
        if (Integer.parseInt(userInputMoney) % NumberStatus.BASE_PRICE_OF_LOTTO.getNumber() != NumberStatus.ZERO.getNumber()) {
            return true;
        }
        return false;
    }

    public static void checkWinningNumber(String winningNumber) {
        List<String> checkNumber = Arrays.asList(winningNumber.split(","));
        if (checkCorrectShape(checkNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_CORRECT_SHAPE.getText());
        }
        if (checkOnlyNumberInWinningNumber(checkNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.CONTAIN_ONLY_NUMBER.getText());
        }
        if (checkNumberBoundary(checkNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_BOUNDARY_NUMBER.getText());
        }
    }

    private static boolean checkCorrectShape(List<String> checkNumber) {
        if (checkNumber.size() != NumberStatus.TOTAL_NUMBER_OF_LOTTO.getNumber()) {
            return true;
        }
        return false;
    }

    private static boolean checkOnlyNumberInWinningNumber(List<String> checkNumber) {
        try {
            for (String checkNumberPiece : checkNumber) {
                Integer.parseInt(checkNumberPiece);
            }
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    private static boolean checkNumberBoundary(List<String> checkNumber) {
        for (String checkNumberPiece : checkNumber) {
            if (Integer.parseInt(checkNumberPiece) > NumberStatus.MAX_LOTTO_NUMBER.getNumber() ||
                    Integer.parseInt(checkNumberPiece) < NumberStatus.MIN_LOTTO_NUMBER.getNumber()) {
                return true;
            }
        }
        return false;
    }

    public static BonusNumber checkBonusNumber(String bonusNumber, Lotto winningLotto) {
        if (checkIsNumber(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_NUMBER.getText());
        }
        if (checkNumberBoundary(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.NOT_BOUNDARY_NUMBER.getText());
        }
        if (checkNumberInWinningNumber(bonusNumber, winningLotto)) {
            throw new IllegalArgumentException(ExceptionStatus.IS_DUPLICATED.getText());
        }

        return new BonusNumber(Integer.parseInt(bonusNumber));
    }

    private static boolean checkIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    private static boolean checkNumberBoundary(String bonusNumber) {
        Integer checkNumber = Integer.parseInt(bonusNumber);
        if (checkNumber < NumberStatus.MIN_LOTTO_NUMBER.getNumber() ||
                checkNumber > NumberStatus.MAX_LOTTO_NUMBER.getNumber()) {
            return true;
        }
        return false;
    }

    private static boolean checkNumberInWinningNumber(String bonusNumber, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(Integer.parseInt(bonusNumber))) {
            return true;
        }
        return false;
    }

}
