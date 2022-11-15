package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Pick;
import lotto.domain.Purchase;

import java.util.List;

public class Output {
    private final static String BUY_MESSAGE = "개를 구매했습니다.";
    private final static String DRAW_LIST = "당첨 통계\n---";


    public static void printPurchase(Purchase purchase) {
        List<Lotto> lottoes = purchase.getLottoes();

        System.out.println(lottoes.size() + BUY_MESSAGE);
        for (Lotto lotto : lottoes) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }

    public static void printPick(Pick pick) {
        List<Integer> scores = pick.getScores();
        int rank = 5;
        int score;

        System.out.println(DRAW_LIST);
        for (DrawMessage drawMessage : DrawMessage.values()) {
            score = scores.get(rank);
            System.out.println(drawMessage.getMatch() + score + "개");
            rank--;
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
