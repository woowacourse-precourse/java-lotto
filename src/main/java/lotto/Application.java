package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import static java.lang.Integer.parseInt;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Logger;


public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyString =Console.readLine();
        int moneyInt = moneyExceptionHandling(moneyString);
        List<List<Integer>> lottoList = makeLottoList(moneyInt);

        System.out.printf("\n%d개를 구매했습니다.\n",moneyInt);
        printLottoList(lottoList);

        System.out.println("\n당첨 번호를 입력해주세요");
        String winNumberString = Console.readLine();
        System.out.println("\n보너스 번호를 입력해주세요");
        String bonusNumString = Console.readLine();
        List<Integer> winNumberList = makeWinNumberList(winNumberString);
        int bonusNumber = bonusNumber(bonusNumString);

        Lotto currentLotto = new Lotto(winNumberList);
        currentLotto.setBonus(bonusNumber);
        for(int i = 0; i<moneyInt;i++){
            currentLotto.lottoNumberCompare(lottoList.get(i));
        }
        printStatistic(currentLotto.getWinNums(), currentLotto.getReturnRate(moneyInt));
    }

    public static int moneyExceptionHandling(String moneyString){
        int moneyInt;
        try{
            moneyInt = parseInt(moneyString);
        }
        catch(NumberFormatException e){
            System.out.println("[ERROR] 금액을 다시 확인해주세요.");
            throw new IllegalArgumentException("[ERROR] 금액을 다시 확인해주세요.");
        }
        if(moneyInt%1000!=0){
            System.out.println("[ERROR] 금액을 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해주세요.");
        }
        return moneyInt/1000;
    }

    public static List<List<Integer>> makeLottoList(int num){
        List<List<Integer>> lottos = new java.util.ArrayList<>(Collections.emptyList());
        for(int i = 0; i<num;i++){
            List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(newLotto);
        }
        return lottos;
    }

    public static void printLottoList(List<List<Integer>> lottoList){
        for(int i = 0; i< lottoList.size(); i++){
            System.out.println(lottoList.get(i));
        }
    }

    public static List<Integer> makeWinNumberList(String winNumberString){
        List<Integer> winNumberList = new java.util.ArrayList<>(Collections.emptyList());
        try{
            String[] numListStr = winNumberString.split(",");
            for(int i = 0; i< numListStr.length;i++){
                winNumberList.add(Integer.parseInt(numListStr[i]));
            }
        }catch(Exception e){
            System.out.println("[ERROR] 당첨번호를 쉼표(,)를 사용해 구분해 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return winNumberList;
    }

    public static int bonusNumber(String bonusNumStr){
        int bonusNumber=0;
        try{
            bonusNumber = Integer.parseInt(bonusNumStr);
        }catch(Exception e){
            System.out.println("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if(bonusNumber<0 || bonusNumber > 45){
            System.out.println("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public static void printStatistic(List<Integer> winTimes, float returnRate){
        System.out.println("당첨 통계\n---");
        String str[] = {"3개 일치 (5,000원) - ", "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - "};
        for(int i = 0; i < 5; i++){
            System.out.println(str[i] + winTimes.get(i) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", returnRate);
    }
}
