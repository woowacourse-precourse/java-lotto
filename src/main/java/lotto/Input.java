package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    // 로또 구입 금액을 입력받는 기능
    public static String enterLottoPurchaseAmout() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    // 당첨 번호를 입력 받는 기능
    public static String enterLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    // 보너스 번호를 입력 받는 기능
    public static String enterLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
