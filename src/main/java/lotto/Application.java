package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        printInputMoney();
        int money = getMoneyInputFromUser();
    }

    private static int getMoneyInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //TODO: 구입금액 입력 검증
        return validateMoneyInput(input);
    }

    public static int validateMoneyInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        int inputInt = Integer.parseInt(input);
        if (!inMoneyRange(inputInt) || !divisibleByThousand(inputInt)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        return inputInt;
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
