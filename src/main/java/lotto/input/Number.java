package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class Number {

    public String getLuckyNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    private void validate() {
        throw new IllegalArgumentException();
    }
}
