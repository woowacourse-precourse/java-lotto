package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class Generator {

    public static Integer purchasePrice() {
        String userMoney;
        System.out.println("구입 금액을 입력하세요 : ");
        userMoney = Console.readLine();

        return Integer.parseInt(userMoney);
    }

    public static int calculateLottoNum(int userMoney) {

        if (userMoney % 1000 == 0) {
            return userMoney / 1000;
        }
        return 0;
    }

    public static boolean checkValidation(String userMoney) {
        String regExp = "^[1-9]*0{3}$";
        if (Pattern.matches(regExp, userMoney)) {
            return true;
        }
        throw new IllegalArgumentException(Message.ERROR + Message.ERROR_MESSAGE_WON);
    }





}
