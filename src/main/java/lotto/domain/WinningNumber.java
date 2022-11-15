package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

  private final List<Integer> numbers;
  private final Integer bonusNumber;

  public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public Integer getBonusNumber() {
    return bonusNumber;
  }

  public List<LottoPrize> draw(List<Lotto> lottos) {
    return lottos.stream().map(this::calculateMatchNumber)
        .collect(Collectors.toList());
  }

  private LottoPrize calculateMatchNumber(Lotto lotto) {
    List<Integer> lottoNumbers = lotto.getNumbers();
    int matchCount = 0;
    int bonusCount = 0;
    for (int lottoNumber : lottoNumbers) {
      if (numbers.contains(lottoNumber)) {
        matchCount++;
      }
    }
    if (numbers.contains(bonusNumber)) {
      bonusCount++;
    }
    return LottoPrize.of(matchCount, bonusCount);
  }
}
