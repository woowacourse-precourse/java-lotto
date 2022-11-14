package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int user_buy_num = HowManyLotto();
    }

    static int HowManyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int input_money = Integer.parseInt(input);
        return input_money / 1000;
    }
}
