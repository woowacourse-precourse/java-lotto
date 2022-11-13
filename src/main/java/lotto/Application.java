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
        return Integer.parseInt(input);
    }

    private static void printInputMoney() {
        System.out.println(Message.INPUT_MONEY.message);
    }
}
