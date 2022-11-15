package lotto.domain;

import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNum;
import lotto.domain.model.WinningNumber;
import lotto.dto.StatisticsDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RateOfReturnCalculatorTest {

  @Test
  void 올바른_수익률을_반환하는가() {

    // given
    RateOfReturnCalculator rateOfReturnCalculator = new RateOfReturnCalculator();
    StatisticsDto dto = new StatisticsDto(1,0,0,0,0);

    // when
    String rateOfReturn = rateOfReturnCalculator.calculate(dto, new LottoNum("8000"));

    // then
    assertEquals(rateOfReturn, "62.5%");
  }

}