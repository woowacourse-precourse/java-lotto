package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputNumbers {
    List<Integer> lottoNumbers;
    Integer bonusNumber;

    public InputNumbers(String numbers, String num) {
        List<String> lottoNumbers = toListLottoNumbers(numbers);

        checkLottoNumbers(lottoNumbers);
        checkBonusNumber(num);
        checkOverlap(lottoNumbers, num);

        this.lottoNumbers = toIntegerLottoNumbers(lottoNumbers);
        bonusNumber = Integer.valueOf(num);
    }

    private List<String> toListLottoNumbers(String numbers){
        return Arrays.asList(numbers.split(","));
    }

    private void checkLottoNumbers(List<String> numbers){
        for (String number : numbers){
            if (!Pattern.matches("^[0-9]*$", number)){
                throw new IllegalArgumentException(Errors.LOTTO_ONLY_NUMBER.getMessage());
            }
        }
    }

    private void checkBonusNumber(String number){
        if (!Pattern.matches("^[0-9]*$", number)){
            throw new IllegalArgumentException(Errors.LOTTO_ONLY_NUMBER.getMessage());
        }
    }

    private void checkOverlap(List<String> lottoNumbers, String num){
        if (lottoNumbers.contains(num)){
            throw new IllegalArgumentException(Errors.OVERLAP.getMessage());
        }
    }

    private List<Integer> toIntegerLottoNumbers(List<String> lottoNumbers){
        return lottoNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
