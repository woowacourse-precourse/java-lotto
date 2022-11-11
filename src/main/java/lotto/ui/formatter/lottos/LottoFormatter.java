package lotto.ui.formatter.lottos;

import lotto.domain.lotto.Lotto;
import lotto.ui.formatter.OutputFormatter;

public class LottoFormatter implements OutputFormatter<Lotto> {
	@Override
	public String outputFormat(Lotto lotto) {
		return lotto.formatString();
	}
}
