package lotto.view;

import lotto.model.LottoGroup;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;

public class OutputView {

    public static void LottoCountPrint(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void LottoListPrint(LottoGroup lottoGroup) {
        for (Lotto lotto : lottoGroup.getLOTTO_LIST()) {
            LottoNumberPrint(lotto);
            System.out.println("");
        }
    }

    public static void LottoNumberPrint(Lotto lotto) {
        System.out.print("[" + lotto.getNumbers().get(0));
        for (int i = 1; i < lotto.getNumbers().size(); i++) {
            System.out.print(", " + lotto.getNumbers().get(i));
        }
        System.out.print("]");
    }

    public static void ResultPrint(Result result) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.getRankCount(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getRankCount(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getRankCount(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getRankCount(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getRankCount(Rank.FIRST) + "개");
    }


    public static void YieldPrint(double summoney, int paymonney) {
        double result = summoney * 100 / paymonney;
        System.out.println("총 수익률은 " + String.format("%.1f",result) + "%입니다.");
    }


}
