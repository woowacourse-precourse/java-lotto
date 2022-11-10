package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int money = Integer.parseInt(Console.readLine());
        moneyInputError(money);
    }

    public static void moneyInputError(int money) {
        if (money % 1000 != 0) {
            System.out.println("금액 입력 오류입니다.");
            throw new IllegalArgumentException();
        }
    }
}
