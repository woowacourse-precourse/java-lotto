package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.Lottery;
import lotto.domain.Rank;

public class OutputViewConsole implements OutputView {
    private static final String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    @Override
    public void printGeneratedLottery(Integer purchaseAmount, String lotteryInfo) {
        System.out.println(purchaseAmount / Lottery.LOTTO_PRICE + "개를 구매했습니다.");
        System.out.println(lotteryInfo);
    }

    @Override
    public void printWinningHistory() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
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
        DecimalFormat ratioFormat = new DecimalFormat("###,###.#%");
        double profit = 0;
        for (Rank rank : Rank.values()) {
            profit += rank.getCount() * rank.getPrize();
        }
        System.out.printf("총 수익률은 %s입니다.",ratioFormat.format(profit / purchaseAmount));
    }

    @Override
    public void printAskPurchaseAmountMessage() {
        System.out.println(ASK_PURCHASE_AMOUNT_MESSAGE);
    }

    @Override
    public void printAskWinningNumbersMessage() {
        System.out.println(ASK_WINNING_NUMBERS_MESSAGE);
    }

    @Override
    public void printAskBonusNumberMessage() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
    }
}
