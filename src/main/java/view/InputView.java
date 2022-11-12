package view;

import java.util.Scanner;

public class InputView {
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public void inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MONEY);
        int money = scanner.nextInt();
    }
}
