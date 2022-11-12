package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static Integer inputMoney() {
        final String input = getInput();
    }

    private static String getInput() {
        try {
            return Console.readLine();
        } catch (Exception exception) {
            System.out.println("[ERROR] 빈 문자열을 입력할 수 없습니다");
            throw new IllegalArgumentException();
        }
    }
}
