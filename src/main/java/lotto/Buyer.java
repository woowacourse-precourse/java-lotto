package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Buyer {

    private final int MIN_MONEY = 1000;
    private final int MONEY_UNIT = 1000;
    static int money;

    public Buyer() {

    }

    public void payMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        validateMoneyOnlyNumber(inputMoney);
        int money = Integer.parseInt(inputMoney);
        validateMoneyRange(money);
        validateMoneyUnit(money);
        Buyer.money = money;
    }

    public void validateMoneyOnlyNumber(String inputMoney) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, inputMoney)) {
            System.out.println("[ERROR] 금액은 숫자로만 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateMoneyRange(int inputMoney) {
        if (inputMoney < MIN_MONEY) {
            System.out.println("[ERROR] 1000원 이상 내셔야 로또 구매가 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateMoneyUnit(int inputMoney) {
        if (inputMoney % MONEY_UNIT != 0) {
            System.out.println("[ERROR] 1000원 단위로 금액을 입력해야 합니다.");
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력해야 합니다.");
        }
    }
}
