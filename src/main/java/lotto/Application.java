package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int NumberOfLotto = getNumberOfLotto();
    }

    public static int getNumberOfLotto() {
        String input = Console.readLine();
        int money = 0;
        if (!input.matches("[+-]?\\d*(\\.\\d+)?"))
            throw new IllegalArgumentException("[ERROR] 금액을 제대로 입력해주세요.");
        money = Integer.parseInt(input);
        return money / 1000;
    }
}
