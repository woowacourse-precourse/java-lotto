package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    /*
    1. 로또 구입 금액을 입력받는 기능
    2. 당첨 번호를 입력 받는 기능
    3. 보너스 번호를 입력 받는 기능
    * */

    public static String enterLottoPurchaseAmout() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
