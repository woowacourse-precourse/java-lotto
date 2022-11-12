package lotto;

import lotto.entity.Consumer;
import lotto.entity.Lotto;
import lotto.entity.Result;
import lotto.entity.WinningLotto;
import lotto.service.InputService;
import lotto.service.OutputService;
import lotto.util.NumericConverter;
import lotto.util.MultipleNumericConverter;

public class LottoApplication {

    public final static int COUNT = 6;
    public final static int PRICE = 1000;
    public final static int RANGE_START = 1;
    public final static int RANGE_END = 45;

    private final NumericConverter numericConverter;
    private final MultipleNumericConverter multipleNumericConverter;

    public LottoApplication() {
        numericConverter = new NumericConverter();
        multipleNumericConverter = new MultipleNumericConverter();
    }

    public void play() {
        try {
            int purchase = getPurchase();
            Consumer consumer = new Consumer(purchase);
            Lotto winningNumberLotto = getWinningNumberLotto();
            int bonus = getBonus();
            WinningLotto winningLotto = new WinningLotto(winningNumberLotto, bonus);
            printResult(consumer.confirmResultOfLottos(winningLotto));
        } catch (IllegalArgumentException e) {
            OutputService.printErrorMessage(e.getMessage());
        }
    }

    private int getPurchase() {
        String purchaseInput = InputService.readPurchaseAmount();
        return numericConverter.convert(purchaseInput);
    }

    private Lotto getWinningNumberLotto() {
        String winningNumberInput = InputService.readWinningNumber();
        return new Lotto(multipleNumericConverter.convert(winningNumberInput));
    }

    private int getBonus() {
        String bonusInput = InputService.readBonusNumber();
        return numericConverter.convert(bonusInput);
    }

    private void printResult(Result result) {
        OutputService.printResult(result);
        OutputService.printRateOfReturn(result.calculateRateOfReturn());
    }

}
