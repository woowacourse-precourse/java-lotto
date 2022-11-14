package lotto;

import java.util.Iterator;
import java.util.List;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException();
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
    Iterator<Integer> iter = numbers.iterator();
    System.out.print("[");
    while (iter.hasNext()) {
      System.out.print(iter.next());
      if (iter.hasNext())
        System.out.print(", ");
    }
    System.out.println("]");
  }
}
