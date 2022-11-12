package lotto.view;

import lotto.model.Lotto;

public class OutputView {
    public static void printUserLottoNums(int lottoNums) {
        System.out.println(lottoNums+"개를 구매했습니다.");
    }

    public static void printUserLottos(Lotto lotto) {
        System.out.println(lotto.getNumbers());

    }

}
