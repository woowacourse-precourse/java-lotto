package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호의 개수는 6개여야 한다.");
    }
    for (int i : numbers) {
      if (numbers.indexOf(i) != numbers.lastIndexOf(i)) {
        throw new IllegalArgumentException("로또 번호에 중복된 값이 있어선 안된다.");
      }
    }
    for (int i : numbers) {
      if (i < 1 || i > 45) {
        throw new IllegalArgumentException("로또 번호는 1과 45 사이의 숫자여야 한다.");
      }
    }

  }

  public List<Integer> getNumbers() {
    return numbers;
  }


  @Override
  public String toString() {
    return numbers.toString();
  }
}
