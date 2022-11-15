package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.ERROR_MESSAGE_OF_LOTTO_NUMBERS;
import static lotto.domain.lotto.Lotto.lottoNumberCount;
import static lotto.domain.lotto.LottoNumbers.removeDuplicateNumbers;
import static lotto.domain.lotto.LottoNumbers.validateLottoNumbers;

import java.util.List;
import lotto.domain.utils.Input;

public class LottoWinningNumbers {

  private List<Integer> numbers;
  public static final String INPUT_MESSAGE_OF_GETTING_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

  public LottoWinningNumbers() {

    printWinningNumberMessage();
    List<Integer> winningNumbers = Input.toIntegerArray();
    validateWinningNumbers(winningNumbers);
    this.numbers = winningNumbers;
  }

  /*
   * 당첨 번호에 대한 검증
   */
  public static void validateWinningNumbers(List<Integer> numbers) {
    validateLottoNumbers(numbers);
    numbers = removeDuplicateNumbers(numbers);
    if (numbers.size() != lottoNumberCount()) {
      throw new IllegalArgumentException(ERROR_MESSAGE_OF_LOTTO_NUMBERS);
    }
  }

  private void printWinningNumberMessage() {
    System.out.println();
    System.out.println(INPUT_MESSAGE_OF_GETTING_WINNING_NUMBERS);
  }

  public List<Integer> getWinningNumbers() {
    return numbers;
  }
}
