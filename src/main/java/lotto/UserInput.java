package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private static final String money = Console.readLine();
    public static String getUserInputMoney(){

        return money;
    }

    public static String[] getUserInputLottoNumber(){

        String number = Console.readLine();

        return number.split(",");
    }

    public static String getUserInputBonusNumber(){

        return Console.readLine();
    }
}
