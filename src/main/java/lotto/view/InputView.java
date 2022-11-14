package lotto.view;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static Pattern NUMBER_ONLY_PATTERN = Pattern.compile("\\d+");

    public long promptAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Long.parseLong(input);
    }

    private void validateNumber(String input) {
        if (!NUMBER_ONLY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다");
        }
    }
}
