package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateUtils {

    public static void checkNumberType(String money) {
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
            }
        }
    }

    public static void checkUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로만 입력 가능합니다.");
        }
    }

    public static void checkSeparator(int size) {
        if (size == 1) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 구분자(',')를 이용하여 입력합니다.");
        }
    }

    public static void checkInputSize(int inputSize, int maxSize) {
        if (inputSize != maxSize) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력합니다.");
        }
    }

    public static void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 범위의 값만 입력합니다.");
        }
    }

    public static void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                //System.out.println("[ERROR] 로또 번호는 1 ~ 45 범위의 값만 입력합니다.");
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 범위의 값만 입력합니다.");
            }
        }
    }

    public static void checkDuplicatedRange(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호는 입력할 수 없습니다.");
        }
    }

    public static void checkDuplicatedRange(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호는 입력할 수 없습니다.");
        }
    }

}
