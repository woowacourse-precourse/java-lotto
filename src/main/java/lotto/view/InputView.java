package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
