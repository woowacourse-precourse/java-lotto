package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }

    }
}
