package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요");
        String money_input = Console.readLine();
        int money = Integer.MAX_VALUE;
        int num = 0;
        try {
            money = Integer.parseInt(money_input);
            num = Money.num_lotto(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error]" + e.getMessage());
        }



        // TODO: 프로그램 구현
    }
}
