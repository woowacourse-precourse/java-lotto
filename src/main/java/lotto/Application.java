package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static List<Integer> winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> lottonumbers = Arrays.asList(Console.readLine().split(","))
                .stream()
                .map((s -> Integer.parseInt(s.trim())))
                .collect(Collectors.toList());

        return lottonumbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Lotto lotto = new Lotto(Application.winningNumber());
            int amount = lotto.purchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s\n",e.getMessage());
        }
    }
}
