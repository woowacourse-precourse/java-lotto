package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static int validateBonusNum(String input, List pickedNumbers) {
        int bonusNum = parseInt(input);

        if (pickedNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return bonusNum;
    }

    public static List<Integer> validatePickedNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> pickedNumbers = new ArrayList<Integer>();
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        pickedNumbers = checkExceptionCondition(numbers, pickedNumbers);

        return pickedNumbers;
    }

    private static List<Integer> checkExceptionCondition(String[] numbers, List<Integer> pickedNumbers) {
        for (int i = 0; i < numbers.length; i++) {
            int number = parseInt(numbers[i]);

            if (pickedNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR]");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR]");
            }
            pickedNumbers.add(number);
        }
        return pickedNumbers;
    }

    public static int validateMoneyInput(String input) {
        int money = parseInt(input);
        boolean isUnitOf1K = ((money % 1000) == 0);

        if (isUnitOf1K == false) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return money;
    }

    private static int parseInt(String input) {
        try {
            int money = Integer.parseInt(input);
            return money;
        } catch (NumberFormatException e) {
            System.out.println(new IllegalArgumentException("[ERROR]"));
            return 0;
        }
    }
}
