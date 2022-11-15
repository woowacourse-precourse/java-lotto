package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.inputValidators.MoneyValidator;
import lotto.inputValidators.NumberValidator;
import lotto.messages.ErrorMessage;
import lotto.messages.InputMessage;
import lotto.messages.LotteryMachineMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LotteryMachine {

    private Lotto winningLotto;
    private int bonusNumber;


    public int getUserMoneyInput() {
        System.out.println(InputMessage.USER_MONEY_INPUT_MESSAGE.getMessage());
        String userInput = readLine();
        System.out.println();
        if (!MoneyValidator.isValidMoneyInput(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_INPUT_ERROR_MESSAGE.getMessage());
        }

        return Integer.parseInt(userInput);
    }

    public int calculateNumOfLotteries(int money) {
        int numberOfLotteries = money / LotteryNumber.LOTTERY_PRICE.getNumber();
        System.out.println(numberOfLotteries
                + LotteryMachineMessage.PURCHASED_LOTTERY_NUMBER_MESSAGE.getMessage());
        return numberOfLotteries;
    }

    public List<Lotto> generateLotteries(int numberOfLotteries) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < numberOfLotteries; ++i) {
            List<Integer> lotteryNumbers =
                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotteryNumbers = sortNumbersByAscendingOrder(lotteryNumbers);
            Lotto lotto = new Lotto(lotteryNumbers);
            System.out.println(lotteryNumbers);
            lotteries.add(lotto);
        }
        System.out.println();
        return lotteries;
    }

    private List<Integer> sortNumbersByAscendingOrder(List<Integer> lotteryNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>();
        for (int lotteryNumber : lotteryNumbers) {
            sortedNumbers.add(lotteryNumber);
        }
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    public void drawLottery() {
        String[] winningNumbersInput = getWinningNumbersInput();

        if (!NumberValidator.isValidWinningNumbers(winningNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage
                    .DRAW_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
        List<Integer> winningNumbers = transformFormatOfWinningNumbers(winningNumbersInput);
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = drawBonusNumber();
    }

    private String[] getWinningNumbersInput() {
        System.out.println(InputMessage.WINNING_LOTTERY_INPUT_MESSAGE.getMessage());
        String[] winningNumbersInput = readLine().split(",");
        System.out.println();

        return winningNumbersInput;
    }

    private List<Integer> transformFormatOfWinningNumbers(String[] winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < winningNumbersInput.length; ++i) {
            winningNumbers.add(Integer.parseInt(winningNumbersInput[i]));
        }

        winningNumbers.sort(Comparator.naturalOrder());
        return winningNumbers;
    }

    private int drawBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        String bonusNumberInput = readLine();
        System.out.println();

        if (!NumberValidator.isValidBonusNumber(bonusNumberInput, winningLotto.getNumbers())) {
            throw new IllegalArgumentException(
                    ErrorMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
        return Integer.parseInt(bonusNumberInput);
    }

    public void showResult(int userMoney, List<Lotto> userLotteries, Map<Result, Integer> userWinningLotteryCounts) {
        System.out.println(LotteryMachineMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        aggregateResult(userLotteries, userWinningLotteryCounts);
        for (Result result : Result.values()) {
            System.out.println(result.getMessage() + userWinningLotteryCounts.get(result)
                    + result.getUnitMessage());
        }
        long totalPrize = calculateTotalPrize(userWinningLotteryCounts);
        double rateOfReturn = calculateRateOfReturn(userMoney, totalPrize);
        printRateOfReturn(rateOfReturn);
    }

    private void aggregateResult(List<Lotto> userLotteries,
                                 Map<Result, Integer> userWinningLotteryCounts) {
        for (Lotto userLottery : userLotteries) {
            int count = countMatchNumbers(userLottery);
            if (count < LotteryNumber.MINIMUM_MATCH_NUMBER.getNumber()) {
                continue;
            }
            Result result = getResult(count, userLottery);
            userWinningLotteryCounts.put(result, userWinningLotteryCounts.get(result) + 1);
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
        if (count != LotteryNumber.FIVE_NUMBERS_MATCH.getNumber()) {
            return Result.findResultByCount(count);
        }
        List<Integer> userLotteryNumbers = userLottery.getNumbers();
        if (userLotteryNumbers.contains(bonusNumber)) {
            return Result.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCH;
        }
        return Result.FIVE_NUMBERS_MATCH;
    }

    public long calculateTotalPrize(Map<Result, Integer> userWinningLotteryCounts) {
        long totalPrize = 0;
        for (Result result : Result.values()) {
            long prize = userWinningLotteryCounts.get(result) * result.getPrize();
            totalPrize += prize;
        }
        return totalPrize;
    }

    public double calculateRateOfReturn(int userMoney, long userTotalPrize) {
        return (double)userTotalPrize / userMoney * LotteryNumber.PERCENT.getNumber();
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.print(LotteryMachineMessage.RATE_OF_RETURN_MESSAGE_PREFIX.getMessage());
        System.out.print(String.format("%.1f", rateOfReturn));
        System.out.println(LotteryMachineMessage.RATE_OF_RETURN_MESSAGE_POSTFIX.getMessage());
    }

    public void setWinningLotto(Lotto winningLotto) { // for test
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) { // for test
        this.bonusNumber = bonusNumber;
    }
}