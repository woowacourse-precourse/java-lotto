package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputNumbers {
  private static final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야합니다.";
  private static final String OVERLAP_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 존재합니다.";
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
        throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
      }
    }
  }

  private void checkBonusNumber(String number){
    if (!Pattern.matches("^[0-9]*$", number)){
      throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
    }
  }

  private void checkOverlap(List<String> lottoNumbers, String num){
    if (lottoNumbers.contains(num)){
      throw new IllegalArgumentException(OVERLAP_ERROR_MESSAGE);
    }
  }

  private List<Integer> toIntegerLottoNumbers(List<String> lottoNumbers){
    return lottoNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
  }
}