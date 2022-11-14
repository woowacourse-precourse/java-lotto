package lotto.domain.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String CONTAIN_NUMBER = "숫자가 아닌 값이 포함되어 있습니다.";
    private static final String LESS_THAN_MINIMUM = "가격이 천원보다 작습니다.";
    private static final String NOT_DIVIDED = "천원으로 나누어 떨어지지 않습니다.";
    private static final String DUPLICATE = "중복된 값이 존재합니다.";
    private static final String IS_NOT_SIX = "길이가 6이 아닙니다.";
    private static final String IS_NOT_ONE = "길이가 1이 아닙니다.";
    private static final String IS_NOT_RANGE = "유효한 범위가 아닙니다.";

    public static void isNumber(String input) throws IllegalArgumentException {
        String regExp = "^[0-9]+$";
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CONTAIN_NUMBER);
        }
    }

    public static void isNumber(String[] numbers) throws IllegalArgumentException {
        String regExp = "^[0-9]+$";
        boolean containNumber = Arrays.stream(numbers)
                .allMatch(number -> number.matches(regExp));
        if(!containNumber){
            throw new IllegalArgumentException(ERROR_MESSAGE + CONTAIN_NUMBER);
        }
    }


    public static void isHigherThanMinPrice(String input) throws IllegalArgumentException {
        int price = Integer.parseInt(input);
        if (price < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LESS_THAN_MINIMUM);
        }
    }

    public static void isItDivided(String input) throws IllegalArgumentException {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_DIVIDED);
        }
    }

    public static void isDuplicate(List<Integer> numbers) {
        HashSet<Integer> operators = new HashSet<>(numbers);
        if (operators.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE);
        }
    }

    public static void isItSix(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + IS_NOT_SIX);
        }
    }
    public static void isItOne(String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE + IS_NOT_ONE);
        }
    }

    public static void isItRange(String[] numbers) {
        boolean containRange = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 1 || number > 45);
        if (containRange) {
            throw new IllegalArgumentException(ERROR_MESSAGE + IS_NOT_RANGE);
        }
    }
    public static void isItRange(String userInput) {
        int number = Integer.parseInt(userInput);
        if(number < 1 || number > 45 ){
            throw new IllegalArgumentException(ERROR_MESSAGE + IS_NOT_RANGE);
        }
    }
}
