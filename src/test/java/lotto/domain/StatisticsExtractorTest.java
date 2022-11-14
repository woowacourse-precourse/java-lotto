package lotto.domain;

import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumber;
import lotto.dto.LottoDto;
import lotto.dto.StatisticsDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsExtractorTest {

  @Test
  void 올바른_당첨_통계를_반환하는가() {

    // given
    List<Lotto> lottos = List.of(
      new Lotto(List.of(1,2,3,4,5,6)),
      new Lotto(List.of(7,8,9,4,5,6)),
      new Lotto(List.of(7,2,3,4,5,6)),
      new Lotto(List.of(9,2,3,4,5,6)),
      new Lotto(List.of(7,8,3,4,5,6)),
      new Lotto(List.of(39,40,41,42,43,44))
    );
    WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    BonusNumber bonusNumber = new BonusNumber(winningNumber, "9");
    LottoDto dto = new LottoDto(lottos, winningNumber, bonusNumber);
    StatisticsExtractor statisticsExtractor = new StatisticsExtractor();

    // when
    StatisticsDto statistics = statisticsExtractor.extract(dto);

    // then
    assertEquals(statistics.getSame3Num(), 1);
    assertEquals(statistics.getSame4Num(), 1);
    assertEquals(statistics.getSame5Num(), 1);
    assertEquals(statistics.getSame5AndBonusNum(), 1);
    assertEquals(statistics.getSame6Num(), 1);
  }

}