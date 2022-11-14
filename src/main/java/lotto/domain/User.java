package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int payPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userInput = Console.readLine();
        return convertToInt(userInput);
    }

    private int convertToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
            throw new IllegalArgumentException();
        }
    }
}
