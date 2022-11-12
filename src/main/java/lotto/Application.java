package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 로또 구입 금액을 입력 받는다.
        System.out.println("구입금액을 입력해 주세요.");
        Price price = new Price(Console.readLine());
    }
}
