package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void ui () {
        inputMoney();
    }

    private int inputMoney () {
        String money;

        System.out.println("구입 금액을 입력해주세요.");
        money = Console.readLine();
        isRealNumber(money);

        return Integer.parseInt(money);
    }

    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 49 || element > 57) throw new IllegalArgumentException();
        }
    }
}
