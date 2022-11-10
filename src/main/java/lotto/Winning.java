package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Winning {

    private final List<Integer> WINNING_NUMBERS;
    private final int BONUS_NUMBER;

    public Winning() {
        WINNING_NUMBERS = winningNumberInput();
        BONUS_NUMBER = bonusNumberInput();
    }

    public List<Integer> winningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        return TransformInputStringToList(winningNumbers);
    }

    public int bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> TransformInputStringToList(String input) {
        validateWinningNumberInput(input);
        String[] inputNumbers = input.split(",");

        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).forEach(numbers::add);

        return numbers;
    }

    public void validateWinningNumberInput(String winningNumbers) {
        String errMessage = "[ERROR] 잘못된 입력 입니다.";
        String[] winningNums = winningNumbers.split(",");

        if (winningNums.length != 6) {
            throw new IllegalArgumentException(errMessage);
        }

        if (!isPossibleTransformToInt(winningNums) || !isInRange(winningNums) || !hasUniqueNumber(winningNums)) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public boolean isPossibleTransformToInt(String[] inputs) {
        for (String x  : inputs) {
            try {
                Integer.parseInt(x);
            }catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public boolean isInRange(String[] input) {
        long countOfOutOfRange = Arrays.stream(input).mapToInt(Integer::parseInt)
                .filter(x -> x < 1 || x > 45).count();

        return countOfOutOfRange == 0;
    }

    public boolean hasUniqueNumber(String[] inputs) {
        Map<Integer, Integer> counter = new HashMap<>();
        Arrays.stream(inputs).mapToInt(Integer::parseInt)
                .forEach(x -> counter.put(x, counter.getOrDefault(x, 0)+1));

        long countOfDuplicatedNumber = counter.values().stream()
                .filter(x -> counter.get(x) > 1).count();

        return countOfDuplicatedNumber == 0;
    }
}
