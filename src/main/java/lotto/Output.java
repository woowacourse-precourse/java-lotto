package lotto;

import java.util.List;

public class Output {

    // 발행한 로또 수량 및 번호를 출력하는 기능
    public static void printPurchasedLotto(int purchaseAmount, List<List<Integer>> lotto) {
        System.out.println(purchaseAmount/1000 + "개를 구매했습니다.");
        for (List<Integer> lott : lotto) {
            System.out.println(lott.toString());
        }
    }

}



