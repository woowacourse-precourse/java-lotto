package lotto.view.consoleoutput;

import lotto.constant.Directive;
import lotto.constant.Information;
import lotto.constant.LottoAward;
import lotto.constant.LottoRule;
import lotto.domain.BunchOfLottos;
import lotto.domain.LottoStatistic;

import java.text.DecimalFormat;

public class ConsoleOutput {
    public void printDirectiveAboutInputMoney() {
        System.out.println(Directive.INPUT_MONEY.getMessage());
    }

    public void printInformationAboutAmountOfLotto(int money) {
        int count = money / LottoRule.COST.getValue();
        System.out.println(
                String.format(Information.AMOUNT_OF_LOTTO.getMessage(), count)
        );
    }

    public void printAllNumbersInBunchOfLottos(BunchOfLottos bunchOfLottos) {
        System.out.print(bunchOfLottos.toString());
    }

    public void printDirectiveAboutInputWinningNumbers() {
        System.out.println(Directive.INPUT_LOTTO_WINNING_NUMBER.getMessage());
    }

    public void printDirectiveAboutInputBonusNumber() {
        System.out.println(Directive.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printInformationAboutStatisticOfWinningLotto(LottoStatistic statistic, int money) {
        System.out.println(Information.WINNING_STATISTIC.getMessage());

        LottoAward[] values = LottoAward.values();
        //NONE은 출력하지 않으므로 index를 values.length - 2부터 설정한다.
        for (int index = values.length - 2; index >= 0; index--) {
            printInformationAboutCountOfLottoAwardOf(values[index], statistic.getWinningCount(values[index]));
        }

        System.out.println(String.format(Information.YIELD.getMessage(), statistic.getReturnOnInvestmentRatio(money)));
    }

    private void printInformationAboutCountOfLottoAwardOf(LottoAward value, int countOfWin) {
        String hasBonusBall = "";
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        if (value.getBonusCount() == 1) {
            hasBonusBall = Information.MATCH_WITH_BONUS.getMessage();
        }

        System.out.println(String.format(Information.COUNT_OF_WIN.getMessage(), value.getNormalCount(),
                hasBonusBall, decimalFormat.format(value.getReward()), countOfWin));
    }
}
