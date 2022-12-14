package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.Lottery;
import lotto.domain.Rank;
import lotto.dto.RankDto;

public class OutputViewConsole implements OutputView {
    private final String[] winningHistoryPrintTemplate = {
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    };

    @Override
    public void printGeneratedLottery(Integer purchaseAmount, String lotteryInfo) {
        int lotterySize = purchaseAmount / Lottery.LOTTO_PRICE;
        System.out.println(lotterySize + "개를 구매했습니다.");
        System.out.println(lotteryInfo);
    }

    @Override
    public void printWinningHistory() {
        System.out.println("당첨 통계");
        System.out.println("---");
        RankDto[] rankDtos = Rank.values();
        for (int i = 0; i < winningHistoryPrintTemplate.length; i++) {
            System.out.printf(winningHistoryPrintTemplate[i], rankDtos[i].getCount());
        }
    }

    @Override
    public void printProfitRatio(Integer purchaseAmount) {
        DecimalFormat ratioFormat = new DecimalFormat("###,##0.0%");
        double profitRatio;
        double profit = 0;
        for (RankDto rank : Rank.values()) {
            profit += rank.getTotalPrize();
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
