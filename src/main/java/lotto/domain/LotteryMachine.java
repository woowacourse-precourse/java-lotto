package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.inputValidators.MoneyValidator;
import lotto.inputValidators.NumberValidator;
import lotto.messages.InputMessage;
import lotto.messages.LotteryMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LotteryMachine {

    private static final int MINIMUM_MATCH_NUMBER = 3;
    private static final int FIVE_NUMBERS_MATCH = 5;
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    private Lotto winningLotto;
    private int bonusNumber;


    public int getUserMoneyInput() {
        System.out.println(InputMessage.USER_MONEY_INPUT_MESSAGE.getMessage());
        String userInput = readLine();
        System.out.println();
        MoneyValidator.validateInputMoney(userInput);

        return Integer.parseInt(userInput);
    }

    public int calculateNumOfLotteries(int money) {
        int numberOfLotteries = money / LotteryNumber.LOTTERY_PRICE.getNumber();
        System.out.println(numberOfLotteries + LotteryMessage.PURCHASED_LOTTERY_NUMBER_MESSAGE.getMessage());
        return numberOfLotteries;
    }

    public List<Lotto> generateLotteries(int numberOfLotteries) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < numberOfLotteries; ++i) {
            List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotteryNumbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(lotteryNumbers);
            System.out.println(lotteryNumbers);
            lotteries.add(lotto);
        }
        System.out.println();
        return lotteries;
    }

    public void drawLottery() {
        System.out.println(InputMessage.WINNING_LOTTERY_INPUT_MESSAGE.getMessage());
        String[] winningNumbersInput = readLine().split(",");

        NumberValidator.validateWinningNumbers(winningNumbersInput);
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < winningNumbersInput.length; ++i) {
            winningNumbers.add(Integer.parseInt(winningNumbersInput[i]));
        }
        winningNumbers.sort(Comparator.naturalOrder());
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = drawBonusNumber();
    }

    private int drawBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        String bonusNumberInput = readLine();

        NumberValidator.validateBonusNumber(bonusNumberInput, winningLotto.getNumbers());
        return Integer.parseInt(bonusNumberInput);
    }

    public void showResult(User user) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        aggregateResult(user.getLotteries(), user.getWinningLotteryCounts());
        for (Result result : Result.values()) {
            System.out.println(result.getMessage() + user.getWinningLotteryCounts().get(result)
                    + result.getUnitMessage());
        }

    }

    private void aggregateResult(List<Lotto> userLotteries, Map<Result, Integer> userWinningCounts) {
        for (Lotto userLottery : userLotteries) {
            int count = countMatchNumbers(userLottery);
            if (count < MINIMUM_MATCH_NUMBER) {
                continue;
            }
            Result result = getResult(count, userLottery);
            userWinningCounts.put(result, userWinningCounts.get(result) + 1);
        }
    }

    private int countMatchNumbers(Lotto userLottery) {
        int count = 0;
        List<Integer> userLotteryNumbers = userLottery.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (int number : userLotteryNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private Result getResult(int count, Lotto userLottery) {
        if (count != FIVE_NUMBERS_MATCH) {
            return Result.findResultByCount(count);
        }
        List<Integer> userLotteryNumbers = userLottery.getNumbers();
        if (userLotteryNumbers.contains(bonusNumber)) {
            return Result.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCH;
        }
        return Result.FIVE_NUMBERS_MATCH;
    }

    public void calculateTotalPrize(User user) {
        long totalPrize = 0;
        for (Result result : Result.values()) {
            long prize = user.getWinningLotteryCounts().get(result) * result.getPrize();
            totalPrize += prize;
        }
        user.setTotalPrize(totalPrize);
    }

    public void calculateRateOfReturn(User user) {
        int userMoney = user.getMoney();
        long totalPrize = user.getTotalPrize();
        double rateOfReturn = (double)totalPrize / userMoney;
        user.setRateOfReturn(rateOfReturn);
    }

    public void setWinningLotto(Lotto winningLotto) { // for test
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) { // for test
        this.bonusNumber = bonusNumber;
    }
}