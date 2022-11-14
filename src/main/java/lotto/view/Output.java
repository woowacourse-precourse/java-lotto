package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    public static void outputLottoList(int lottoCount, List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottos.forEach(Lotto::printNumbers);
    }
}
