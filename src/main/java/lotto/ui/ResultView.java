package lotto.ui;

import lotto.domain.lotto.Lottos;
import lotto.domain.winningresult.WinningResults;
import lotto.ui.formatter.OutputFormatter;

public class ResultView {
	private static final String LINE_BREAK = "\n";

	private final OutputFormatter<Lottos> lottosOutputFormatter;
	private final OutputFormatter<WinningResults> resultOutputFormatter;

	public ResultView(OutputFormatter<Lottos> lottosOutputFormatter,
		OutputFormatter<WinningResults> resultOutputFormatter) {
		this.lottosOutputFormatter = lottosOutputFormatter;
		this.resultOutputFormatter = resultOutputFormatter;
	}

	public void printDrawnLottos(Lottos lottos) {
		System.out.print(LINE_BREAK);
		System.out.println(lottosOutputFormatter.outputFormat(lottos));
	}
}
