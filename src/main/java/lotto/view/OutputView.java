package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottoNumber(int count, List<Lotto> lottoList) {
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }
    }
}
