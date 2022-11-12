package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static void writeBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        String budget = Console.readLine();
        System.out.println();
    }

    private void hasOnlyNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private void isStartedNotZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("0으로 시작하는 금액을 입력하지 마세요");
        }
    }
}
