package lotto;

import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    // 구입 금액 입력
    public static String getLottoMoney () {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }
    // 당첨 번호 입력
    public static String getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    // 보너스 번호 입력
    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
