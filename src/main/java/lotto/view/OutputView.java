package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printBuyAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printCountBuyingLotto(int count, List<Lotto> lotto) {
        System.out.printf("%d개를 구매했습니다.\n", count);
        for (Lotto myLotto : lotto) {
            System.out.println(myLotto.getLotto());
        }
    }

    public void printWiningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWiningCountStatistics() {
        System.out.println("당첨 통게\n" + "---");
    }

    public void printFifthCount(int count) {
        System.out.println("3개 일치 (5,000원) - " + count + "개");
    }

}
