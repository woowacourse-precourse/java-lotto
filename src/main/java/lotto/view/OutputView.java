package lotto.view;

import java.util.List;
import lotto.controller.LottoListController;
import lotto.controller.LottoSameCountController;
import lotto.model.Lotto;

public class OutputView {

    public static void LottoCountPrint(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void LottoListPrint(LottoListController lottoListController) {
        for (Lotto lotto : lottoListController.getLOTTO_LIST()) {
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

    public static void ResultPrint(List<Integer> rankcountlist) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + rankcountlist.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankcountlist.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankcountlist.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankcountlist.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankcountlist.get(0) + "개");
    }

    public static void YieldPrint(int summoney, int paymonney) {
        double result = (double) summoney * 100 / paymonney;
        System.out.println("총 수익률은 " + result + "%입니다.");
    }


}
