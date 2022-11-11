package lotto;

import lotto.console.Input;
import lotto.console.Output;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoSeller;
import lotto.domain.match.MatchAndReward;
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

    public void play() {
        output.writeEnterMoney();
        int money = input.readInt();
        output.writeEmptyLine();

        LottoSeller seller = new LottoSeller();
        List<Lotto> lottos = seller.buyLottos(money);

        output.writeBuyCount(lottos.size());
        for (Lotto lotto : lottos) {
            output.writeLine(lotto.toString());
        }
        output.writeEmptyLine();

        output.writeEnterWinningNumbers();
        List<Integer> numbers = input.readIntList();
        output.writeEmptyLine();

        output.writeEnterBonusNumber();
        int bonusNumber = input.readInt();
        output.writeEmptyLine();

        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);
        List<MatchAndReward> matchAndRewards = new ArrayList<>();

        for (Lotto lotto : lottos) {
            MatchAndReward matchAndReward = winningNumbers.match(lotto);
            if (matchAndReward != null) {
                matchAndRewards.add(matchAndReward);
            }
        }

        Results results = new Results(matchAndRewards);

        output.writePrefixMatchStatistics();
        for (MatchAndReward matchAndReward : MatchAndReward.values()) {
            if (!matchAndReward.isRequireBonus()) {
                output.writeMatchStatistic(
                        matchAndReward.getMatch(),
                        matchAndReward.getReward(),
                        results.getCount(matchAndReward));
            }

            if (matchAndReward.isRequireBonus()) {
                output.writeMatchStatisticWithBonus(
                        matchAndReward.getMatch(),
                        matchAndReward.getReward(),
                        results.getCount(matchAndReward));
            }
        }
        output.writeYield(results.getYield(money));
    }
}
