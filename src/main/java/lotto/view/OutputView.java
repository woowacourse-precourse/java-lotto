package lotto.view;

import lotto.enums.OutputMessage;
import lotto.enums.Ranking;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public int outputEnterMoney() {
        System.out.println(OutputMessage.OUTPUT_ENTER_MONEY.getOutput());
        return InputView.convertToNumber();
    }

    public List<Integer> outputEnterLottoAnswer() {
        System.out.println(OutputMessage.OUTPUT_ENTER_LOTTO_ANSWER.getOutput());
        return InputView.convertToList();
    }

    public int outputEnterBonusNumber() {
        System.out.println(OutputMessage.OUTPUT_ENTER_BONUS_NUMBER.getOutput());
        return InputView.convertToNumber();
    }

    public void outputPurchaseSuccess(List<Lotto> userLottos) {
        System.out.println(OutputMessage.OUTPUT_PURCHASE_SUCCESS.purchaseSuccess(userLottos.size()));
        for(Lotto userLotto : userLottos) {
            System.out.println(userLotto.getNumbers());
        }
    }

    public void outputWinningResults(Map<Ranking, Integer> winningResults, double profitPercent) {
        System.out.println(OutputMessage.OUTPUT_WINNING_RESULTS_TITLE.getOutput());
        System.out.println(OutputMessage.OUTPUT_LINE.getOutput());
        for (Ranking ranking : Ranking.values()) {
            System.out.println(
                    OutputMessage.OUTPUT_WINNING_RESULTS_DESCRIPTION.winningResultsDescription(
                            ranking.description(), winningResults.get(ranking)));
        }
        System.out.println(OutputMessage.OUTPUT_PROFIT_PERCENT_IS.profitPercent(profitPercent));
    }

}
