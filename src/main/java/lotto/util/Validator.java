package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static boolean isUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
}
