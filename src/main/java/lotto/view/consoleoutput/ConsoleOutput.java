package lotto.view.consoleoutput;

import lotto.constant.Directive;
import lotto.constant.Information;
import lotto.constant.LottoRule;
import lotto.domain.LottoCollection;

public class ConsoleOutput {
    public void printDirectiveAboutInputMoney() {
        System.out.println(Directive.INPUT_MONEY.getMessage());
    }
    public void printAmountOfLottos(int money) {
        int count = money / LottoRule.COST.getValueForRule();
        System.out.println(
                String.format(Information.PRINT_AMOUNT_OF_LOTTO.getMessage(), count)
        );
    }

    public void printAllNumberOfLottoCollection(LottoCollection lottoCollection) {
        System.out.print(lottoCollection.toString());
    }

    public void printDirectiveAboutInputWinningNumber() {
        System.out.println(Directive.INPUT_LOTTO_WINNING_NUMBER.getMessage());
    }

    public void printDirectiveAboutInputBonusNumber() {
        System.out.println(Directive.INPUT_BONUS_NUMBER.getMessage());
    }
}
