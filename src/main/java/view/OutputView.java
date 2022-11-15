package view;

import static util.Constant.*;

import lotto.Lottos;

public class OutputView {

    // 구매한 로또 번호 출력하는 기능
    public static void printPerchasedLottoNumber(int money, Lottos lottos) {
        System.out.printf(PURCHASE_LOTTO_TICKETS_MSG, money / LOTTO_PURCHASE_COST);
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }
}
