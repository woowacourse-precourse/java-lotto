package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputValidator inputValidator = new InputValidator();
    public static int readAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String readLine = Console.readLine();

        if (readLine.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(readLine);
        }

        throw new IllegalStateException(ErrorCode.ERROR.getMessage());
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String readLine = Console.readLine();
        return Arrays.stream(readLine.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
