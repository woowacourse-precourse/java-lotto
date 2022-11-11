package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String  inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        return inputMoney;
    }

    public static String inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static Integer inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
