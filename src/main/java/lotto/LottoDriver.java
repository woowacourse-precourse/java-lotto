package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottoDriver {

    private static final int STOP_VALUE = -1;
    private static final int AMOUNT_UNIT = 1000;
    private static final int LOTTERY_NUMBER_LIMIT = 6;
    public static void startLottoGame(){

        System.out.println("구입금액을 입력해 주세요.");
        String buyingAmountString = Console.readLine();
        if (checkIfInteger(buyingAmountString) != STOP_VALUE && checkIf1000Unit(buyingAmountString) != STOP_VALUE){
            int buyingAmount = Integer.parseInt(buyingAmountString);
            final int countOfLottery = buyingAmount / AMOUNT_UNIT;
            System.out.println("\n" + countOfLottery + "개를 구매했습니다.");
            try{
                checkWinning(countOfLottery, buyingAmount);
            }
            catch(Exception e){
            }
        }
    }
    private static int checkIfInteger(String inputAmountString){
        int buyingAmount = 0;
        try{
            buyingAmount = Integer.parseInt(inputAmountString);
        } catch (Exception e){
            System.out.println("[ERROR] 구입 금액은 항상 정수로만 입력해야 합니다.");
            return STOP_VALUE;
        }
        return buyingAmount;
    }
    private static int checkIf1000Unit(String buyingAmountString){
        try{
            if (Integer.parseInt(buyingAmountString) % AMOUNT_UNIT != 0) throw new IllegalArgumentException();
        }
        catch (Exception e){
            System.out.println("[ERROR] 구입 금액은 항상 1000워 단위로 입력하셔야 합니다.");
            return STOP_VALUE;
        }
        return buyingAmount;
    }
    private static void checkWinning(int countOfLottery, int buyingAmount){
        ArrayList<ArrayList<Integer>> lotteryBundleArray = new ArrayList<>();
        int cntForCreateLottery = 0;
        while (cntForCreateLottery < countOfLottery){
            lotteryBundleArray.add(createAndPrintLottery());
            cntForCreateLottery++;
        }
        try{
            callLottoMethods(null, lotteryBundleArray, buyingAmount);
        }
        catch(Exception e){
            throw e;
        }
    }
    private static void callLottoMethods(Lotto lotto, ArrayList<ArrayList<Integer>> lotteryBundleArray, int buyingAmount) {
        try{
            lotto = new Lotto(inputWinningNumbers());
        }
        catch(Exception e){
            throw e;
        }
        ArrayList<BigInteger> countLottoWinnings;
        try{
            countLottoWinnings = lotto.countLottoWinnings(lotteryBundleArray, inputBonusWinningNumber());
        }
        catch (Exception e){
            throw e;
        }
        lotto.printLottoWinningsResult(countLottoWinnings, buyingAmount);
    }
    private static int inputBonusWinningNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try{
            return Integer.parseInt(Console.readLine());
        }
        catch (Exception e){
            System.out.println("[ERROR] 보너스 번호는 숫자 하나만 입력하셔야 합니다.");
            throw e;
        }
    }
    private static ArrayList<Integer> createAndPrintLottery(){
        List<Integer> tempLotteryArray = Randoms.pickUniqueNumbersInRange(1, 45, LOTTERY_NUMBER_LIMIT);
        ArrayList<Integer> lotteryNumberArray = new ArrayList<>();
        Iterator lotteryNumberItr = tempLotteryArray.iterator();
        while (lotteryNumberItr.hasNext()){
            lotteryNumberArray.add((int)lotteryNumberItr.next());
        }
        Collections.sort(lotteryNumberArray);
        System.out.println(lotteryNumberArray);
        return lotteryNumberArray;
    }
    private static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String tempWinningNumbersString = Console.readLine();
        ArrayList<Integer> winningNumbersArray = new ArrayList<>();
        for (String winningNumber : tempWinningNumbersString.split(",")){
            try{
                winningNumbersArray.add(Integer.parseInt(winningNumber));
            }
            catch (Exception e){
                System.out.println("[ERROR] 당첨 번호는 숫자와 ',' 만 입력하셔야 합니다.");
                throw new IllegalArgumentException();
            }
        }
        return winningNumbersArray;
    }
}
