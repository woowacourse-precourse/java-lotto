package lotto;

import java.util.List;

public class LottoView {

    private static final String LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";

    public void printLottoInfo(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + LOTTO_NUMBER_MESSAGE);
        for (Lotto lotto : lottoBundle) {
            lotto.printNumbers();
        }
    }
}
