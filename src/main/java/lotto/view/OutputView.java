package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

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

    public void printWiningCount(List<Integer> winingCount){
        int i = 0;
        for (Rank priceMessage : Rank.values()){
            System.out.println(priceMessage.getPriceMessage()+ winingCount.get(i++)+"개");
        }
    }


    public void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue);
    }
}
