package lotto;

import static constance.Values.*;
import static constance.Values.Texts.*;
import static constance.Values.Constants.*;

import java.util.List;
import java.util.function.Function;

public class Game {

    public int inputAmount(){
        int checkedAmount = -1;
        while (checkedAmount < 0) {
            try {
                System.out.println(PURCHASE_AMOUNT.message());
                String amount = camp.nextstep.edu.missionutils.Console.readLine();
                checkedAmount = checker.checkAmountInput(amount);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(RESTART.message());
            }
        }
        return checkedAmount;
    }

    public List<Integer> inputNumbers(){
        System.out.println("\n"+String.format(PURCHASE_RESULT.message(), user.getLotteryCount(), user.getLotteryList()));

        System.out.println(WINNING_NUMBERS.message());
        String numbers = camp.nextstep.edu.missionutils.Console.readLine();

        return checker.checkNumbersInput(numbers);
    }

    public int inputBonusNumber(){
        System.out.println("\n"+BONUS_NUMBERS.message());
        String bonusNumber = camp.nextstep.edu.missionutils.Console.readLine();

        return checker.checkNumber(bonusNumber);

    }

    public static final Checker checker = new Checker();
    private User user;
    private WinningLotto winningLotto;

    public void run() {
        this.play();
    }

    public void play() {
        List<Lotto> lotteries;
        List<Result> results;
        int winnings;
        int printBonus;
        int winningBonus;
        List<List<Result>> userResults;
        int lotteryCount;
        float lotteryStat;
        float userLotteryStat;

        user = new User(inputAmount());

        winningLotto = new WinningLotto(inputNumbers(), inputBonusNumber());

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
        System.out.println(WINNING_STATS.message());
        System.out.println(DIVISION.message());
        for (int i = MIN_COINCIDE.value(); i < WINNINGS.length - 1; ++i) {
            String coincideMessage;
            if (i == 6 && printBonus > 0) {
                i -= 1;
                coincideMessage = String.format(COINCIDE_RESULT.message(), i, COINCIDE_BONUS.message(),
                        DECIMAL_FORMAT.format(WINNINGS[i + winningBonus]), userResults.get(i + winningBonus).size());
                printBonus = 0;
                winningBonus = 0;
            } else {
                coincideMessage = String.format(COINCIDE_RESULT.message(), i, "",
                        DECIMAL_FORMAT.format(WINNINGS[i]), userResults.get(i).size());
            }
            System.out.println(coincideMessage);
        }

        userLotteryStat = user.getLotteryStat();
        System.out.println(String.format(LOTTERY_RETURN.message(), userLotteryStat));

    }
}
