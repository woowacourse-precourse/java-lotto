package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDrawService {

  private final WinningNumber winningNumber;

  public LottoDrawService(WinningNumber winningNumber) {
    this.winningNumber = winningNumber;
  }

  public List<LottoPrize> draw(List<Lotto> lottos) {
    return lottos.stream().map(this::calculateMatchNumber)
        .collect(Collectors.toList());
  }

  private LottoPrize calculateMatchNumber(Lotto lotto) {
    List<Integer> lottoNumbers = lotto.getNumbers();
    List<Integer> winningNumbers = winningNumber.getNumbers();
    Integer bonusNumber = winningNumber.getBonusNumber();
    int matchCount = 0;
    int bonusCount = 0;
    for (int lottoNumber : lottoNumbers) {
      if (winningNumbers.contains(lottoNumber)) {
        matchCount++;
      }
    }
    if (winningNumbers.contains(bonusNumber)) {
      bonusCount++;
    }
    return LottoPrize.of(matchCount, bonusCount);
  }


}
