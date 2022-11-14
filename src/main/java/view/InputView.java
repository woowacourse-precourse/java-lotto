package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputWinningNumber(){
        System.out.println("당첨번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
