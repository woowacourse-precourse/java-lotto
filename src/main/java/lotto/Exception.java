package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Exception {
    public static int isInteger(String str) {
        int integer;
        try {
            integer = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수를 입력해야 합니다.");
        }

        return integer;
    }

    public static boolean isNotMultipleOfThousand(int money) {
        return money % 1000 != 0;
    }

    public static boolean isNotPositive(int money) {
        return money <= 0;
    }

    public static List<Integer> changeListStringToInteger(List<String> stringList) {
        try {
            return stringList.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자를 입력해야 합니다.");
        }
    }

    public static boolean isOverlap(List<Integer> winningNumber) {
        return winningNumber.size() != winningNumber.stream().distinct().count();
    }

    public static boolean isNotSixSize(List<Integer> winningNumber) {
        return winningNumber.size() != 6;
    }

    public static boolean isNotInRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            return checkOneNumber(number);
        }
        return false;
    }

    private static boolean checkOneNumber(int number) {
        return number < 1 || number > 45;
    }

}
