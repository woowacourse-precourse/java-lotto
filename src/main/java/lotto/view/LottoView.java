package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoView {
    public static void print(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    static void printResult() {
        System.out.println();
    }
}
