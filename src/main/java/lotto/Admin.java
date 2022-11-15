package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public void inputGameNumbers() {
    }

    // 당첨 번호를 입력 받는다.
    private Lotto inputWinningNumbers() {
        printInputWinningNumbers();
        String input = Console.readLine();
        validateWinningNumbersInput(input);
        List<Integer> numbers = inputToNumbers(input);
        return new Lotto(numbers);
    }

    private void validateWinningNumbersInput(String input) {
        if (!input.matches("^[0-9|,]+$")) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> inputToNumbers(String input) {
        List<String> stringInput = splitSeparator(input);
        return stringToIntegerList(stringInput);
    }

    private List<String> splitSeparator(String input) {
        List<String> input2 = List.of(input.split(","));
        return input2;
    }

    private List<Integer> stringToIntegerList(List<String> input) {
        List<Integer> numbers = new ArrayList<Integer>();
        for(String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }

    private void printInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    // 보너스 번호를 입력받는다.
    private int inputBonusNumber() {
        printInputBonusNumber();
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    private void validateGameNumbers() {
    }

    private void validateBonusNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException();
        }
    }
}