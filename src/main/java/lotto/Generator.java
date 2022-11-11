package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class Generator {

    public Integer purchasePrice() {
        String userMoney;
        System.out.println("구입 금액을 입력하세요 : ");
        userMoney = Console.readLine();

        if (checkValidation(userMoney)) {
            return Integer.parseInt(userMoney);
        }
        return 0;
    }

    public int calculateLottoNum(int userMoney) {
        return userMoney / 1000;
    }

    public boolean checkValidation(String userMoney) {
        String regExp = "^[1-9]*0{3}$";
        if (Pattern.matches(regExp, userMoney)) {
            return true;
        }
        throw new IllegalArgumentException(Message.ERROR + Message.ERROR_MESSAGE_WON);
    }

}
