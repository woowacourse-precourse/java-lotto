package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private static final String LINE_BREAK = "\n";
    private static final String PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printLottoCount(int lottoCount) {
        System.out.println(LINE_BREAK + lottoCount + PURCHASE_LOTTO_MESSAGE);
    }

    public void printLottoNumber(List<Lotto> lottoNumbers) {
        for (int lottoCount = 0; lottoCount < lottoNumbers.size(); lottoCount++) {
            System.out.println(lottoNumbers.get(lottoCount).getNumbers());
        }
    }
}
