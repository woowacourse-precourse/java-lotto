package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        return Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public Integer getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return getInteger();
    }

    public Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getInteger();
    }

    private static Integer getInteger() {
        String input = readLine();
        return Integer.valueOf(input);
    }

}
