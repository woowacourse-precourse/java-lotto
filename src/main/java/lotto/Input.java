package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static int getInputToInteger() {
        String input = Console.readLine();
        validNumber(input);
        return Integer.parseInt(input);
    }

    public static int getPurchaseAmount() {
        int input = getInputToInteger();
        validPurchase(input);
        return input;
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String str : split) {
            numbers.add(Integer.parseInt(str));
        }
        return numbers;
    }

    public static int getBonusNumber() {
        int input = getInputToInteger();
        return input;
    }

    private static void validNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validPurchase(int input) throws IllegalArgumentException {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
