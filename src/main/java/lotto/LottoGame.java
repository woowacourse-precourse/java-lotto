package lotto;

import static lotto.domain.YieldCalculator.getYield;

import java.util.List;
import lotto.console.Input;
import lotto.console.Output;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoSeller;
import lotto.domain.match.Results;
import lotto.domain.match.Reward;
import lotto.domain.match.WinningNumbers;

public class LottoGame {

    private final Input input;
    private final Output output;

    public LottoGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    private int inputMoney() {
        output.writeEnterMoney();
        int money = input.readInt();
        output.writeEmptyLine();

        return money;
    }

    private void printLottos(List<Lotto> lottos) {
        output.writeBuyCount(lottos.size());
        for (Lotto lotto : lottos) {
            output.writeLottoNumbers(lotto.value());
        }
        output.writeEmptyLine();
    }

    private List<Integer> inputWinningStandardNumbers() {
        output.writeEnterWinningStandardNumbers();
        List<Integer> numbers = input.readIntList();
        output.writeEmptyLine();

        return numbers;
    }

    private int inputWinningBonusNumber() {
        output.writeEnterWinningBonusNumber();
        int bonusNumber = input.readInt();
        output.writeEmptyLine();

        return bonusNumber;
    }

    private WinningNumbers inputWinningNumbers() {
        List<Integer> standardNumbers = inputWinningStandardNumbers();
        int bonusNumber = inputWinningBonusNumber();

        return new WinningNumbers(standardNumbers, bonusNumber);
    }

    private void printStatisticsWithBonus(Results results, Reward reward) {
        output.writeMatchStatisticWithBonus(
                reward.getMatch(),
                reward.getReward(),
                results.getCount(reward));
    }

    private void printStatisticsWithNonBonus(Results results, Reward reward) {
        output.writeMatchStatistic(
                reward.getMatch(),
                reward.getReward(),
                results.getCount(reward));
    }

    private void printStatistics(Results results) {
        output.writePrefixMatchStatistics();
        for (Reward reward : Reward.values()) {
            if (!reward.isRequireBonus()) {
                printStatisticsWithNonBonus(results, reward);
            }

            if (reward.isRequireBonus()) {
                printStatisticsWithBonus(results, reward);
            }
        }
    }

    private void printYield(Results results, int money) {
        output.writeYield(getYield(results, money));
    }

    private List<Lotto> buyLottos(int money) {
        LottoSeller seller = new LottoSeller();
        return seller.buyLottos(money);
    }

    public void play() {
        try {
            int money = inputMoney();

            List<Lotto> lottos = buyLottos(money);
            printLottos(lottos);

            WinningNumbers winningNumbers = inputWinningNumbers();
            Results results = winningNumbers.matchAll(lottos);

            printStatistics(results);
            printYield(results, money);
        } catch (IllegalArgumentException exception) {
            output.writeErrorMessage(exception.getMessage());
        }
    }
}
