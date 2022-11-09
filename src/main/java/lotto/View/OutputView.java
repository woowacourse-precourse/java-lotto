package lotto.View;

import lotto.Model.LottoSystem;

import java.util.Collections;


public class OutputView {
    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("—");
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(LottoSystem.getWinningStatics(), 3) + "개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(LottoSystem.getWinningStatics(), 4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(LottoSystem.getWinningStatics(), 5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(LottoSystem.getWinningStatics(), 7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(LottoSystem.getWinningStatics(), 6) + "개");
    }
}
