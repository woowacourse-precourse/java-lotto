package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        printInputMoney();
        int money = getMoneyInputFromUser();
        int numberOfLotteries = calculateNumberOfLotteries(money);
    }

    public static int calculateNumberOfLotteries(int money) {
        return money / 1000;
    }

    private static int getMoneyInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return validateMoneyInput(input);
    }

    public static int validateMoneyInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        int inputInInt = Integer.parseInt(input);
        if (!inMoneyRange(inputInInt) || !divisibleByThousand(inputInInt)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        return inputInInt;
    }

    public static boolean inMoneyRange(int inputInt) {
        if (inputInt >= 0) {
            return true;
        }
        return false;
    }

    public static boolean divisibleByThousand(int inputInt) {
        if (inputInt % 1000 == 0) {
            return true;
        }
        return false;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private static void printInputMoney() {
        System.out.println(Message.INPUT_MONEY.message);
    }
}
