package lotto;

import static constance.Values.*;
import static constance.Values.Texts.*;
import static constance.Values.Constants.*;

import java.util.List;

public class Game {

    public int inputAmount() {
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

    public List<Integer> inputNumbers() {
        System.out.println(
                "\n" + String.format(PURCHASE_RESULT.message(), user.getLotteryCount(), user.getLotteryList()));
        System.out.println(WINNING_NUMBERS.message());
        String numbers = camp.nextstep.edu.missionutils.Console.readLine();
        return checker.checkNumbersInput(numbers);
    }

    public int inputBonusNumber() {
        System.out.println("\n" + BONUS_NUMBERS.message());
        String bonusNumber = camp.nextstep.edu.missionutils.Console.readLine();
        return checker.checkNumber(bonusNumber);
    }

    public void raffle(User user) {
        List<Lotto> lotteries = user.getLotteries();
        List<Result> results = checker.checkResults(lotteries, winningLotto);
        int winnings = checker.checkWinnings(results);
        user.setResults(results);
        user.setWinnings(winnings);
    }

    public void setLotteryStat(User user) {
        int winnings = user.getWinnings();
        int lotteryCount = user.getLotteryCount();
        float lotteryStat = checker.checkLotteryStat(winnings, lotteryCount);
        user.setLotteryStat(lotteryStat);
    }

    public void printResults(User user) {
        List<List<Result>> userResults = user.getResults();
        for (List<Result> results1 : userResults) {
            System.out.println("!--Test: " + results1);
        }
    }

    public void printCoincideResult(User user) {
        List<List<Result>> userResults = user.getResults();
        System.out.println("\n" + WINNING_STATS.message());
        System.out.println(DIVISION.message());
        for (int coincide = MIN_COINCIDE.value(); coincide <= MAX_COINCIDE.value(); ++coincide) {
            printCoincides(coincide, userResults);
        }
    }

    public void printCoincides(int coincide, List<List<Result>> userResults) {
        if (coincide == MAX_COINCIDE.value()) {
            System.out.println(String.format(COINCIDE_RESULT.message(), coincide - 1, COINCIDE_BONUS.message(),
                    DECIMAL_FORMAT.format(WINNINGS[WINNINGS.length - 1]), userResults.get(WINNINGS.length - 1).size()));
        }
        System.out.println(String.format(COINCIDE_RESULT.message(), coincide, "",
                DECIMAL_FORMAT.format(WINNINGS[coincide]), userResults.get(coincide).size()));
    }

    public void printLotteryStat(User user) {
        float userLotteryStat = user.getLotteryStat();
        System.out.println(String.format(LOTTERY_RETURN.message(), userLotteryStat));
    }

    public static final Checker checker = new Checker();
    private User user;
    private WinningLotto winningLotto;

    public void run() {
        this.play();
    }

    public void play() {
        user = new User(inputAmount());

        winningLotto = new WinningLotto(inputNumbers(), inputBonusNumber());

        raffle(user);

        setLotteryStat(user);

        printCoincideResult(user);

        printLotteryStat(user);
    }
}
