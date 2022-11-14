package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.Lottery;
import lotto.domain.Rank;

public class OutputViewConsole implements OutputView {
    @Override
    public void printGeneratedLottery(Integer purchaseAmount, String lotteryInfo) {
        int lotterySize = purchaseAmount / Lottery.LOTTO_PRICE;
        System.out.println(lotterySize + "개를 구매했습니다.");
        System.out.println(lotteryInfo);
    }

    @Override
    public void printWinningHistory() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.print(rank.getMatchCount() + "개 일치");
            if (rank.isBonusMatch()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%s원) - %d개\n", decimalFormat.format(rank.getPrize()), rank.getCount());
        }
    }

    @Override
    public void printProfitRatio(Integer purchaseAmount) {
        DecimalFormat ratioFormat = new DecimalFormat("###,###.0%");
        double profitRatio;
        double profit = 0;
        for (Rank rank : Rank.values()) {
            profit += rank.getCount() * rank.getPrize();
        }
        profitRatio = profit / purchaseAmount;
        System.out.printf("총 수익률은 %s입니다.", ratioFormat.format(profitRatio));
    }

    @Override
    public void printAskPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printAskWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printAskBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
