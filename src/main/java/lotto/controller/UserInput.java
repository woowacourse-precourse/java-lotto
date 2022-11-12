package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static void writeBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        String budget = Console.readLine();
        System.out.println();
    }
}
