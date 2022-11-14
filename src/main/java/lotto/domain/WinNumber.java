package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinNumber {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자, 쉼표 외의 문자를 입력하셨습니다.";
    private Lotto winNumbers;
    private int bonusNumber;

    public WinNumber(String winNumbers, String bonusNumber) {
        validateType(winNumbers);

        this.winNumbers = new Lotto(toLotto(winNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateType(String number) {
        if (!number.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private List<Integer> toLotto(String inputNumber) {
        return Stream.of(inputNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
