package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.Consumer;
import lotto.entity.Lotto;
import lotto.entity.Result;
import lotto.entity.WinningLotto;
import lotto.service.InputService;
import lotto.service.OutputService;
import lotto.util.Converter;

public class LottoApplication {

    public final static int COUNT = 6;
    public final static int PRICE = 1000;
    public final static int RANGE_START = 1;
    public final static int RANGE_END = 45;

    private final Converter<String, Integer> numericConverter;
    private final Converter<String, List<Integer>> multipleNumericConverter;

    public LottoApplication(Converter<String, Integer> numericConverter,
            Converter<String, List<Integer>> multipleNumericConverter) {
        this.numericConverter = numericConverter;
        this.multipleNumericConverter = multipleNumericConverter;
    }

    public void play() {
        try {
            int purchase = getPurchase();
            Consumer consumer = new Consumer(buyLottos(purchase / PRICE));
            Lotto winningNumberLotto = getWinningNumberLotto();
            int bonus = getBonus();
            WinningLotto winningLotto = new WinningLotto(winningNumberLotto, bonus);
            Result result = new Result(consumer.confirmResult(winningLotto));
            printResult(result);
        } catch (IllegalArgumentException e) {
            OutputService.printErrorMessage(e.getMessage());
        }
    }

    private int getPurchase() {
        String purchaseInput = InputService.readPurchase();
        int purchase = numericConverter.convert(purchaseInput);
        validatePurchase(purchase);
        return purchase;
    }

    private void validatePurchase(int purchase) {
        validateUnit(purchase);
        validateNegative(purchase);
    }

    private void validateUnit(int purchase) {
        if (purchase % PRICE != 0) {
            throw new IllegalArgumentException(
                    String.format("금액은 %d원 단위로 입력해야 합니다. 입력 : %s", PRICE, purchase));
        }
    }

    private void validateNegative(int purchase) {
        if (purchase < 0) {
            throw new IllegalArgumentException(
                    String.format("로또를 구입할 수 없는 금액입니다. 입력 : %d", purchase));
        }
    }

    private List<Lotto> buyLottos(int count) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(
                        i -> new Lotto(
                                Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, COUNT)))
                .collect(Collectors.toList());
        OutputService.printGeneratedLottos(lottos);
        return lottos;
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
