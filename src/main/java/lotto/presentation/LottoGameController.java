package lotto.presentation;

import java.util.List;
import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.presentation.view.LottoGameReader;

public class LottoGameController {

    public static void start() {
        List<Lotto> lottos = LottoService.getLottos(LottoGameReader.readLottoAmount());
        List<Integer> winNumber = LottoGameReader.readWinNumber();
        int bonusNumber = LottoGameReader.readBonusNumber();
    }

}
