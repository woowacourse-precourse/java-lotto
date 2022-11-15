package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class LottoDriver {
    private static final int AMOUNT_UNIT = 1000;
    private static final int LOTTERY_NUMBER_LIMIT = 6;
    private static int BUYING_AMOUNT = 0;
    public static void startLottoGame(){
        int[][] lotteryBundle = readyProcess();
        gameProcess(lotteryBundle);
    }
    private static int[][] readyProcess() {
        BUYING_AMOUNT = inputBuyingAmount();
        int countOfLottery =  BUYING_AMOUNT / AMOUNT_UNIT;
        new PrintDriver().printCountOfLotteryMessage(countOfLottery);
        int[][] lotteryBundle = createLotteryBundle(countOfLottery);
        new PrintDriver().printLotteryBundle(lotteryBundle);
        return lotteryBundle;
    }
    private static void gameProcess(int[][] lotteryBundle) {
        InputDriver InputDriver = new InputDriver();
        int bonusNumber;
        int[] inputNumbersArray;
        inputNumbersArray = createLottoNumbers();
        bonusNumber = InputDriver.inputBonusNumber(Arrays.stream(inputNumbersArray).boxed().collect(Collectors.toList()));
        new Lotto(Arrays.stream(inputNumbersArray).boxed().collect(Collectors.toList()));
        Profit profit = new Profit(inputNumbersArray, bonusNumber);
        int[] countCaseCount = profit.checkWinnings(lotteryBundle,bonusNumber);
        double totalProfitRate = profit.calculateProfitRate(countCaseCount,BUYING_AMOUNT);
        new PrintDriver().printStatusOfWinning(countCaseCount, totalProfitRate);
    }
    private static int[] createLottoNumbers(){
        InputDriver InputDriver = new InputDriver();
        int[] inputNumbersArray = InputDriver.inputNumbers();
        List<Integer> numbers = Arrays.stream(inputNumbersArray).boxed().collect(Collectors.toList());
        new Lotto(numbers);
        return inputNumbersArray;
    }
    private static int[][] createLotteryBundle(int countOfLottery) {
        int[][] lotteryBundleArray = new int[countOfLottery][LOTTERY_NUMBER_LIMIT];
        int cntForCreateLottery = 0;
        while (cntForCreateLottery < countOfLottery){
            lotteryBundleArray[cntForCreateLottery] = createLottery();
            cntForCreateLottery++;
        }
        return lotteryBundleArray;
    }
    private static int[] createLottery(){
        List<Integer> tempLotteryArray = Randoms.pickUniqueNumbersInRange(1, 45, LOTTERY_NUMBER_LIMIT);
        int[] lotteryNumberArray = new int[LOTTERY_NUMBER_LIMIT];
        Iterator lotteryNumberItr = tempLotteryArray.iterator();
        int index = 0;
        while (lotteryNumberItr.hasNext()){
            lotteryNumberArray[index++] = (int)lotteryNumberItr.next();
        }
        Arrays.sort(lotteryNumberArray);
        return lotteryNumberArray;
    }
    private static int inputBuyingAmount() {
        InputDriver InputDriver = new InputDriver();
        new PrintDriver().printInputBuyingAmountMessage();
        return InputDriver.inputBuyingAmount();
    }
}
