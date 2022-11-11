package lotto.presentation;

import java.util.List;
import lotto.application.LottoService;
import lotto.domain.BonusNumber;
import lotto.domain.GeneralWinNumber;
import lotto.domain.Lotto;
import lotto.domain.WinNumber;
import lotto.presentation.view.LottoGamePrinter;
import lotto.presentation.view.LottoGameReader;

public class LottoGameController {

    public static void start() {
        List<Lotto> lottos = LottoService.getLottos(LottoGameReader.readLottoAmount());
        LottoGamePrinter.printLottos(lottos);

        GeneralWinNumber generalWinNumber = new GeneralWinNumber(LottoGameReader.readWinNumber());
        BonusNumber bonusNumber = new BonusNumber(LottoGameReader.readBonusNumber());
        WinNumber winNumber = LottoService.getWinNumber(generalWinNumber,bonusNumber);
    }

}
