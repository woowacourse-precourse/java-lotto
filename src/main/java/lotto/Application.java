package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.MyIllegalArgumentException;

public class Application {
    public static void main(String[] args) {
        Receipt receipt;
        String input;
        try {
            input = askMoney();
            receipt = new Receipt(input);
        } catch (MyIllegalArgumentException e) {
            e.printErrorMessage();
            return;
        }
    }

    /**
     * 사용자 입력 메서드
     */
    private static String askMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        return Console.readLine();
    }
}
