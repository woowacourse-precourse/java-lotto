package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LotteryMachine {

    private static final int LOTTERY_PRICE = 1_000;
    private static final int MINIMUM_MATCH_NUMBER = 3;
    private static final int THREE_NUMBERS_MATCH = 3;
    private static final int FOUR_NUMBERS_MATCH = 4;
    private static final int FIVE_NUMBERS_MATCH = 5;
    private static final int SIX_NUMBERS_MATCH = 6;
    private static final String USER_MONEY_INPUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTERY_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_LOTTERY_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    private Lotto winningLotto;
    private int bonusNumber;

    public void purchaseLottery(User user) {
        user.setMoney(getUserMoneyInput(user));
        user.setNumberOfLotteries(calculateNumOfLotteries(user));
        user.setLotteries(generateLotteries(user.getNumberOfLotteries()));
    }

    public int getUserMoneyInput(User user) {
        System.out.println(USER_MONEY_INPUT_MESSAGE);
        String userInput = readLine();
        System.out.println();
        InputValidator validator = new InputValidator();

        validator.validateInputMoney(userInput);
        return Integer.parseInt(userInput);
    }

    public int calculateNumOfLotteries(User user) {
        int numberOfLotteries = user.getMoney() / LOTTERY_PRICE;
        System.out.println(numberOfLotteries + PURCHASED_LOTTERY_NUMBER_MESSAGE);
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
        System.out.println(WINNING_LOTTERY_INPUT_MESSAGE);
        String[] winningNumbersInput = readLine().split(",");

        InputValidator validator = new InputValidator();
        validator.validateWinningNumbers(winningNumbersInput);

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < winningNumbersInput.length; ++i) {
            winningNumbers.add(Integer.parseInt(winningNumbersInput[i]));
        }
        winningNumbers.sort(Comparator.naturalOrder());
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = drawBonusNumber();
    }

    private int drawBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumberInput = readLine();

        InputValidator validator = new InputValidator();
        validator.validateBonusNumber(bonusNumberInput, winningLotto.getNumbers());
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