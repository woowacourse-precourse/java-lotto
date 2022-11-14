package lotto.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Error {
    static void hasOnlyNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    static void isValidInput(String input) {
        if (!input.matches("[0-9],[0-9],[0-9],[0-9],[0-9],[0-9]")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 쉼표만으로 구분하여 입력해야 합니다.");
        }
    }

    static void isStartedNotZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0이 아닌 숫자로 시작해야 합니다");
        }
    }

    static void isDividableBy1000(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    static void validNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."));
        }
    }

    static void hasSameNumber(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }

    public static void existDuplicateNumber(List<Integer> numbers) {
        List<Integer> tmpNumbers = new ArrayList<>(numbers);
        tmpNumbers.sort(Comparator.naturalOrder());
        for (int index = 1; index < tmpNumbers.size(); index++) {
            if (tmpNumbers.get(index) == tmpNumbers.get(index-1)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
            }
        }
    }
}
