package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.ErrorMessage.*;
import static lotto.Instance.*;

public class Input {
    private static int stringToInt(String input) {
        validNumber(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> toIntegerList(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : split) {
            numbers.add(stringToInt(str));
        }
        return numbers;
    }

    private static int getInput() {
        String input = Console.readLine();
        return stringToInt(input);
    }

    public static int getPurchaseAmount() {
        int input = getInput();
        validPurchase(input);
        return input;
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");
        validWinning6Numbers(split);
        validWinningRepetition(split);
        List<Integer> numbers = toIntegerList(split);
        validRange(numbers);
        return numbers;
    }

    public static int getBonusNumber(List<Integer> winning) {
        int input = getInput();
        validBonusRepetition(input, winning);
        validRange(input);
        return input;
    }

    private static void validNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private static void validPurchase(int input) throws IllegalArgumentException {
        if (input % BASIC_AMOUNT != 0) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_BASIC_AMOUNT);
        }
    }

    private static void validWinning6Numbers(String[] split) throws IllegalArgumentException {
        if (split.length != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(CANNOT_SEPARATE);
        }
    }

    private static void validWinningRepetition(String[] split) throws IllegalArgumentException {
        HashSet<String> removeDuplication = new HashSet<>(List.of(split));
        if (removeDuplication.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(REPETITION_WINNING);
        }
    }

    private static void validBonusRepetition(int bonus, List<Integer> winning) throws IllegalArgumentException {
        if (winning.contains(bonus)) {
            throw new IllegalArgumentException(REPETITION_BONUS);
        }
    }

    private static void validRange(int number) throws IllegalArgumentException {
        if ((number < START_RANGE) || (number > END_RANGE)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private static void validRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if ((number < START_RANGE) || (number > END_RANGE)) {
                throw new IllegalArgumentException(OUT_OF_RANGE);
            }
        }
    }
}
