package lotto.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Exceptions {
    private static final int COUNT_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    static List<String> numbers;

    public static boolean validLottoNumbers(String numbers) {
        if (!Exceptions.isOverLapNumber(numbers) || !Exceptions.isCorrectSize(numbers) ||
                !Exceptions.isRightLottoNumbersType(numbers)) {
            return false;
        }
        return true;
    }

    public static boolean isOverLapNumber(String request) {
        numbers = Arrays.asList(request.split(","));
        for (int i = 0; i < numbers.size(); i++) {
            int numberCount = Collections.frequency(numbers, numbers.get(i));
            if (numberCount > COUNT_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRightLottoNumbersType(String request) {
        for (int i = 0; i < request.length(); i++) {
            if ((i % 2 == 0 && !Character.isDigit(request.charAt(i))) ||
                    (i % 2 != 0 && request.charAt(i) != 44)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectSize(String request) {
        numbers = Arrays.asList(request.split(","));
        if (numbers.size() != LOTTO_SIZE) {
            return false;
        }
        return true;
    }
}
