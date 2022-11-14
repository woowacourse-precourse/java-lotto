package lotto.lotto;

import java.util.LinkedList;
import java.util.List;

public class LottoValidator {

    public static void validateLottoNumber(String num) {
        validateInteger(num);
        Integer number = Integer.parseInt(num);
        if (!(0 < number && number < 46))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }


    private static void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정상적인 정수를 입력해주세요." + userInput);
        }
    }

    public static List<Integer> parseCommaString(String input) {
        int prev = 0;
        int offset = 0;
        List<Integer> result = new LinkedList<>();
        while ((offset = input.indexOf(',', prev)) != -1) {
            String num = input.substring(prev, offset);
            validateLottoNumber(num);
            result.add(Integer.parseInt(num));
            prev = offset + 1;
        }
        String num = input.substring(prev);
        validateLottoNumber(num);
        result.add(Integer.parseInt(num));
        return (result);
    }
}
