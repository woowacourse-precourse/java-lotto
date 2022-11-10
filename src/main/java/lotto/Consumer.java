package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Consumer {
    public int purchaseAmount() throws IllegalArgumentException{
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하지 않으셨습니다.");
        }
    }

    public List<Integer> winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> lottonumbers = Arrays.asList(Console.readLine().split(","))
                .stream()
                .map((s -> Integer.parseInt(s.trim())))
                .collect(Collectors.toList());

        return lottonumbers;
    }
}
