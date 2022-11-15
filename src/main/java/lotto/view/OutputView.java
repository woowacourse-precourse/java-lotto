package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import lotto.model.Lotto;
import lotto.model.Score;
import lotto.model.Scores;

public class OutputView {
    public static void printUserLottoNums(int lottoNums) {
        System.out.println(lottoNums+"개를 구매했습니다.");
    }

    public static void printUserLottos(Lotto lotto) {
        System.out.println(lotto.getNumbers());

    }

    public static void printStatistics(Scores scores, double roundYield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Score value : Score.values()) {
            System.out.println(value.getMoneyStr()+scores.getScores().get(value.ordinal())+"개");
        }
        System.out.println("총 수익률은 "+roundYield+"%입니다.");
    }

}
