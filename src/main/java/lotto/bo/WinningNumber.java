package lotto.bo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String winningLottoNumbers, String BonusNumber) {
        validateInteger(winningLottoNumbers);
        validateInteger(BonusNumber);

        List<Integer> tmpNumbers = convertStrToNumberList(winningLottoNumbers);
        tmpNumbers.add(Integer.valueOf(BonusNumber));

        validateRange(tmpNumbers);
        validateRange(tmpNumbers);
        this.numbers = Collections.emptyList();
    }

    private List<Integer> convertStrToNumberList(String numbers) {
        List<Integer> result;
        result = Stream.of(numbers.split(","))
                .map(Integer::valueOf).collect(Collectors.toList());
        return result;
    }

    private void validateInteger(String numbers) {
        for (String number : numbers.split(",")) {
            try {
                Integer.valueOf(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닙니다");
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호와 보너스 번호는 1~ 45 사이의 숫자이어야합니다.");
            }
        }
    }
}
