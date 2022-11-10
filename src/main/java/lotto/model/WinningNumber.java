package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    public WinningNumber() {
        List<String> winningNumbers;
        // 당첨번호 입력
        String input = removeSpace(Console.readLine());
        winningNumbers = Arrays.asList(input.split(","));
        System.out.println(winningNumbers);
    }

    private String removeSpace(String input) {
        return input.replaceAll("\\s" , "");
    }
}
