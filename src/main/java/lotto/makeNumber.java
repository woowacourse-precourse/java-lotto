package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class makeNumber {

    public static String getAmountInput() {
        String money;
        System.out.println("구입 금액을 입력해주세요.");
        return money = Console.readLine();
    }
    public static int buyLotto(String money){
        int lotto=Integer.parseInt(money)/1000;
        System.out.println(lotto+"개를 구매했습니다.");
        return lotto;
    }
    public static List<Integer> randomLotto(List<Integer> number){
    return number= Randoms.pickUniqueNumbersInRange(1,45,6);
    }



}
