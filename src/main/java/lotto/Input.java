package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputAmount() {
        System.out.println(Initialize.AMOUNT.message());
        return Console.readLine();
    }

    public static Integer inputBonus() {
        System.out.println(Initialize.BONUS.message());
        return Integer.valueOf(Console.readLine());
    }

    public static int getQuantity(String amount) {
        checkRemainder(amount);
        return Integer.parseInt(amount) / 1000;
    }

    private static void checkRemainder(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0)
            throw new IllegalArgumentException(Error.WRONG_AMOUNT.message());
    }
}
