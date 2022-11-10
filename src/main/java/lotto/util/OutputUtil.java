package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class OutputUtil {

    public void printUserLottoCount(int lottoCount) {
        System.out.println("" + lottoCount + "개를 구매했습니다.");
    }

    public void printUserLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
