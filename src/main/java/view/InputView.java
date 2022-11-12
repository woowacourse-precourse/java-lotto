package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public int inputMoney() {
        scanner = new Scanner(System.in);
        System.out.println(INPUT_MONEY);
        int money = scanner.nextInt();
        return money;
    }

    public void inputWinningNumber() {
        scanner = new Scanner(System.in);
        System.out.println(INPUT_WINNING_NUMBER);
        int winningNumber = scanner.nextInt();
    }
}
