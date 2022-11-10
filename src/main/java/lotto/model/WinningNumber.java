package lotto.model;

import static lotto.Util.removeSpace;
import static lotto.Util.verifyRangeOfLottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    public static List<Integer> winningNumbers;

    public WinningNumber(String input) {
        this.winningNumbers = validateWinningNumbers(formatInput(input));
    }

    private static List<Integer> formatInput(String input) {
        return convertStringListToIntList(separateStringByComma(removeSpace(input)));
    }

    private static List<Integer> validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨번호를 입력해 주세요.");
        }
        for (Integer winningNumber : numbers) {
            verifyRangeOfLottoNumber(winningNumber);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 입력하신 당첨번호 내에 중복되는 숫자가 존재합니다.");
        }
        return numbers;
    }

    private static List<String> separateStringByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static List<Integer> convertStringListToIntList(List<String> list) {
        return list.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
