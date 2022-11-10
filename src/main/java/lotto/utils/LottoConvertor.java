package lotto.utils;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConvertor {
    public static Lotto mapToLotto(String userInput) {
        return new Lotto(mapToList(userInput));
    }

    private static List<Integer> mapToList(String userInput) {
        String[] lottoNumbers = userInput.split(",");
        UserInputValidator.validateLottoSize(lottoNumbers);
        return Arrays.stream(lottoNumbers)
                .map(LottoConvertor::mapToInt)
                .collect(Collectors.toList());
    }

    public static int mapToInt(String lottoNumber) {
        UserInputValidator.validateLottoNumber(lottoNumber);
        return Integer.parseInt(lottoNumber);
    }
}
