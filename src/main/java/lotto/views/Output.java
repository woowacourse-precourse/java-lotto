package lotto.views;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.utils.GameMessage;
import lotto.utils.Ranking;

import java.util.List;

public class Output {

    public void printPrize(Prize prize) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Ranking.FIFTH_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.FIFTH_PLACE) + "개");
        System.out.println(Ranking.FOURTH_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.FOURTH_PLACE) + "개");
        System.out.println(Ranking.THIRD_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.THIRD_PLACE) + "개");
        System.out.println(Ranking.SECOND_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.SECOND_PLACE) + "개");
        System.out.println(Ranking.FIRST_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.FIRST_PLACE) + "개");
    }

    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }

    public void printLotto(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.printf("%d, ", numbers.get(i));
        }
        System.out.println(numbers.get(numbers.size() - 1) + "]");
    }

    public void printWallet(List<Lotto> lottos, int numberOfPurchase) {
        System.out.printf("\n%d%s\n", numberOfPurchase, GameMessage.BUY_NUMBER_OF_LOTTO);
        for (Lotto lotto : lottos) {
            printLotto(lotto.getNumbers());
        }
    }
}
