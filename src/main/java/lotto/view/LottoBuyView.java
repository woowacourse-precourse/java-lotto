package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyView {

    public int buyLotto() {

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateInputMoney(input);
        int buyMoney = Integer.parseInt(input);

        return buyMoney / 1000;
    }

    public void validateInputMoney(String input) {

        checkOnlyInteger(input);
        checkMinimumAmount(input);
        checkOverFlow(input);
        checkMonetaryUnit(input);
    }

    public void checkMinimumAmount(String input) {
        if (input.length() < 4) {
            throw new IllegalArgumentException("[ERROR] 최소 구매 금액은 1,000원 이상입니다.");
        }
    }

    public void checkMonetaryUnit(String input) {

        int lastIndex = input.length() - 1;

        for (int i = 0; i < 3; i++) {
            if ((input.charAt(lastIndex - i) != '0')) {
                throw new IllegalArgumentException("[ERROR] 구매 금액의 최소 단위는 1,000 입니다. 1,000 단위로 다시 입력해주세요.");
            }
        }
    }

    public void checkOverFlow(String input) {

        if (input.length() > 9) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 최대 10억 미만으로 입력해야 합니다.");
        }
    }

    public void checkOnlyInteger(String input) {

        char value;
        for (int i = 0; i < input.length(); i++) {
            value = input.charAt(i);
            if (value < '1' || value > '9') {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력되어야 합니다.");
            }
        }
    }
}
