package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enums.GameMessage;
import java.util.List;

public class BuyerOutputView {

    private final static String COUNT = "개";

    public static void showLottoCount(int ticketAmount) {
        System.out.println(ticketAmount + GameMessage.BUY_MESSAGE.getGameMessage());
    }

    public static void showLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public static void showRaffleResult(List<Integer> raffleResult) {
        System.out.println(GameMessage.RESULT_MESSAGE.getGameMessage());
        System.out.println(GameMessage.PRIZE_5_MESSAGE.getGameMessage() + raffleResult.get(0) + COUNT);
        System.out.println(GameMessage.PRIZE_4_MESSAGE.getGameMessage() + raffleResult.get(1) + COUNT);
        System.out.println(GameMessage.PRIZE_3_MESSAGE.getGameMessage() + raffleResult.get(2) + COUNT);
        System.out.println(GameMessage.PRIZE_2_MESSAGE.getGameMessage() + raffleResult.get(3) + COUNT);
        System.out.println(GameMessage.PRIZE_1_MESSAGE.getGameMessage() + raffleResult.get(4) + COUNT);
    }

    public static void showProfit(double profitRate) {
        System.out.println(GameMessage.PROFIT_PROMPT_MESSAGE.getGameMessage() + String.format("%.1f", profitRate)
                + GameMessage.PROFIT_TOTAL_MESSAGE.getGameMessage());
    }

}
