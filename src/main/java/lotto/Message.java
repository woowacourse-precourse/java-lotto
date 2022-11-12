package lotto;

import java.util.List;

public class Message {
    public void printPurchaseMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseLotto(List<Lotto> lottos) {
        int amount = lottos.size();
        System.out.println("\n" + amount + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printPlsInputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printPlsInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printError(String msg) {
        System.out.println(msg);
    }
}
