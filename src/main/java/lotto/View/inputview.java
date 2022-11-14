package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class inputview {
    private static final String input_money = "구입금액을 입력해 주세요.";
    private static final String input_lucky = "당첨 번호를 입력해 주세요.";
    private static final String input_bonus = "보너스 번호를 입력해 주세요.";

    public static String In_money(){
        System.out.println(input_money);
        return Console.readLine();
    }

    public static String In_lucky(){
        System.out.println(input_lucky);
        return Console.readLine();
    }

    public static String In_bonus(){
        System.out.println(input_bonus);
        return Console.readLine();
    }
}
