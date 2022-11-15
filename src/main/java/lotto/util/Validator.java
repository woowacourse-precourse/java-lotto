package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;

/*
 * 입력 값의 검증 조건을 구현한 클래스
 */

public class Validator {

    public static boolean isEmpty(String numbers) {
        return numbers.isEmpty();
    }

    public static boolean isInteger(String number) {
        for (int i = 0; i < number.length(); i++) {
            char needVerify = number.charAt(i);

            if (!Character.isDigit(needVerify)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == Constant.LOTTO_SIZE;
    }

    // 여러개의 숫자를 검증
    public static boolean isValidNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isValidNumber(number)) {
                return false;
            }
        }
        return true;
    }

    // 1개 숫자를 검증
    public static boolean isValidNumber(int number) {
        return number >= Constant.LOTTO_START_NUMBER && number <= Constant.LOTTO_END_NUMBER;
    }

    public static boolean isUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
}
