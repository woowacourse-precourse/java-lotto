package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int receiveAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static String receiveWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int receiveBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
