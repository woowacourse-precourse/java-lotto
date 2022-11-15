package lotto.util;

import lotto.domain.Lotto;
import lotto.exception.winningnumber.WinningNumberFormatException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLottoNumberConverter {
    private static final String DELIMITER = ",";

    public static Lotto convert(String winningLottoNumber) {
        try {
            return new Lotto(Arrays.stream(winningLottoNumber.split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new WinningNumberFormatException();
        }
    }
}
