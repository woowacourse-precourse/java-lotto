package lotto;

import lotto.entity.Consumer;
import lotto.entity.Lotto;
import lotto.entity.Result;
import lotto.entity.WinningLotto;
import lotto.service.InputService;
import lotto.service.OutputService;
import lotto.util.StringToNumberConverter;
import lotto.util.StringToNumbersConverter;

public class LottoApplication {

    public final static int COUNT = 6;
    public final static int RANGE_START = 1;
    public final static int RANGE_END = 45;
    public final static int PRICE = 1000;

    private final StringToNumberConverter stringToNumberConverter;
    private final StringToNumbersConverter stringToNumbersConverter;

    public LottoApplication() {
        stringToNumberConverter = new StringToNumberConverter();
        stringToNumbersConverter = new StringToNumbersConverter();
    }

    public void play() {
        try {
            String purchaseInput = InputService.readPurchaseAmount();
            Integer purchase = stringToNumberConverter.convert(purchaseInput);
            Consumer consumer = new Consumer(purchase);
            String winningNumberInput = InputService.readWinningNumber();
            Lotto winningNumberLotto = new Lotto(
                stringToNumbersConverter.convert(winningNumberInput));
            String bonusInput = InputService.readBonusNumber();
            Integer bonus = stringToNumberConverter.convert(bonusInput);
            WinningLotto winningLotto = new WinningLotto(winningNumberLotto, bonus);
            Result result = consumer.confirmResultOfLottos(winningLotto);
            OutputService.printResult(result);
            OutputService.printRateOfReturn(result.calculateRateOfReturn());
        } catch (IllegalArgumentException e) {
            OutputService.printErrorMessage(e.getMessage());
        }
    }

}
