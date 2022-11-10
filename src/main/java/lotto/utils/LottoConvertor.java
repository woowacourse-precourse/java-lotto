package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConvertor {
    public static Lotto mapToLotto(String userInput) {
        return new Lotto(mapToList(userInput));
    }

    private static List<LottoNumber> mapToList(String userInput) {
        String[] lottoNumbers = userInput.split(",");
        return Arrays.stream(lottoNumbers)
                .map(LottoConvertor::mapToLottoNumber)
                .collect(Collectors.toList());
    }

    public static LottoNumber mapToLottoNumber(String lottoNumber) {
        return new LottoNumber(lottoNumber);
    }
}
