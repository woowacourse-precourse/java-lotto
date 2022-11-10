package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    public WinningNumber() {
        List<Integer> winningNumbers;
        // 당첨번호 입력
        String input = Console.readLine();
        String[] split = input.split(",");
        System.out.println(Arrays.toString(split));

    }
}
