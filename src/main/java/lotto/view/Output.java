package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.utils.Statistics;

import java.util.List;

import static lotto.LottoRank.*;
import static lotto.utils.Statistics.*;

public class Output {

    public static void printLottoList(int count, List<Lotto> lottos) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        lottos.forEach(Lotto::printNumbers);
    }

    public static void printStats(int prize, List<Lotto> lottos, Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Statistics stats = new Statistics(lottos, result);
        System.out.println(FIRST + " - " + getFirst() + "개");
        System.out.println(SECOND + " - " + getSecond() + "개");
        System.out.println(THIRD + " - " + getThird() + "개");
        System.out.println(FOURTH + " - " + getFourth() + "개");
        System.out.println(FIFTH + " - " + getFifth() + "개");

        System.out.println("총 수익률은 " + calcRate(prize) + "%입니다.");
    }

}
