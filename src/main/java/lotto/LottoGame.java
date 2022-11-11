package lotto;

import lotto.console.Input;
import lotto.console.Output;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoSeller;
import lotto.domain.match.Reward;
import lotto.domain.match.Results;
import lotto.domain.match.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

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
            output.writeLine(lotto.toString());
        }
        output.writeEmptyLine();
    }

    private List<Integer> inputWinningNumbers() {
        output.writeEnterWinningNumbers();
        List<Integer> numbers = input.readIntList();
        output.writeEmptyLine();

        return numbers;
    }

    private int inputBonusNumber() {
        output.writeEnterBonusNumber();
        int bonusNumber = input.readInt();
        output.writeEmptyLine();

        return bonusNumber;
    }

    private Results matchLottoWithWinningNumbers(List<Lotto> lottos,
            WinningNumbers winningNumbers) {
        List<Reward> rewards = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Reward reward = winningNumbers.match(lotto);
            if (reward != null) {
                rewards.add(reward);
            }
        }

        return new Results(rewards);
    }

    private void printStatistics(Results results) {
        output.writePrefixMatchStatistics();
        for (Reward reward : Reward.values()) {
            if (!reward.isRequireBonus()) {
                output.writeMatchStatistic(
                        reward.getMatch(),
                        reward.getReward(),
                        results.getCount(reward));
            }

            if (reward.isRequireBonus()) {
                output.writeMatchStatisticWithBonus(
                        reward.getMatch(),
                        reward.getReward(),
                        results.getCount(reward));
            }
        }
    }

    private void printYield(Results results, int money) {
        output.writeYield(results.getYield(money));
    }

    public void play() {
        try {
            int money = inputMoney();

            LottoSeller seller = new LottoSeller();
            List<Lotto> lottos = seller.buyLottos(money);

            printLottos(lottos);

            List<Integer> numbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber();
            WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

            Results results = matchLottoWithWinningNumbers(lottos, winningNumbers);

            printStatistics(results);
            printYield(results, money);
        } catch (IllegalArgumentException exception) {
            output.writeErrorMessage(exception.getMessage());
        }
    }
}
