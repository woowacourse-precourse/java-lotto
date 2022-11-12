package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int inputMoney() {
        scanner = new Scanner(System.in);
        System.out.println(INPUT_MONEY);
        int money = scanner.nextInt();
        return money;
    }

    public String inputWinningNumber() {
        scanner = new Scanner(System.in);
        String winningNumber = scanner.nextLine();
        return winningNumber;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }
}
