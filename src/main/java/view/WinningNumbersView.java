package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersView {

    public static final int NUMBER_OF_WINNING_NUMBERS = 6;

    public List<Integer> show() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        List<Integer> integerNumbers = validate(input);
        return integerNumbers;
    }

    private List<Integer> validate(String input) {
        List<String> numbers = new ArrayList<String>(Arrays.asList(input.split(",")));
        validateSize(numbers);
        List<Integer> integerNumbers = validateInteger(numbers);
        validateRange(integerNumbers);
        validateDuplicate(integerNumbers);
        return integerNumbers;
    }

    private void validateSize(List<String> numbers) {
        if (numbers.size() != NUMBER_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException("[Error] 당첨 번호의 개수는 " + NUMBER_OF_WINNING_NUMBERS + "개입니다.");
        }
    }

    private List<Integer> validateInteger(List<String> numbers) {
        List<Integer> integerNumbers = new ArrayList<>();
        try {
            for (String number : numbers) {
                integerNumbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 정수 형태이어야 합니다.");
        }
        return integerNumbers;
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[Error] 당첨 번호는 1이상 45이하 범위의 숫자이어야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> integerNumbers) {
        Set<Integer> deduplicatedIntegerNumbers = new HashSet<>(integerNumbers);
        if (deduplicatedIntegerNumbers.size() != integerNumbers.size()) {
            throw new IllegalArgumentException("[Error] 중복된 숫자가 존재합니다.");
        }
    }
}
