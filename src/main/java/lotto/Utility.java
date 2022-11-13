package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import jdk.jshell.execution.Util;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
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

    public static double profitPercentage(long spentAmount, long totalPrizeAmount){
        return Math.round((totalPrizeAmount/spentAmount)*100)/100.0;
    }
}
