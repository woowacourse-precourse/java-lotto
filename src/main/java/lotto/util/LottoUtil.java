package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    public static List<Integer> lottoNumbersParser(String inputLottoNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(inputLottoNumbers.split(",")).map(number -> lottoNumbers.add(Integer.parseInt(number)))
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public static int bonusNumberParser(String inputBonusNumber) {
        int bonusNumber = 0;

        return bonusNumber;
    }
}
