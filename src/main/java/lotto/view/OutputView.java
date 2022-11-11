package lotto.view;

import lotto.controller.LottoListController;
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

}
