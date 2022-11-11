package lotto.presentation;

import lotto.presentation.view.LottoGameReader;

public class LottoGameController {

    public static void start() {
        int lottoCount = LottoGameReader.readLottoAmount();
    }

}
