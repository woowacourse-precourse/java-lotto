package lotto.domain;

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
    int duplicateRemovedSize = (int) numbers.stream().distinct().count();
    if (duplicateRemovedSize != 6) {
      throw new IllegalArgumentException("중복된 숫자입니다.");
    }
  }

  // TODO: 추가 기능 구현

  public List<Integer> getNumbers() {
    return numbers;
  }
}
