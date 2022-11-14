package lotto.view;

import lotto.domain.constant.StatisticsMessage;
import lotto.dto.StatisticsDto;

public class StatisticsView {

  public void print(StatisticsDto dto) {
    System.out.println(StatisticsMessage.STATISTICS.print(dto));
  }
}
