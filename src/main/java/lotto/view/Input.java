package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Input {
    public static int getPrice() {
        System.out.println(Message.PURCHASE_AMOUNT.print());
        return getNumber();
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(System.lineSeparator() + Message.WINNING_NUMBER.print());
        try {
            return stringToList(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    public static List<Integer> getBonusNumber() {
        System.out.println(System.lineSeparator() + Message.BONUS_NUMBER.print());
        try {
            int bonusNumber = getNumber();
            return new ArrayList<>(bonusNumber);
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
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
