package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class LottoOutputView {
    private final static String LOTTO_COUNT_STRING = "개를 구매했습니다.";

    public void printLottoCount(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + LOTTO_COUNT_STRING);
        printLottoNumbers(lottoCount, lottos);
    }

    public void printLottoNumbers(int lottoCount, List<Lotto> lottos) {
        for(int i = 0; i<lottoCount; i++) {
            Lotto userLotto = lottos.get(i);
            printLottoNumber(userLotto);
        }
    }

    public void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
