package lotto;

import java.util.Collections;
import java.util.List;

public class Printer {

    public void startMention() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void buyLottoMention(int paperNumber, List<Integer> lotto) {
        System.out.printf("%d개를 구입하였습니다.\n");
        Collections.sort(lotto);
        System.out.println(lotto);
    }

    public void putWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void putBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
    }

    public void lottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
