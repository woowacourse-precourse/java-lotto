package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static lotto.ErrorMsg.ERRMSG;

public class InputUser {
    public static int inputUserPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String userPrice = Console.readLine();
        try {
            validateValue(userPrice);
            int price = Integer.parseInt(userPrice);
            divideValidate(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputUserPrice();
        }
    }
    public static void validateValue(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
    public static void divideValidate(int price) {
        if (price % 1000 != 0){
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
}