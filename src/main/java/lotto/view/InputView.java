package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int InputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = Integer.valueOf(readLine());
        return input;
    }

    public static List<Integer> InputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        List<Integer> inputs = List.of(input.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return inputs;
    }

    public static int InputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        OnlyOne(input);
        return Integer.valueOf(input);
    }

    private static void OnlyOne(String input) {
        if (input.contains(",") || input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 1개 이상입니다.");
        }
    }
}
