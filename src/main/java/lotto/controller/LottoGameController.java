package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.MarginCalculator;
import lotto.domain.StatisticsBuilder;
import lotto.domain.Validator;
import lotto.view.IOProcessor;
import java.util.List;

public class LottoGameController {
    public static void run() {
        LottoStore store = new LottoStore();
        StatisticsBuilder builder = new StatisticsBuilder();
        String userInput = IOProcessor.getUserInput("구입금액을 입력해 주세요.", "\n");
        Validator.amountIsValid(userInput, 1000);
        store.purchaseLotto(Integer.parseInt(userInput)); // 로또를 구매함
        IOProcessor.printLottoPurchaseInfo(store.getPurchasedLotto());
        userInput = IOProcessor.getUserInput("당첨 번호를 입력해 주세요.", "\n");
        List<Integer> winningNumber = Validator.winningNumberIsValid(userInput);
        userInput = IOProcessor.getUserInput("보너스 번호를 입력해 주세요.", "\n");
        int bonus_number = Validator.bonusNumberIsValid(userInput, winningNumber);
        builder.build(winningNumber, bonus_number, store.getPurchasedLotto());
        builder.printWinningInfo();
        double marginRatio = MarginCalculator.getMarginRatio(builder.getWinningInfo(), store.getPurchasedLotto().size());
        IOProcessor.printMarginInfo(marginRatio);
    }
}
