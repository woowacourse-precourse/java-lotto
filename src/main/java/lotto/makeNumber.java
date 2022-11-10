package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class makeNumber {
    public makeNumber(){}

    public static String getAmountInput() {
        String money;
        System.out.println("구입 금액을 입력해주세요.");
        return money = Console.readLine();
    }
    public static String getWinningNumber() {
        String winningNumber;
        System.out.println("당첨 번호를 입력해주세요.");
        return winningNumber = Console.readLine();
    }
    public static String getBonusNumber() {
        String bonusNumber;
        System.out.println("보너스 번호를 입력해주세요.");
        return bonusNumber = Console.readLine();
    }
    public static Set<Integer> makeWinningNumber(String winningNumber,String bonusNumber){
        Set<Integer> winner=new HashSet<>();
        addNumber(winningNumber,bonusNumber,winner);
        return winner;
    }
    public static void addNumber(String winningNumber,String bonusNumber,Set<Integer> winner){
        for(String str:winningNumber.split(",")){
            winner.add(Integer.parseInt(str));
        }
        winner.add(Integer.parseInt(bonusNumber));
    }
    public static int buyLotto(String money){
        int lotto=Integer.parseInt(money)/1000;
        System.out.println(lotto+"개를 구매했습니다.");
        return lotto;
    }
    public static List<Integer> randomLotto(){
        List<Integer> number=new ArrayList<>();
    return number= Randoms.pickUniqueNumbersInRange(1,45,6);
    }



}
