package lotto.view.consoleoutput;

import lotto.constant.Information;
import lotto.constant.LottoRule;
import lotto.lotto.LottoCollection;

public class ConsoleOutput {
    public void printAmountOfLottos(int money) {
        int count = money / LottoRule.COST.getValueForRule();
        System.out.println(
                String.format(Information.PRINT_AMOUNT_OF_LOTTO.getMessage(), count)
        );
    }

    public void printAllNumberOfLottoCollection(LottoCollection lottoCollection) {
        System.out.print(lottoCollection.toString());
    }
}
