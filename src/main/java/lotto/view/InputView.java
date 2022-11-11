package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        isDigit(money);
        canDivideByKilo(money);
        return Integer.parseInt(money);
    }

    private static void isDigit(String money) {
        if(!money.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        }
    }

    private static void canDivideByKilo(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천 원단위로 입력해 주세요.");
        }
    }
}
