package lotto;

import static constance.Texts.*;
import static constance.Values.*;

import java.util.List;

public class Game {

    public static final Checker checker = new Checker();
    private User user;
    private WinningLotto winningLotto;

    public void run() {
        this.play();
    }

    public void play() {

        String amount;
        String numbers;
        String bonusNumber;
        int checkedAmount;
        List<Integer> checkedNumbers;
        int checkedBonusNumber;
        List<Lotto> lotteries;
        List<Result> results;
        int winnings;
        int printBonus;
        int winningBonus;
        List<List<Result>> userResults;
        int lotteryCount;
        float lotteryStat;

        checkedAmount=-1;
        while(checkedAmount<0) {
            try {
                System.out.println(LOTTO_USER_INPUT_PURCHASE_AMOUNT);
                amount = camp.nextstep.edu.missionutils.Console.readLine();
                checkedAmount = checker.checkAmountInput(amount);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(LOTTO_GAME_RESTART);
            }
        }

        user = new User(checkedAmount);

        System.out.println();
        System.out.println(String.format(LOTTO_USER_PURCHASE_RESULT, user.getLotteryCount(), user.getLotteryList()));

        System.out.println(LOTTO_USER_INPUT_WINNING_NUMBERS);
        numbers = camp.nextstep.edu.missionutils.Console.readLine();

        checkedNumbers = checker.checkNumbersInput(numbers);

        System.out.println();
        System.out.println(LOTTO_USER_INPUT_BONUS_NUMBERS);
        bonusNumber = camp.nextstep.edu.missionutils.Console.readLine();

        checkedBonusNumber = checker.checkNumber(bonusNumber);

        winningLotto = new WinningLotto(checkedNumbers, checkedBonusNumber);

        System.out.println("!--Test: " + winningLotto);

        lotteries = user.getLotteries();
        results = checker.checkResults(lotteries, winningLotto);
        winnings = checker.checkWinnings(results);

        user.setResults(results);
        user.setWinnings(winnings);

        printBonus = 1;
        winningBonus = 2;
        userResults = user.getResults();
        for (List<Result> results1 : userResults) System.out.println("!--Test: " + results1);

        lotteryCount = user.getLotteryCount();
        lotteryStat = checker.checkLotteryStat(winnings, lotteryCount);
        user.setLotteryStat(lotteryStat);

        System.out.println();
        System.out.println(LOTTO_GAME_WINNING_STATS);
        System.out.println(LOTTO_GAME_DIVISION);
        for (int i = MIN_COINCIDE; i < WINNINGS.length - 1; ++i) {
            String coincideMessage;
            if (i == 6 && printBonus > 0) {
                i -= 1;
                coincideMessage = String.format(LOTTO_GAME_COINCIDE_RESULT, i, LOTTO_GAME_COINCIDE_BONUS,
                        DECIMAL_FORMAT.format(WINNINGS[i + winningBonus]), userResults.get(i).size());
                printBonus = 0;
                winningBonus = 0;
            } else {
                coincideMessage = String.format(LOTTO_GAME_COINCIDE_RESULT, i, "",
                        DECIMAL_FORMAT.format(WINNINGS[i]), userResults.get(i).size());
            }
            System.out.println(coincideMessage);
        }
        System.out.println(String.format(LOTTO_GAME_LOTTERY_RETURN, lotteryStat));

    }
}
