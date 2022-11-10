package lotto;

import java.util.List;

public class View {

    public void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요");
    }
    public void printPurchaseList(List<List<Integer>> purchases) {
        System.out.println(purchases.size()+"개를 구매했습니다.");
        for (List<Integer> purchase : purchases) {
            System.out.println(purchase);
        }
    }

}
