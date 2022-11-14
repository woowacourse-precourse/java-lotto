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
        int user_buy_num = input_money / 1000;

        if (input_money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.");
        }

        System.out.println("\n" + user_buy_num + "개를 구매했습니다.");
        return user_buy_num;
    }
}
