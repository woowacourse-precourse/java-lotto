package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private static final String money = Console.readLine();
    private static final String number = Console.readLine();

    public static String getUserInputMoney(){

        return money;
    }

    public static String[] getUserInputLottoNumber(){

        return number.split(",");
    }

    public static String getUserInputBonusNumber(){

        return Console.readLine();
    }
}
