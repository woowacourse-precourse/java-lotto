package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyString =Console.readLine();
        int moneyInt = moneyExceptionHandling(moneyString);
    }

    public static int moneyExceptionHandling(String moneyString){
        int moneyInt;
        try{
            moneyInt = parseInt(moneyString);
        }
        catch(NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if(moneyInt%1000!=0){
            System.out.println("[ERROR] 금액을 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
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
}
