package lotto.view;

import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.*;

public class OutputView {
    private static final String OUTPUT_BUY_LOTTO = "개를 구매했습니다.";
    private static final String OUTPUT_WIN_LOTTO_STATISTICS = "당첨 통계";
    private static final String OUTPUT_THREE_CORRECT = "3개 일치 (5,000원) - ";
    private static final String OUTPUT_FOUR_CORRECT = "4개 일치 (50,000원) - ";
    private static final String OUTPUT_FIVE_CORRECT = "5개 일치 (1,500,000원) - ";
    private static final String OUTPUT_FIVE_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String OUTPUT_SIX_CORRECT = "6개 일치 (2,000,000,000원) - ";

    public static void printLottoTicket(int count){
        System.out.println(count + OUTPUT_BUY_LOTTO);
    }

    public static void printLottoNumbers(List<Integer> lotto){
        List<Integer> tmpLotto = new ArrayList<>(lotto);
        Collections.sort(tmpLotto);
        System.out.println(tmpLotto.toString());
    }

    public static void printWinLottoStatistics(float profit, WinningResult result){
        System.out.println(OUTPUT_WIN_LOTTO_STATISTICS);
        System.out.println("---");
        System.out.println(OUTPUT_THREE_CORRECT + result.getWinningResult().get(Rank.FIFTH) + "개");
        System.out.println(OUTPUT_FOUR_CORRECT + result.getWinningResult().get(Rank.FOURTH) + "개");
        System.out.println(OUTPUT_FIVE_CORRECT + result.getWinningResult().get(Rank.THIRD) + "개");
        System.out.println(OUTPUT_FIVE_BONUS_CORRECT + result.getWinningResult().get(Rank.SECOND) + "개");
        System.out.println(OUTPUT_SIX_CORRECT + result.getWinningResult().get(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}
