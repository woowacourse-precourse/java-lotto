package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Utility {

    public static final int minLottoNumber = 1;
    public static final int maxLottoNumber = 45;

    public static final String inputAmountMessage = "구입금액을 입력해 주세요.";
    public static final String purchaseLottoMessage = "개를 구매했습니다.";
    public static final String inputWinningNumbers = "당첨 번호를 입력해 주세요.";
    public static final String inputBonusNumber = "보너스 번호를 입력해 주세요.";
    public static final String winningStatistics = "당첨 통계";
    public static final String separateLine = "---";

    public static final long divisorNumber = 1000;
    public static final int noWinIndex = 5;

    public static List <String> winEnumNames = Arrays.asList("WIN60", "WIN51", "WIN50", "WIN40", "WIN30");

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static String receiveInput(){
        String input = Console.readLine();
        return input;
    }

    public static long calculateQuotient(long dividend, long divisor){
        return dividend/divisor;
    }

    public static List<Lotto> totalPurchaseLotto(long howManyLotto){
        List <Lotto> purchaseLotto = new ArrayList<>();
        Lotto curLotto;
        for(int i=0; i<howManyLotto; i++){
            curLotto = createLotto();
            purchaseLotto.add(curLotto);
            List <Integer> _curLotto = curLotto.getNumbers();
            printMessage(_curLotto.toString());
        }
        return purchaseLotto;
    }

    public static Lotto createLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

    public static List <Integer> saveWinningNumbers(String winningNumbers){
        List<String> splitWinningNumber = new ArrayList<String>(Arrays.asList(winningNumbers.split(",")));
        List<Integer> _winningNumbers = new ArrayList<>();
        for(int i=0; i<splitWinningNumber.size(); i++){
            int curNum = (int)Exception.checkNumeric(splitWinningNumber.get(i));
            Exception.checkNumberRange(minLottoNumber, maxLottoNumber, curNum);
            _winningNumbers.add(curNum);
        }
        return _winningNumbers;
    }

    public static List <Integer> findTotalLottoResult(List <Lotto> purchaseLotto, List <Integer> winningNumbers, int bonusNumber){
        List <Integer> result = Arrays.asList(0,0,0,0,0,0);
        for(int i=0; i<purchaseLotto.size(); i++){
            int index = findLottoResult(purchaseLotto.get(i).getNumbers(), winningNumbers, bonusNumber);
            result.set(index, result.get(index)+1);
        }
        return result;
    }
    public static int findLottoResult(List <Integer> lotto, List <Integer> winningNumbers, int bonusNumber){
        List <Integer> _winningNumbers = new ArrayList<>(winningNumbers);
        _winningNumbers.retainAll(lotto);
        int cntCorrectNum = _winningNumbers.size();
        int checkBonus = 0;
        if(lotto.contains(bonusNumber)){
            checkBonus = 1;
        }
        int index;
        try {
            Win win = Win.valueOf("WIN" + Integer.toString(cntCorrectNum) + Integer.toString(checkBonus));
            index = win.getKey();
        }catch(IllegalArgumentException ex){
            index = noWinIndex;
        }
        return index;
    }

    public static void printLottoResult(List <Integer> lottoResult){
        for(int i= winEnumNames.size()-1; i>=0; i--){
            String message = createLottoResultMessage(lottoResult.get(i), winEnumNames.get(i));
            printMessage(message);
        }
    }
    public static String createLottoResultMessage(int winNumber, String winEnumName){
        DecimalFormat decFormat = new DecimalFormat("###,###");
        Win win = Win.valueOf(winEnumName);
        int cntCorrectNumber = win.getCntCorrectNumber();
        int prize = win.getPrize();
        String message = cntCorrectNumber+"개 일치 ("+decFormat.format(prize)+") - "+winNumber+"개";
        return message;
    }

    public static long calculateTotalPrizeAmount(List <Integer> lottoResult){
        long totalPrizeAmount = 0;
        for(int i= 0; i<winEnumNames.size(); i++){
            String curWinEnumName = winEnumNames.get(i);
            Long prizeAmount = Win.valueOf(curWinEnumName).calculateTotalPrize(lottoResult.get(i));
            totalPrizeAmount = totalPrizeAmount + prizeAmount;
        }
        return totalPrizeAmount;
    }

    public static void printProfitPercentage(double profitPercentage){
        String message = "총 수익률은 "+profitPercentage+"%입니다";
        printMessage(message);
    }

    public static double calculateProfitPercentage(long spentAmount, long totalPrizeAmount){
        double cur = ((double)totalPrizeAmount/spentAmount)*100;
        return Math.round(cur*10)/10.0;
    }
}