package lotto.presentation.view;

import constants.LottoGameMessage;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGamePrinter {

    public static void printEnterLottoAmount() {
        System.out.println(LottoGameMessage.READ_LOTTO_COUNT);
    }

    public static void printEnterWinNumber() {
        System.out.println(LottoGameMessage.READ_WIN_NUMBER);
    }

    public static void printEnterBonusNumber() {
        System.out.println(LottoGameMessage.READ_BONUS_NUMBER);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto));
    }

}
