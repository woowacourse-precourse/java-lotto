package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winning {
    public static List<Integer> numbers = new ArrayList<>();

    public Winning(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private static void validateWinning(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호에는 숫자 6개를 입력해야 합니다.");
        }
    }

    private static void checkInt(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("로또 번호는 숫자만 입력해야 합니다.");
            }
        }
    }

    private static void checkRange(int inputNumber) {
        if (inputNumber < 1 || inputNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void overlapCheck(int inputNumber){
        if (numbers.contains(inputNumber)) {
            throw new IllegalArgumentException("로또 번호에는 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    public static void addWinning(String input) {
        List<String> inputNumbers = Arrays.asList(input.split(","));
        for (int i = 0; i < inputNumbers.size(); i++) {
            checkInt(inputNumbers.get(i));
            int inputNumber = Integer.valueOf(inputNumbers.get(i));
            checkRange(inputNumber);
            overlapCheck(inputNumber);
            numbers.add(inputNumber);
        }
        validateWinning(numbers);
    }

    public static void addBonus(String input) {
        checkInt(input);
        int inputNumber = Integer.valueOf(input);
        checkRange(inputNumber);
        if (!numbers.contains(inputNumber)) {
            numbers.add(inputNumber);
            return;
        }
        throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복될 수 없습니다.");
    }
}
