package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int getAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return validateNumber(Console.readLine());
    }

    public List<Integer> getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return convertToList(Console.readLine());
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return validateNumber(Console.readLine());
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ok) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(","))
                .map(this::validateNumber)
                .collect(Collectors.toList());
    }
}
