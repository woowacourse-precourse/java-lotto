package lotto.exception;

import static lotto.constant.Constant.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class UserInputLottoInfoException {
    public void isInputValueOnlyNumber(String price, String message) {
        for (int i = 0; i < price.length(); i++) {
            if (!Character.isDigit(price.charAt(i))) {
                System.out.println(ERROR_MESSAGE + message);
                throw new NoSuchElementException();
            }
        }
    }
    public void isDividedByThousand(String price, String message) {
        if (price.length() < FOUR_DIGIT_NUMBER) {
            System.out.println(ERROR_MESSAGE + message);
            throw new IllegalArgumentException();
        }
        if (!price.substring(price.length() - NUMBER_OF_ZERO_IN_THOUSAND).equals("000")) {
            System.out.println(ERROR_MESSAGE + message);
            throw new IllegalArgumentException();
        }
    }
    public void verifyExistBlank(String number, String message) {
        for (int i = 0; i < number.length(); i++) {
            if (number.length() != number.replace(" ", "").length()) {
                System.out.println(ERROR_MESSAGE + message);
                throw new IllegalArgumentException();
            }
        }
    }
    public void checkArrayLength(String[] numbers, String message) {
        if (numbers.length != NUMBER_OF_LOTTO_NUMBERS) {
            System.out.println(ERROR_MESSAGE + message);
            throw new IllegalArgumentException();
        }
    }
    public void isExistSameNumber(String[] numbers, String message) {
        Set<String> set = new HashSet<>(Arrays.asList(numbers));
        if (numbers.length!= set.size()) {
            System.out.println(ERROR_MESSAGE + message);
            throw new IllegalArgumentException();
        }
    }
    public void checkLottoNumberRange(String number, String message) {
        if (!number.matches("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$")) {
            System.out.println(ERROR_MESSAGE + message);
            throw new IllegalArgumentException();
        }
    }
    public void checkInputIsEmpty(String number, String message) {
        if (number.isEmpty()) {
            System.out.println(ERROR_MESSAGE + message);
            throw new IllegalArgumentException();
        }
    }
}
