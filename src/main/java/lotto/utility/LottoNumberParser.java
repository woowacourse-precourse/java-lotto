package lotto.utility;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumberParser {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static List<Integer> parseLottoNumbers(String inputNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(inputNumbers.split(Lotto.NUMBER_SEPARATOR)).forEach(digit -> {
            int numberConvert = covertDigitToNumber(digit);
            validateNumberRange(numberConvert);
            lottoNumbers.add(numberConvert);
        });
        return lottoNumbers;
    }

    private static int covertDigitToNumber(String digit) {
        try {
            Integer.parseInt(digit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(digit);
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("당첨 번호는 %d부터 %d까지의 수만 입력할 수 있습니다.", LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            );
        }
    }
}
