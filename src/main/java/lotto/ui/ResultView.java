package lotto.ui;

import lotto.domain.lotto.Lottos;
import lotto.domain.winningresult.LottoStatistics;
import lotto.ui.formatter.OutputFormatter;

public class ResultView {
    private static final String LINE_BREAK = "\n";

    private final OutputFormatter<Lottos> lottosOutputFormatter;
    private final OutputFormatter<LottoStatistics> lottoStatisticsFormatter;

    public ResultView(OutputFormatter<Lottos> lottosOutputFormatter,
                      OutputFormatter<LottoStatistics> lottoStatisticsFormatter) {
        this.lottosOutputFormatter = lottosOutputFormatter;
        this.lottoStatisticsFormatter = lottoStatisticsFormatter;
    }

    public void printDrawnLottos(Lottos lottos) {
        System.out.print(LINE_BREAK);
        System.out.println(lottosOutputFormatter.outputFormat(lottos));
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        System.out.print(LINE_BREAK);
        System.out.println(lottoStatisticsFormatter.outputFormat(lottoStatistics));
    }
}
