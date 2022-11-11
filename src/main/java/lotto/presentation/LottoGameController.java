package lotto.presentation;

import java.util.List;
import lotto.presentation.view.LottoGameReader;

public class LottoGameController {

    public static void start() {
        int lottoCount = LottoGameReader.readLottoAmount();
        List<Integer> winNumber = LottoGameReader.readWinNumber();
    }

}
