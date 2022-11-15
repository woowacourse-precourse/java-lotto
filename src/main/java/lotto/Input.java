package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        return Integer.parseInt(input);
    }

    public List<Integer> winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().trim().split(",");
        List<String> stringList = Arrays.asList(input);
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        return Integer.parseInt(input);
    }
}
