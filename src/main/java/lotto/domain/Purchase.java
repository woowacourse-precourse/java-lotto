package lotto.domain;

import java.util.List;

import static lotto.domain.Amount.*;
import static lotto.domain.Lotto.*;
import static lotto.domain.WinningNumber.*;
import static lotto.util.Output.*;
import static lotto.util.Input.*;

public class Purchase {

    public static void lotto() {

        printAmountInputText();
        Amount amount = pay(inputAmount());

        List<Lotto> lottos = create(amount.getCount());
        printLottos(lottos);

        printInputWinningNumber();
        WinningNumber winningNumber = draw(inputWinningNumbers());

        printInputBonusNumber();
        winningNumber.addBonus(inputBonusNumber());

        Result.of(lottos, winningNumber).printStatistics(amount);
    }
}
