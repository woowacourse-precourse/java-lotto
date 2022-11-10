package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startMessage();
        Money money = new Money(Console.readLine());
    }

    public static void startMessage() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
}
