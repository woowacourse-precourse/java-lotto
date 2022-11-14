package lotto.view;

import lotto.model.Lotto;
import static lotto.enums.PrintMsg.*;

import java.util.List;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(LINE_BREAK.getMessage() + lottoCount + OUTPUT_PURCHASE_LOTTO.getMessage());
    }

    public void printLottoNumber(List<Lotto> lottoNumbers) {
        for (int lottoCount = 0; lottoCount < lottoNumbers.size(); lottoCount++) {
            System.out.println(lottoNumbers.get(lottoCount).getNumbers());
        }
    }
}
