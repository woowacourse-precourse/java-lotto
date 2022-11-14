package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String INPUT_PRICE = "구입금액을 입력해주세요";
    private static final String BUY_COUNT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static Integer getInputPrice() {
        System.out.println(INPUT_PRICE);
        String input = Console.readLine();
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        Integer inputPrice = Integer.parseInt(input);
        if (inputPrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
        if (inputPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        return inputPrice;
    }

}
