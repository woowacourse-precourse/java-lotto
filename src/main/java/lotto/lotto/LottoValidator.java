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

    public static void validateDuplicateNumbers(List<Integer> lottos) {
        for(int i = 0; i < lottos.size(); i++) {
            for(int j = i + 1; j < lottos.size(); j++) {
                if (lottos.get(i).equals(lottos.get(j)))
                    throw new IllegalArgumentException("[ERROR] 로또에는 중복된 숫자가 들어갈 수 없습니다.");
            }
        }
    }

    public static void validateLottoSize(List<Integer> lottos) {
        if (lottos.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 개수는 6개여야 합니다.");
    }
}
