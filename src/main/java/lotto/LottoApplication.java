package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.input.Input;
import lotto.input.InputValidator;
import lotto.lotto.Buy;
import lotto.lotto.Lotto;
import lotto.lotto.LottoCalculator;
import lotto.lotto.LottoCompare;
import lotto.lotto.LottoConvertor;
import lotto.rank.Rank;
import lotto.ui.LottoPrint;

public class LottoApplication {
    private static final LottoPrint print = new LottoPrint();
    private static final Input input = new Input();
    private static final InputValidator inputValidator = new InputValidator();
    private static final Buy buy = new Buy();
    private static final LottoConvertor convertor = new LottoConvertor();
    private static final LottoCompare compare = new LottoCompare();


    public static void run() {
        String playerRequest;
        LottoApplication app = new LottoApplication();
        Map<Rank, Integer> prizeState = new HashMap<>();

        print.buyLottoPrice();
        playerRequest = input.request();
        int playerPrice = app.validationConvertInput(playerRequest);

        if (playerPrice == -1) { // 프로그램 종료 *특이케이스
            return;
        }

        app.priceValidation(playerPrice);

        int lottoBuyCount = buy.lottoQuantity(playerPrice);
        print.buyLotto(lottoBuyCount);

        LottoCalculator lottoCalculator = new LottoCalculator(playerPrice);

        List<Lotto> buyLottos = Lotto.buyLotto(lottoBuyCount);
        print.buyLottoNumbers(buyLottos);

        print.prizeNumber();
        playerRequest = input.request();

        Lotto lotto = new Lotto(app.prizeNumbersValidation(playerRequest));

        print.bonusNumber();
        playerRequest = input.request();
        int bonusNumber = app.bonusNumberValidation(playerRequest, lotto);

        for (Rank rank : Rank.values()) {
            prizeState.put(rank, 0);
        }

        for (Lotto buyLotto : buyLottos) {
            app.comparePrizeState(prizeState, lotto, bonusNumber, buyLotto);
        }

        lottoCalculator.calPrizeProfit(prizeState);
        print.stats(prizeState);
        print.rate(lottoCalculator.getRate());
    }

    private int validationConvertInput(String playerRequest) {
        inputValidator.validationInputLength(playerRequest);
        return input.convertInput(playerRequest);
    }

    private void priceValidation(int playerPrice) {
        inputValidator.validationZeroAmount(playerPrice);
        inputValidator.validationAmount(playerPrice);
    }

    private List<Integer> prizeNumbersValidation(String playerRequest) {
        inputValidator.validationInputLength(playerRequest);
        String[] splitNumbers = convertor.splitNumbers(playerRequest);
        List<Integer> prizeNumbers = convertor.convertNumbers(splitNumbers);
        return prizeNumbers;
    }

    private int bonusNumberValidation(String playerRequest, Lotto lotto) {
        int bonusNumber = input.convertInput(playerRequest);
        lotto.validationNumberInRange(bonusNumber);
        lotto.duplicationBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void comparePrizeState(Map<Rank, Integer> prizeStatus, Lotto lotto, int bonusNumber, Lotto buyLotto) {
        int compareCount = compare.getCompareCount(buyLotto.getNumbers(), lotto.getNumbers());
        boolean bonusCheck = compare.getBonusCheck(bonusNumber, buyLotto.getNumbers());

        if (bonusCheck) {
            compareCount++;
        }

        Rank rank = Rank.getRank(compareCount, bonusCheck);
        prizeStatus.put(rank, prizeStatus.getOrDefault(rank, 0) + 1);
    }
}
