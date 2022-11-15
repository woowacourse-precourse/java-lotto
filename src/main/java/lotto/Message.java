package lotto;

import java.util.List;

public class Message {

    public void printPurchaseMsg() {
        printMsg("구입금액을 입력해 주세요.");
    }
    public void printPurchaseLotto(List<Lotto> lottos) {
        int amount = lottos.size();
        printMsg("\n" + amount + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            printMsg(lotto.toString());
        }
    }
    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
