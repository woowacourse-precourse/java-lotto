package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Input {
    public static int getPrice() {
        System.out.println(Message.PURCHASE_AMOUNT.print());
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

}
