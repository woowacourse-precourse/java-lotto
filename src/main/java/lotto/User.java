package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_FORMAT_ERROR_MESSAGE = "[ERROR] 구입금액은 숫자만 입력해주세요.";
    private static final String MONEY_FORMAT_ERROR_MESSAGE = "[ERROR] 구입금액은 1000원 단위로 입력해주세요.";

    public int purchaseLotto() {
        int money;
        try {
            System.out.println(INPUT_MESSAGE);
            String input = Console.readLine();
            System.out.println();  // 출력형식에 맞도록 줄바꿈 삽입

            if (!input.matches("^[0-9]+$")) {
                throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE);
            }
            money = Integer.parseInt(input);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException(MONEY_FORMAT_ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return money / 1000;
    }


}
