package lotto.application.output.statisticprinter;

import java.util.Map;

public class WinningStatisticPrinterImpl implements WinningStatisticPrinter {

    @Override
    public Map<String, Integer> showStatistic(Map<String, Integer> winInformation) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",
                winInformation.get("three"));
        System.out.printf("4개 일치 (50,000원) - %d개\n",
                winInformation.get("four"));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",
                winInformation.get("five"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
                winInformation.get("fiveContainingBonusNumber"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",
                winInformation.get("six"));

        return winInformation;
    }
}
