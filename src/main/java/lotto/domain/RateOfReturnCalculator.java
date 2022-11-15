package lotto.domain;

import lotto.domain.constant.LottoInfo;
import lotto.domain.constant.PrizeMoney;
import lotto.domain.model.LottoNum;
import lotto.dto.StatisticsDto;

public class RateOfReturnCalculator {

  public String calculate(StatisticsDto dto, LottoNum lottoNum) {
    float profit = dto.getSame3Num() * PrizeMoney.SAME_THREE.getPrizeMoney()
                  + dto.getSame4Num() * PrizeMoney.SAME_FOUR.getPrizeMoney()
                  + dto.getSame5Num() * PrizeMoney.SAME_FIVE.getPrizeMoney()
                  + dto.getSame5AndBonusNum() * PrizeMoney.SAME_FIVE_AND_BONUS.getPrizeMoney()
                  + dto.getSame6Num() * PrizeMoney.SAME_SIX.getPrizeMoney();
    double rate = profit / (lottoNum.getLottoNum() * LottoInfo.LOTTO_PRICE.getValue()) * 100;
    return String.format("%.1f", rate) + "%";
  }

}
