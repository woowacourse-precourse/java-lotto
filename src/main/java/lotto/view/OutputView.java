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

    public void printFourthCount(int count) {
        System.out.println("4개 일치 (50,000원) - " + count + "개");
    }

    public void printThirdCount(int count) {
        System.out.println("5개 일치 (1,500,000원) - " + count + "개");
    }

    public void printSecondCount(int count) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
    }

    public void printFirstCount(int count) {
        System.out.println("6개 일치 2,000,000,000원) - " + count + "개");
    }

    public void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue);
    }
}
