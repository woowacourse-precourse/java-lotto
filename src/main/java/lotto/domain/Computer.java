package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Computer {
    public String inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        return numbers;
    }
}
