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
        String playerInput;
        LottoApplication app = new LottoApplication();
        Map<Rank, Integer> winStats = new HashMap<>();

        print.buyLottoPrice();
        playerInput = input.request();
        int playerPrice = app.validationConvertInput(playerInput);

        if (playerPrice == -1) { // 프로그램 종료 *특이케이스
            return;
        }

        app.priceValidation(playerPrice);

        int buyLottoCount = buy.lottoQuantity(playerPrice);
        print.buyLotto(buyLottoCount);

        LottoCalculator lottoCalculator = new LottoCalculator(playerPrice);

        List<Lotto> buyLottoes = Lotto.buyLotto(buyLottoCount);
        print.buyLottoNumbers(buyLottoes);

        print.winNumber();
        playerInput = input.request();

        Lotto lotto = new Lotto(app.winNumbersValidation(playerInput));

        print.bonusNumber();
        playerInput = input.request();
        int bonusNumber = app.bonusNumberValidation(playerInput, lotto);

        app.createPrizeState(winStats);

        for (Lotto buyLotto : buyLottoes) {
            app.comparePrizeState(winStats, lotto, bonusNumber, buyLotto);
        }

        lottoCalculator.calPrizeProfit(winStats);
        print.stats(winStats);
        print.rate(lottoCalculator.getRate());
    }

    private void createPrizeState(Map<Rank, Integer> winState) {
        for (Rank rank : Rank.values()) {
            winState.put(rank, 0);
        }
    }

    private int validationConvertInput(String playerRequest) {
        inputValidator.validationInputLength(playerRequest);
        return input.convertInput(playerRequest);
    }

    private void priceValidation(int playerPrice) {
        inputValidator.validationZeroAmount(playerPrice);
        inputValidator.validationAmount(playerPrice);
    }

    private List<Integer> winNumbersValidation(String playerRequest) {
        inputValidator.validationInputLength(playerRequest);
        String[] splitNumbers = convertor.splitNumbers(playerRequest);
        return convertor.convertNumbers(splitNumbers);
    }

    private int bonusNumberValidation(String playerRequest, Lotto lotto) {
        int bonusNumber = input.convertInput(playerRequest);
        lotto.validationNumberInRange(bonusNumber);
        lotto.duplicationBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void comparePrizeState(Map<Rank, Integer> winStatus, Lotto lotto, int bonusNumber, Lotto buyLotto) {
        int compareCount = compare.getCompareCount(buyLotto.getNumbers(), lotto.getNumbers());
        boolean bonusCheck = compare.getBonusCheck(bonusNumber, buyLotto.getNumbers());
        Rank rank = Rank.getRank(compareCount, bonusCheck);
        winStatus.put(rank, winStatus.getOrDefault(rank, 0) + 1);
    }
}
