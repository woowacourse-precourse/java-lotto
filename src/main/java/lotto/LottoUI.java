package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUI {
    private LottoUI() {
    }

    public static List<Integer> getLottoNumber() {
        String[] input = Console.readLine().trim().split(",");

        return Arrays.stream(input)
                .peek(eachNumber -> validateIsNumber(eachNumber))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validateIsNumber(String each) {
        try {
            Integer.parseInt(each);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }
}
