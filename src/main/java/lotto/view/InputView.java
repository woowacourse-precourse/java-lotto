package lotto.view;

import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public void printRequest() {
        System.out.println(PURCHASE_AMOUNT);
    }

    public void printLottos(List<List<Integer>> lottos) {
        System.out.println();
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
