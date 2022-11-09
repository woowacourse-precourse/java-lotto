package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static Integer inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        System.out.println();
        return Integer.parseInt(inputMoney);
    }

    public static String inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
