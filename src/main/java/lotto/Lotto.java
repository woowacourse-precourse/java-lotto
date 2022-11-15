package lotto;

import java.util.List;

import static constantValue.LottoUtilNumber.LOTTO_SIZE;
import static error.ErrorLottoNumbers.isDuplicateLottos;
import static constantValue.ErrorMessage.IS_DUPLICATE;
import static constantValue.ErrorMessage.IS_NOT_SIX;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException(IS_NOT_SIX);
    }
    if (isDuplicateLottos(numbers)) {
      throw new IllegalArgumentException(IS_DUPLICATE);
    }
  }

  public int winningRanking(LottoAnswer lottoAnswer) {
    int winning_numbers = 0;

    for (int i = 0; i < 6; i++) {
      if (lottoAnswer.haveNumber(numbers.get(i))) {
        winning_numbers++;
      }
    }
    if (winning_numbers == 5 && numbers.contains(lottoAnswer.getBonusNumber())) {
      return 7;
    }
    return winning_numbers;
  }

  public void printLottoNumbers() {
    System.out.println(numbers.toString());
  }
}
