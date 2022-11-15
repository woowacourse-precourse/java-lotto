package lotto;

import lotto.domain.Lottos;
import lotto.domain.LottosGenerator;
import lotto.domain.Money;
import lotto.domain.RandomNumbersGenerationStrategy;
import lotto.domain.Result;
import lotto.domain.WinningNumber;

import static lotto.ui.InputView.*;
import static lotto.ui.OutputView.*;

public class Application {

    public static void main(String[] args) {
        try {
            LottosGenerator generator = new LottosGenerator(new RandomNumbersGenerationStrategy());
            Money money = new Money(money());
            WinningNumber winningNumber = new WinningNumber(winningNumber(), bonusNumber());

            Lottos lottos = generator.lottos(money.count());
            printLottos(lottos);

            Result result = new Result(lottos.compare(winningNumber), money);
            printResult(result);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        } catch (Exception e) {
            printUnexpectedErrorMessage();
        }
    }
}
