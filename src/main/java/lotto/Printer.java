package lotto;

import java.util.Collections;
import java.util.List;

public class Printer {
    public static void printWinnings(List<Winning> winnings) {
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(winnings, Winning.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(winnings, Winning.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(winnings, Winning.THIRD) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(winnings, Winning.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(winnings, Winning.FIRST) + "개");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
