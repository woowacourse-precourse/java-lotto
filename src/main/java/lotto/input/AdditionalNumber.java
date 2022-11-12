package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class AdditionalNumber {
    public int getBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return Integer.parseInt(input);
    }
}