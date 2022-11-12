package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    static int check_money(){
        String input_money;
        int money;
        System.out.println("구입금액을 입력해 주세요");
        input_money = Console.readLine();
        if (input_money.isBlank()) throw new IllegalArgumentException();
        try {
            money = Integer.parseInt(input_money);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return money;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        check_money();

    }
}
