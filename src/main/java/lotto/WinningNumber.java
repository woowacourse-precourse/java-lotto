package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    public List<Integer> getWinningNumber() {
        List<Integer> result = new ArrayList<>();

        // 당첨번호 입력
        String[] input = Console.readLine().split(",");
        for (String number : input) {
            result.add(Integer.parseInt(number));
        }
        // 보너스 번호 입력
        result.add(Integer.parseInt(Console.readLine()));

        return result;
    }
}
