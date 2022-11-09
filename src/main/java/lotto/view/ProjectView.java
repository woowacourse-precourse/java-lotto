package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ProjectView {
    public static String askPurchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void sell(int sellCount){
        System.out.println("\n" + sellCount + "개를 구매했습니다.");
    }
}
