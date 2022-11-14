package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        int money = Integer.parseInt(input);

    }

    public static void validate(String input) {
        int money = -1;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]");
            new IllegalArgumentException("[ERROR]");
        }

        if (money % 1000 != 0) {
            System.out.println("[ERROR]");
            new IllegalArgumentException("[ERROR]");
        }
    }
}
