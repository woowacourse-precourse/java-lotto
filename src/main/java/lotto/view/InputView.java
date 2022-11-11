package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static Integer requestPurchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney=Console.readLine();
        return Integer.parseInt(inputMoney);
    }
    public static void requestLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void requestBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
