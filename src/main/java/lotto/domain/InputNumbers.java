package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputNumbers {
    List<Integer> lottoNumbers;
    Integer bonusNumber;

    public InputNumbers(String numbers, String num) {
        List<String> lottoNumbers = toListLottoNumbers(numbers);

        this.lottoNumbers = ToIntegerLottoNumbers(lottoNumbers);
        bonusNumber = Integer.valueOf(num);
    }

    private List<String> toListLottoNumbers(String numbers){
        return Arrays.asList(numbers.split(","));
    }

    private List<Integer> ToIntegerLottoNumbers(List<String> lottoNumbers){
        return lottoNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
