package lotto;

import java.util.List;

public class Output {
    public static void printPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printLottoBundle(List<Lotto> lottos, int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount + "개를 구매했습니다.");

        for(Lotto l : lottos) {
            System.out.println(l.getNumbers());
        }
    }

}
