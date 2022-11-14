package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.message.gameMessages.*;
import static lotto.message.errorMessages.*;
import static lotto.message.resultMessages.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = buyLotto();
        List<List> purchaseLotto = autoLotto(purchaseAmount);
        List<Integer> winnerLotto = winLotto();
        int bonusNumber = bonusLotto();
        List<List> compareResult = compareLotto(purchaseLotto,winnerLotto,bonusNumber);
        List<Integer> winCnt = gameResult(compareResult);
        printResult(winCnt);
        getMoney(winCnt, purchaseAmount);
    }

    public static int buyLotto(){
        System.out.println(AMOUNT_MONEY_INPUT);
        String moneyInput = Console.readLine();
        int buyAmount = 0;
        checkPurchaseException(moneyInput);
        buyAmount = Integer.parseInt(moneyInput)/1000;
        return buyAmount;
    }
    private static void checkPurchaseException(String moneyInput){
        int money = 0;
        try{
            money = Integer.parseInt(moneyInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
        if(money%1000!=0){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
    }

    public static List<List> autoLotto(int lottoAmount){
        System.out.println("\n"+lottoAmount+PURCHASE_AMOUNT);
        List<List> autoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> autoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new Lotto(autoNumber);
            System.out.println(autoNumber);
            autoNumbers.add(autoNumber);
        }
        return autoNumbers;
    }

    public static List<Integer> winLotto(){
        System.out.println(WIN_LOTTO_NUMBER_INPUT);
        String winNum = Console.readLine();
        checkWinLottoException(winNum);
        String[] inputNum = winNum.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (int i = 0; i < inputNum.length; i++) {
            winNumbers.add(Integer.parseInt(inputNum[i]));
        }
        new Lotto(winNumbers);

        return winNumbers;
    }
    private static void checkWinLottoException(String winNum) {
        String[] winLottoCheck = winNum.split("");
        int cnt = 0;
        for (int i = 0; i < winLottoCheck.length; i++) {
            if(winLottoCheck[i].equals(",")){
                cnt++;
            }
        }
        if(cnt!=5){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
        winLottoCheck = winNum.split(",");
        for (int i = 0; i < winLottoCheck.length; i++) {
            if(Integer.parseInt(winLottoCheck[i])>45 || Integer.parseInt(winLottoCheck[i])<1){
                throw new IllegalArgumentException(INPUT_RANGE_ERROR);
            }
        }
    }

    public static int bonusLotto(){
        System.out.println(BONUS_NUMBER_INPUT);
        String bonusNum = Console.readLine();
        int bonus = 0;
        checkBonusNumException(bonusNum);
        bonus = Integer.parseInt(bonusNum);
        return bonus;
    }
    private static void checkBonusNumException(String bonusNum){
        int bonus = 0;
        try{
            bonus = Integer.parseInt(bonusNum);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
        if(bonus>45 || bonus<1){
            throw new IllegalArgumentException(INPUT_RANGE_ERROR);
        }
    }


    public static List<List> compareLotto(List<List> purchaseLotto, List<Integer> winNumbers, int bonusNumber){
        List<List> LottoPrize = new ArrayList<>();
        checkLottoInputException(bonusNumber, winNumbers);
        int cnt = 0;
        int bonusCnt = 0;
        for (int i = 0; i < purchaseLotto.size(); i++) {
            bonusCnt = 0;
            cnt = existNumber(purchaseLotto.get(i),winNumbers);
            if(cnt!=6){
                bonusCnt = existBonus(purchaseLotto.get(i),bonusNumber);
            }
            LottoPrize.add(resultLotto(cnt,bonusCnt));
        }
        return LottoPrize;
    }
    private static int existNumber(List myLotto, List<Integer> winNumbers){
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if(myLotto.contains(winNumbers.get(i))){
                cnt++;
            }
        }
        return cnt;
    }
    private static int existBonus(List myLotto, int bonusNumber){
        int cnt = 0;
        if(myLotto.contains(bonusNumber)){
            cnt++;
        }
        return cnt;
    }
    private static void checkLottoInputException(int bonusNumber, List<Integer> winNumbers){
        if(winNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ALREADY_EXISTED_NUMBER);
        }
    }


    public static List<Integer> resultLotto(int cnt, int bonusCnt){
        int[] prize = {0,0,0,0,0};
        List<Integer> prizeLotto = new ArrayList<>();

        if(cnt==6){
            prize[0]+=1;
        }
        if(bonusCnt==1 && cnt==5){
            prize[1]+=1;
        }
        if(bonusCnt==0 && cnt==5){
            prize[2]+=1;
        }
        if(cnt==4){
            prize[3]+=1;
        }
        if(cnt==3){
            prize[4]+=1;
        }

        for (int i = 0; i < prize.length; i++) {
            prizeLotto.add(prize[i]);
        }

        return prizeLotto;
    }


    public static List<Integer> gameResult(List<List> lottoResult){
        List<Integer> winLottoCnt = new ArrayList<>();
        int first=0, second=0, third=0, fourth=0, fifth=0;
        for (int i = 0; i < lottoResult.size(); i++) {
            first+=Integer.parseInt(String.valueOf(lottoResult.get(i).get(0)));
            second+=Integer.parseInt(String.valueOf(lottoResult.get(i).get(1)));
            third+=Integer.parseInt(String.valueOf(lottoResult.get(i).get(2)));
            fourth+=Integer.parseInt(String.valueOf(lottoResult.get(i).get(3)));
            fifth+=Integer.parseInt(String.valueOf(lottoResult.get(i).get(4)));
        }
        winLottoCnt.add(first);
        winLottoCnt.add(second);
        winLottoCnt.add(third);
        winLottoCnt.add(fourth);
        winLottoCnt.add(fifth);
        return winLottoCnt;
    }

    public static void printResult(List<Integer> winLottoCnt){
        System.out.println(RESULT_STATS);
        System.out.println(FIFTH_RESULT + winLottoCnt.get(4)+UNIT);
        System.out.println(FOURTH_RESULT + winLottoCnt.get(3)+UNIT);
        System.out.println(THIRD_RESULT+ winLottoCnt.get(2)+UNIT);
        System.out.println(SECOND_RESULT + winLottoCnt.get(1)+UNIT);
        System.out.println(FIRST_RESULT + winLottoCnt.get(0)+UNIT);
    }

    public static void getMoney(List<Integer> winLottoCnt, int purchaseAmount){
        int gettingMoney = 0;
        int buyingMoney = purchaseAmount*1000;
        gettingMoney+=FIRST_PRIZE*winLottoCnt.get(0);
        gettingMoney+=SECOND_PRIZE*winLottoCnt.get(1);
        gettingMoney+=THIRD_PRIZE*winLottoCnt.get(2);
        gettingMoney+=FOURTH_PRIZE*winLottoCnt.get(3);
        gettingMoney+=FIFTH_PRIZE*winLottoCnt.get(4);
        System.out.println(gettingMoney);
    }
}
