package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputOutput {

    public int getMoneyInput() {
        String inputMoney = Console.readLine();
        int money = gameStringToInt(inputMoney);
        return money;
    }

    private int gameStringToInt(String inputMoney) {
        int money = 0;

        money = stringToInt(inputMoney);

        checkIsDevineable1000(money);

        return money;
    }

    private int stringToInt(String string) {
        int interger = 0;
        try {
            interger = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        return interger;
    }

    private void checkIsDevineable1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 떨어지는 숫자를 입력해주세요.");
        }
    }

}
