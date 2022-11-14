package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public int purchaseLotto() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        System.out.println();  // 출력형식에 맞도록 줄바꿈 삽입
        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }


}
