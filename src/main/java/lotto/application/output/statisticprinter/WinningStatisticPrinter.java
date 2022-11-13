package lotto.application.output.statisticprinter;

import java.util.Map;

public interface WinningStatisticPrinter {

    Map<String, Integer> showStatistic(Map<String, Integer> winInformation);
}
