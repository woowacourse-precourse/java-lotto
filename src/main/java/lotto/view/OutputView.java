package lotto.view;

import lotto.domain.LottoRateOfReturn;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.enums.LottoResult;

import java.util.Arrays;

import static lotto.utils.ViewMessages.*;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().forEach(lotto ->
                System.out.println(lotto.getNumbers())
        );
    }

    public static void printLottoDone() {
        System.out.println(OUTPUT_LOTTO_DONE);
        System.out.println(OUTPUT_LINE);
    }
}
