package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {

    public static String LottoInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        return input;
    }

}
