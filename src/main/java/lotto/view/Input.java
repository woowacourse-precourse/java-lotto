package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Input {
    private static final int LOTTO_SIZE = 6;
    private static final int BONUS_NUMBER_SIZE = 1;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int getAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        return getNumber();
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER_MESSAGE);
        try {
            List<Integer> winningNumber = stringToList(Console.readLine());
            validateSize(winningNumber, LOTTO_SIZE);
            validateDuplicate(winningNumber);
            validateNumberRange(winningNumber);
            return winningNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    public static List<Integer> getBonusNumber(List<Integer> winningNumber) {
        System.out.println(ENTER_BONUS_NUMBER_MESSAGE);
        try {
            int number = getNumber();
            List<Integer> bonusNumber = new ArrayList<>(number);
            validateDuplicateWinning(winningNumber, number);
            validateSize(bonusNumber, BONUS_NUMBER_SIZE);
            validateNumberRange(bonusNumber);
            return bonusNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    public static int getNumber() {
        try {
            String number = Console.readLine();
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    private static List<Integer> stringToList(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static void validateSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException("[ERROR] Must enter 6 lottery winning numbers.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] Must enter non-duplicate numbers.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(Input::inRange)) {
            throw new IllegalArgumentException("[ERROR] Must enter a number from 1 to 45.");
        }
    }

    private static boolean inRange(int number) {
        return number < START_NUMBER || number > END_NUMBER;
    }

    private static void validateDuplicateWinning(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] Must enter a number that does not overlap with the winning number.");
        }
    }
}
