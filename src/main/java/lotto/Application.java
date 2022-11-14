package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int amount = getPurchaseAmount();
        System.out.println(amount);

        // ~개를 구매했습니다.
        /*
        [1, 2, 3, 4, 5, 6]
         */

        // 당첨 번호를 입력해 주세요.
        // 1,2,3,4,5,6

        // 보너스 번호를 입력해 주세요
        // 7

        // 당첨 통계
        // ---
        /*
         ~개 일치 ()
         */

        // 총 수익률은 62.5%입니다.

        // TODO: 프로그램 구현
    }

    private static int getPurchaseAmount() {
        printlnPurchaseNoticeMessage();
        String input = Console.readLine();
        // calcLottoEach(input);
        return Integer.parseInt(input);
    }

    private static void printlnPurchaseNoticeMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
