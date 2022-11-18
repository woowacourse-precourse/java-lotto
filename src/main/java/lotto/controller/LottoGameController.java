package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.MarginCalculator;
import lotto.domain.StatisticsBuilder;
import lotto.domain.Validator;
import lotto.view.IOProcessor;
import java.util.List;

public class LottoGameController {
    private static final LottoStore store = new LottoStore();
    private static final StatisticsBuilder builder = new StatisticsBuilder();
    private static List<Integer> winningNumber;
    private static int bonusNumber;
    private static final String delimiter = "\n";

    private enum Messages {
        REQUEST_AMOUNT("구입금액을 입력해 주세요."),
        REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static void run() {
        purchaseLotto(); // 구매금액을 입력받아 로또를 구매함
        getWinningAndBonusNumber(); // 당첨번호, 보너스 번호를 입력받음
        buildWinningStatistics(); // 입력정보를 바탕으로 당첨통계 정보를 구성함
        calculateMarginRatio(); // 수익률을 계산함
    }

    public static void purchaseLotto() {
        String userInput = IOProcessor.getUserInput(Messages.REQUEST_AMOUNT.getMessage(), delimiter);
        Validator.amountIsValid(userInput, 1000);
        store.purchaseLotto(Integer.parseInt(userInput)); // 로또를 구매함
        IOProcessor.printLottoPurchaseInfo(store.getPurchasedLotto());
    }

    public static void getWinningAndBonusNumber() {
        String userInput = IOProcessor.getUserInput(Messages.REQUEST_WINNING_NUMBER.getMessage(), delimiter);
        winningNumber = Validator.winningNumberIsValid(userInput);
        userInput = IOProcessor.getUserInput(Messages.REQUEST_BONUS_NUMBER.getMessage(), delimiter);
        bonusNumber = Validator.bonusNumberIsValid(userInput, winningNumber);
    }

    public static void buildWinningStatistics() {
        builder.build(winningNumber, bonusNumber, store.getPurchasedLotto());
        builder.printWinningInfo();
    }

    public static void calculateMarginRatio() {
        double marginRatio = MarginCalculator.getMarginRatio(builder.getWinningInfo(), store.getPurchasedLotto().size());
        IOProcessor.printMarginInfo(marginRatio);
    }
}
