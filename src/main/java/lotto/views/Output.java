package lotto.views;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.utils.Ranking;

import java.util.List;

public class Output {
    public static final String BUY_FOR_LOTTO = "구입금액을 입력해 주세요";
    public static final String BUY_NUMBER_OF_LOTTO = "개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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
        System.out.printf("\n%d%s\n", numberOfPurchase, BUY_NUMBER_OF_LOTTO);
        for (Lotto lotto : lottos) {
            printLotto(lotto.getNumbers());
        }
    }

    public void printGetLottoPrice() {
        System.out.println(BUY_FOR_LOTTO);
    }

    public void printGetWinningNumbers() {
        System.out.print('\n' + INPUT_WINNING_NUMBER + '\n');
    }

    public void printGetBonusNumber() {
        System.out.print('\n' + INPUT_BONUS_NUMBER + '\n');
    }
}
