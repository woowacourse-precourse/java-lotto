package lotto;

import static lotto.constants.ConsoleConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constants.ConsoleConstants.INPUT_PURCHASE_MESSAGE;
import static lotto.constants.ConsoleConstants.INPUT_WINNING_NUMBER_MESSAGE;
import static lotto.constants.ConsoleConstants.LOTTO_COUNT;
import static lotto.constants.ConsoleConstants.PRIZE_RESULT;
import static lotto.constants.ConsoleConstants.PRIZE_STAT;
import static lotto.constants.ConsoleConstants.PROFIT;
import static lotto.constants.ConsoleConstants.SECOND_PRIZE_RESULT;
import static lotto.constants.ConsoleConstants.SPLIT_LINE;
import static lotto.constants.RegexConstants.COMMA;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.Validator;

public class GameConsole {

    public int inputPurchase() {
        notice(INPUT_PURCHASE_MESSAGE);
        String purchase = Console.readLine();
        Validator.purchase(purchase);

        return Integer.parseInt(purchase);
    }

    public List<Integer> inputWinningNumber() {
        notice(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        Validator.winningNumbers(winningNumber);

        return Arrays.stream(winningNumber.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void notice(String inputMessage) {
        System.out.println(inputMessage);
    }

    public int inputBonusNumber() {
        notice(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        Validator.bonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public void outputLottos(int lottoCount, List<Lotto> lottos) {
        System.out.printf(LOTTO_COUNT, lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void outputResult(Result result) {
        outputGameResult(result);
        outputWinningAmount(result);
    }

    private void outputGameResult(Result result) {
        System.out.println(PRIZE_STAT);
        System.out.println(SPLIT_LINE);

        Map<Rank, Integer> rankInfo = result.sortedRankInfo();
        rankInfo.remove(Rank.NONE);

        for (Rank rank : rankInfo.keySet()) {
            System.out.printf(PRIZE_RESULT, rank.getMatchCount(), rank.getPrize(), rankInfo.get(rank));
            if (rank == Rank.SECOND) {
                System.out.printf(SECOND_PRIZE_RESULT, rank.getMatchCount(), rank.getPrize(), rankInfo.get(rank));
            }
        }
    }

    private void outputWinningAmount(Result result) {
        System.out.printf(PROFIT, result.getWinningAmount());
    }
}
