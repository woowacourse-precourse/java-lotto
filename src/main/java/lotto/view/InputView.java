package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.Error.NUMBER_FORMAT_ERROR;

public class InputView {

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = 0;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(NUMBER_FORMAT_ERROR.getMessage());
        }
        return input;
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
