package lotto;

import java.util.List;

public class LottoConsoleIo {
    void printRequestPurchase() {
        System.out.println("구입금액을 입력해주세요.");
    }

    static void printNoOfLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto:lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    static void printRequestWin() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

}
