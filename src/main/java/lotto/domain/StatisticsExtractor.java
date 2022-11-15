package lotto.domain;

import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumber;
import lotto.dto.LottoDto;
import lotto.dto.StatisticsDto;

import java.util.List;

public class StatisticsExtractor {

  /**
   * int[] statistics의
   * index 0번에는 3개 일치 갯수,
   * index 1번에는 4개 일치 갯수,
   * index 2번에는 5개 일치 갯수,
   * index 3번에는 6개 일치 갯수,
   * index 4번에는 5개일치 + 보너스넘버 일치 갯수
    */
  private int[] statistics;

  public StatisticsExtractor() {
    this.statistics = new int[5];
  }

  public StatisticsDto extract(LottoDto lottoDto) {
    calculateResult(lottoDto.getMyLottos(), lottoDto.getWinningNumber(), lottoDto.getBonusNumber());
    return new StatisticsDto(statistics[0], statistics[1], statistics[2], statistics[4], statistics[3]);
  }

  private void calculateResult(List<Lotto> lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
    for (Lotto lotto : lottos) {
      List<Integer> myLotto = lotto.getNumbers();
      countMatch(myLotto, winningNumber.getWinningNumber(), bonusNumber);
    }
  }

  private void countMatch(List<Integer> myLotto, List<Integer> winningNumber, BonusNumber bonusNumber) {
    int sum = 0;
    for (Integer number : winningNumber) {
      if (myLotto.contains(number)) sum++;
    }
    if (sum > 2) {
      statistics[sum - 3]++;
    }
    if (sum == 5) {
      countBonusMatch(myLotto, bonusNumber);
    }
  }

  private void countBonusMatch(List<Integer> myLotto, BonusNumber bonusNumber) {
    if(myLotto.contains(bonusNumber.getBonusNum())) {
      statistics[2]--;
      // 5개 일치에서 1을 빼고
      statistics[4]++;
      // 5개 + 보너스 일치에 1을 더함
    }
  }
}
