package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Input {
    public static int getPrice() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.print());
        return getNumber();
    }

    private static int getNumber() {
        String number = Console.readLine();
        validateNumber(number);
        return Integer.parseInt(number);
    }

    private static void validateNumber(final String numbers) throws IllegalArgumentException {
        if (!Pattern.matches("^[0-9]*$", numbers)) {
            System.out.println("[ERROR] Only enter numbers.");
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(System.lineSeparator() + InputMessage.WINNING_NUMBER.print());
        return stringToList(Console.readLine());
    }

    public static List<Integer> getBonusNumber() {
        System.out.println(System.lineSeparator() + InputMessage.BONUS_NUMBER.print());
        return stringToList(Console.readLine());
    }

    private static List<Integer> stringToList(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(toList());
        } catch (Exception e) {
            System.out.println("[ERROR] Only enter numbers.");
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

}
