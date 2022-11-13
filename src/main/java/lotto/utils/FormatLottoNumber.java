package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatLottoNumber {

    public static List<Integer> get(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
